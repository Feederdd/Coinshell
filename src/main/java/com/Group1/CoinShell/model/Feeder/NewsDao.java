package com.Group1.CoinShell.model.Feeder;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsDao extends JpaRepository <News, Integer>{

	//透過ID找
	@Query(value="select * from News where id = :id", nativeQuery=true)
	public List<News> findByNewsId(@Param("id") Integer id);
	
	//最新20筆
	@Query(value="SELECT top 20 * FROM News  ORDER BY id DESC", nativeQuery=true)
	public List<News> findByNewsTop20Id();
	
	//模糊查詢TITLE
	@Query(value = "select * from News where title like %?1% or date like %?1% ORDER BY id asc", countQuery = "select count (*) from News where title like %?1% or date like %?1%", nativeQuery = true)
    public List<News> findByTitle(String title);
	
	@Query(value="SELECT * FROM News  ORDER BY id DESC", nativeQuery=true)
	public List<News> findAllOrderByDESC();
}
