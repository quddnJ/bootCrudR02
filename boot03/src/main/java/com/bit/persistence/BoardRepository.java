package com.bit.persistence;

import java.util.Collection;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bit.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long>{
	
	//findBy~:select where 절
	//title을 조건으로 검색
	public List<Board> findByTitle(String title);
	
	public Collection<Board> findByWriter(String writer);
	
	public List<Board> findByContent(String content);
	
	//title에 '7'이 들어가 있는 레코드 검색
	public List<Board> findByTitleContaining(String title);
	
	//content에 '9채우기'로 끝나는 레코드 검색
	public List<Board> findByContentEndingWith(String content);
	
	//writer에 '7'로 끝나는 레코드 검색
	public List<Board> findByWriterEndingWith(String writer);
	
	//title에서 '제목...2'시작하는 레코드 검색
	public List<Board> findByTitleStartingWith(String title);

}
