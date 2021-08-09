package com.bit.persistence;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.bit.domain.Board;

public interface BoardRepository3 extends CrudRepository<Board, Long>{
	// 원래 쿼리문에는 셀렉에 *나 구절에 '% %' 이런식으로 해야함
	// *들어가면 터짐 한곳이라도 들어가면 관련없는 다른 메소드도 터짐 ' ' 에 들어가는건 인식못함
	//JPQL(Java Persistence Query Language)
	@Query("SELECT b FROM Board b WHERE b.title like %?1% and b.bno > 0 ORDER BY b.bno desc")
	public List<Board> findByTitle2(String title);
	
	@Query("SELECT b.bno, b.title, b.writer, b.regdate " + 
	"FROM Board b WHERE b.title like %?1% and b.bno > 0 order by b.bno desc")
	public List<Object[]> findByTitle3(String title);
	
	@Query("SELECT b FROM Board b WHERE b.bno > 0 order by b.bno desc")
	public List<Board> findByPage(Pageable paging);
	
	@Query("SELECT b FROM Board b WHERE "
			+ "b.bno > 0 and b.content LIKE %:content% "
			+ "ORDER BY b.bno DESC")
	public List<Board> findByContent2(@Param("content")String content);
	
}
