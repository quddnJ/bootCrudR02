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
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.bit.domain.Board;
import com.bit.persistence.BoardRepository2;

//@RunWith(SpringRunner.class) 버전이 낮은곳에서 쓸때
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BoardRepositoryTests2 {
	
	@Autowired
	private BoardRepository2 bRepo;
	
	@Test //title과 writer : or 조건
	public void testByTitleOrWriter() {
		bRepo.findByTitleOrWriter("제목...6","user09").forEach(board->System.out.println(board));
	}
	
	@Test //title과 content : and 조건
	public void testByTitleAndContent() {
		bRepo.findByTitleAndContent("제목...6","내용..6채우기").forEach(board->System.out.println(board));
	}
	
	@Test //bno between 10 and 20
	public void testByBnoBetween() {
		bRepo.findByBnoBetween(10L, 20L).forEach(board->System.out.println(board));
	}
	
	@Test //bno >50
	public void testByBnoGreaterThan() {
		bRepo.findByBnoGreaterThan(50L).forEach(board->System.out.println(board));
	}
	
	@Test //bno <=100
	public void testByBnoLessThanEqual() {
		bRepo.findByBnoLessThanEqual(100L).forEach(board->System.out.println(board));
	}
	
	@Test // or%like : title like '%제목...6%' or content like '%내용..6채우기%'
	public void testByTitleContainingOrContentContaining() {
		bRepo.findByTitleContainingOrContentContaining("제목...6", "내용..6채우기")
		.forEach(board->System.out.println(board));
	}
	
	@Test // like%and : title like '%제목...6%' and bno > 10
	public void testByTitleContainingAndBnoGreaterThan() {
		bRepo.findByTitleContainingAndBnoGreaterThan("제목...6", 10L)
		.forEach(board->System.out.println(board));
	}
	
	@Test // >&desc: bno > 150 order by bno desc
	public void testByBnoGreaterThanOrderByBnoDesc() {
		bRepo.findByBnoGreaterThanOrderByBnoDesc(150L)
		.forEach(board->System.out.println(board));
	}
	
	@Test //bno > ? order by bno desc limit ?,?
	public void testByBnoOrderByPaging() {
		Pageable paging = PageRequest.of(0, 10);
		bRepo.findByBnoGreaterThanOrderByBnoDesc(0, paging)
		.forEach(board->System.out.println(board));
		
	}
}
