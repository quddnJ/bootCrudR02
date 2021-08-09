package com.bit.persistence;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.bit.domain.Board;

public interface BoardRepository2 extends CrudRepository<Board, Long>{
	
	//title과 writer : or 조건
	public List<Board> findByTitleOrWriter(String title, String writer);
	
	//title과 content : and 조건
	public List<Board> findByTitleAndContent(String title, String content);
	
	//bno between 10 and 20
	public List<Board> findByBnoBetween(long bno1, long bno2);
	
	//bno >50
	public List<Board> findByBnoGreaterThan(long bno);
	
	//bno <=100
	public List<Board> findByBnoLessThanEqual(long bno);
	
	// or%like : title like '%제목...6%' or content like '%내용..6채우기%'
	public List<Board> findByTitleContainingOrContentContaining(String title, String content);
	
	// like%and : title like '%제목...6%' and bno > 10
	public List<Board> findByTitleContainingAndBnoGreaterThan(String title, long bno);
		
	// >&desc: bno > 150 order by bno desc
	public List<Board> findByBnoGreaterThanOrderByBnoDesc(long bno);
	
	// bno > ? order by bno desc limit ?,?
	// import org.springframework.data.domain.Pageable;
	public List<Board> findByBnoGreaterThanOrderByBnoDesc(long bno, Pageable paging);

}
