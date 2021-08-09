package com.bit;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.bit.domain.Board;
import com.bit.persistence.BoardRepository;

//@RunWith(SpringRunner.class) 버전이 낮은곳에서 쓸때
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BoardRepositoryTests {
	
	@Autowired
	private BoardRepository bRepo;
	
	//없어도 됨
	@Test
	public void testCreate() {
		System.out.println("테이블 생성");
	}
	
	// 더미 데이터 200개 입력
	@Test
	public void testInsert200() {
		for(int i = 0; i <200; i++) {
			Board board = new Board();
			board.setTitle("제목..." + i);
			board.setContent("내용.."+ i + "채우기");
			board.setWriter("user0" + (i%10)); // user00 user01..09반복
			bRepo.save(board);
		}
	}
	
	@Test
	public void testByTitle() {
		//옛날버전
		List<Board> results = bRepo.findByTitle("제목...177");
		for (int i = 0; i < results.size(); i++) {
			Board board = results.get(i);
			System.out.println(board);
			
		}
		System.out.println("------------------");
		for (Board board : results) {
			System.out.println(board);
			
		}
		System.out.println("람다방식 1 ------------------");
		results.forEach(board->System.out.println(board));
	}
	
	@Test
	public void testByWriter() {
		Collection<Board> results = bRepo.findByWriter("user05");
		results.forEach(board->System.out.println(board));
		System.out.println("--------------------");
		bRepo.findByWriter("user05").forEach(board->System.out.println(board));
	}
	
	@Test
	public void testContent() {
		bRepo.findByContent("내용..155채우기").forEach(board->System.out.println(board));
		
	}
	
	@Test //Containing : like '%7%'
	public void testByTitleContaining() {
		bRepo.findByTitleContaining("7").forEach(board->System.out.println(board));
	}
	
	@Test //EndingWith : like '%9채우기'
	public void testByContentEndingWith() {
		bRepo.findByContentEndingWith("9채우기").forEach(board->System.out.println(board));
	}
	
	@Test //EndingWith : like '%7'
	public void testByWriterEndingWith() {
		bRepo.findByWriterEndingWith("7").forEach(board->System.out.println(board));
	}
	
	@Test //StartingWith : like '제목...2%'
	public void testByTitleStartingWith() {
		bRepo.findByTitleStartingWith("제목...2").forEach(board->System.out.println(board));
	}
}
