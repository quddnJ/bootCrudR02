package com.bit;

import java.util.Arrays;
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
import com.bit.persistence.BoardRepository3;

//@RunWith(SpringRunner.class) 버전이 낮은곳에서 쓸때
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BoardRepositoryTests3 {
	
	@Autowired
	private BoardRepository3 bRepo;
	
	@Test
	public void testByTitle2() {
		bRepo.findByTitle2("15").forEach(board->System.out.println(board));
	}
	
	@Test
	public void testByTitle3() {
		bRepo.findByTitle3("15").forEach(arr->System.out.println(Arrays.toString(arr)));
	}
	
	@Test
	public void testByPageing() {
		Pageable paging = PageRequest.of(10,5);
		bRepo.findByPage(paging).forEach(board->System.out.println(board));
	}
	
	@Test
	public void testByContent2() {
		bRepo.findByContent2("77").forEach(board->System.out.println(board));
	}
	
}
