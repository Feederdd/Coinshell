package com.Group1.CoinShell.model.Habufly;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleDao extends JpaRepository<Article, Integer> {
	
	public Article findFirstByOrderByAddedDesc();

	@Query(value = "select * from article where tag = :tag and deleted = 'n'", countQuery = "select count (*) from article where tag = :tag", nativeQuery = true)
	public Page<Article> findByTag(Pageable page, @Param("tag") String tag);
//	 實際查詢過程中，需使用註釋來避免sql文報錯，增加以下「countQuery = "select count (*) from article where tag = :tag",」
	
	/*查詢tag*/	
//	@Query(value = "select * from article where tag = :tag and deleted = 'n' ORDER BY added desc", countQuery = "select count (*) from article where tag = :tag", nativeQuery = true)
//	public List<Article> findByTag(String tag);
	@Query(value = "select a.id,added,author_Id as authorId,comment_Num as commentNum,deleted, good_Num as goodNum,read_Num as readNum,tag,text,title,userAvatar, CustomizedUserName "
			+ "from article as a left join "
			+ "(Members as m inner join CustomizedUserAvatar as c on m.customizedUserAvatar = c.id) "
			+ "on a.author_Id = m.id "
			+ "where tag = :tag and deleted = 'n' ORDER BY added desc", countQuery = "select count (*) from article where tag = :tag and deleted = 'n'", nativeQuery = true)
	public List<Map<String,Object>> findByTag(String tag);
	
	/*模糊查詢*/
//	@Query(value = "select * from article where CHARINDEX(:titlePart, title) > 0", countQuery = "select count (*) from article where CHARINDEX(:titlePart, title) > 0", nativeQuery = true)
//	@Query(value = "select * from article where title like %?1% or text like %?1% and deleted = 'n' ORDER BY added desc", countQuery = "select count (*) from article where title like %?1% or text like %?1%", nativeQuery = true)
//	public List<Article> findByTitle(String titlePart);
	@Query(value = "select a.id,added,author_Id as authorId,comment_Num as commentNum,deleted, good_Num as goodNum,read_Num as readNum,tag,text,title,userAvatar, CustomizedUserName "
			+ "from article as a left join "
			+ "(Members as m inner join CustomizedUserAvatar as c on m.customizedUserAvatar = c.id) "
			+ "on a.author_Id = m.id "
			+ "where title like %?1% or text like %?1% and deleted = 'n' ORDER BY added desc", countQuery = "select count (*) from article where title like %?1% or text like %?1% and deleted = 'n'", nativeQuery = true)
	public List<Map<String,Object>> findByTitle(String titlePart);
	
	/*選取全部*/
//	@Query(value = "select * from article where deleted = 'n' ORDER BY added desc", countQuery = "select count (*) from article", nativeQuery = true)
//	public List<Article> findAllOrderByAddedDesc();
	@Query(value = "select a.id,added,author_Id as authorId,comment_Num as commentNum,deleted, good_Num as goodNum,read_Num as readNum,tag,text,title,userAvatar, CustomizedUserName "
			+ "from article as a left join "
			+ "(Members as m inner join CustomizedUserAvatar as c on m.customizedUserAvatar = c.id) "
			+ "on a.author_Id = m.id "
			+ "where deleted = 'n' ORDER BY added desc", countQuery = "select count (*) from article where deleted = 'n'", nativeQuery = true)
	public List<Map<String,Object>> findAllOrderByAddedDesc();
	
	@Query(value = "select a.id,added,author_Id as authorId,comment_Num as commentNum,deleted, good_Num as goodNum,read_Num as readNum,tag,text,title,userAvatar, CustomizedUserName "
			+ "from article as a left join "
			+ "(Members as m inner join CustomizedUserAvatar as c on m.customizedUserAvatar = c.id) "
			+ "on a.author_Id = m.id "
			+ "where author_Id = :authorId and deleted = 'n' ORDER BY added desc", countQuery = "select count (*) from article where tag = :tag and deleted = 'n'", nativeQuery = true)
	public List<Map<String, Object>> findByAuthorId(String authorId);

	@Query(value = "select userAvatar "
			+ "from customizedUserAvatar as c "
			+ "left join Members as m "
			+ "on c.id = m.CustomizedUserAvatar "
			+ "where m.id = :authorId", nativeQuery = true)
	public byte[] findImg(Integer authorId);

	@Query(value = "select customizedUserName from Members where id = :authorId", nativeQuery = true)
	public String getUserName(Integer authorId);

	
//	##########################################################
//	Admin專用
//	##########################################################	
	@Query(value = "select a.id,added,author_Id as authorId,comment_Num as commentNum,deleted, good_Num as goodNum, read_Num as readNum,tag,text,title,userAvatar, CustomizedUserName "
			+ "from article as a left join "
			+ "(Members as m inner join CustomizedUserAvatar as c on m.customizedUserAvatar = c.id) "
			+ "on a.author_Id = m.id "
			+ "where tag = :tag ORDER BY added desc", countQuery = "select count (*) from article where tag = :tag and deleted = 'n'", nativeQuery = true)
	public List<Map<String,Object>> findByTagAdmin(String tag);
	
	@Query(value = "select a.id,added,author_Id as authorId,comment_Num as commentNum,deleted, good_Num as goodNum,read_Num as readNum,tag,text,title,userAvatar, CustomizedUserName "
			+ "from article as a left join "
			+ "(Members as m inner join CustomizedUserAvatar as c on m.customizedUserAvatar = c.id) "
			+ "on a.author_Id = m.id "
			+ "where title like %?1% or text like %?1% ORDER BY added desc", countQuery = "select count (*) from article where title like %?1% or text like %?1% and deleted = 'n'", nativeQuery = true)
	public List<Map<String,Object>> findByTitleAdmin(String titlePart);
	
	@Query(value = "select a.id,added,author_Id as authorId,comment_Num as commentNum,deleted, good_Num as goodNum,read_Num as readNum,tag,text,title,userAvatar, CustomizedUserName "
			+ "from article as a left join "
			+ "(Members as m inner join CustomizedUserAvatar as c on m.customizedUserAvatar = c.id) "
			+ "on a.author_Id = m.id "
			+ "ORDER BY added desc", countQuery = "select count (*) from article where deleted = 'n'", nativeQuery = true)
	public List<Map<String,Object>> findAllOrderByAddedDescAdmin();
	
	@Query(value = "select a.id,added,author_Id as authorId,comment_Num as commentNum,deleted, good_Num as goodNum,read_Num as readNum,tag,text,title,userAvatar, CustomizedUserName "
			+ "from article as a left join "
			+ "(Members as m inner join CustomizedUserAvatar as c on m.customizedUserAvatar = c.id) "
			+ "on a.author_Id = m.id "
			+ "where author_Id = :authorId ORDER BY added desc", countQuery = "select count (*) from article where tag = :tag and deleted = 'n'", nativeQuery = true)
	public List<Map<String, Object>> findByAuthorIdAdmin(String authorId);

	@Query(value = "select count(*) from goods where article_id = :id and user_id = :userId", nativeQuery = true)
	public Integer getGoods(Integer id, Integer userId);
	
	@Modifying
	@Query(value = "insert into goods (article_id, user_id) values (:id, :userId)", nativeQuery = true)
	public void insertGoods(@Param(value="id")Integer id, @Param(value="userId")Integer userId);
	
	@Modifying
	@Query(value = "delete from goods where article_id = :id and user_id = :userId", nativeQuery = true)
	public void deleteGoods(@Param(value="id")Integer id, @Param(value="userId")Integer userId);

	@Modifying
	@Query(value = "update article set good_Num += 1 where id = :id", nativeQuery = true)
	public void increaseGoods(@Param(value="id")Integer id);
	
	@Modifying
	@Query(value = "update article set good_Num -= 1 where id = :id", nativeQuery = true)
	public void decreaseGoods(@Param(value="id")Integer id);

	@Query(value = "select TOP 3 a.id,added,author_Id as authorId,comment_Num as commentNum,deleted, good_Num as goodNum,read_Num as readNum,tag,text,title,userAvatar, CustomizedUserName "
			+ "from article as a left join "
			+ "(Members as m inner join CustomizedUserAvatar as c on m.customizedUserAvatar = c.id) "
			+ "on a.author_Id = m.id "
			+ "ORDER BY goodNum desc", countQuery = "select count (*) from article where deleted = 'n'", nativeQuery = true)
	public List<Map<String, Object>> findByGoods();
	
//	@Query(value = "select * from article where deleted = 'n'", countQuery = "select count (*) from article", nativeQuery = true)
//	public Page<Article> findAllOrderByAddedDesc(Pageable page);
	
}
