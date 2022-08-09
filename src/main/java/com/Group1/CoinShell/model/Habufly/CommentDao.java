package com.Group1.CoinShell.model.Habufly;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface CommentDao extends JpaRepository<Comment, Integer> {
	
	// HQL
//		@Query("from Comment where name = :name")
//		public List<Comment> findCommentByName(@Param("name") String name);

		// 原生 SQL (nativeQuery = true)
//		@Query(value = "select * from comment where type = :type", nativeQuery = true)
//		public List<Comment> findCommentByType(@Param("type") String type);

//		@Query(value = "select * from comment where name = :name and level = :level", nativeQuery = true)
//		public List<Comment> findCommentByName3(@Param("name") String name, @Param("level") Integer level);

//		@Query(value = "select * from comment where article_id = :articleId and type = 'a' and deleted = 'n' ORDER BY added asc", nativeQuery = true)
//		public List<Comment> findCommentByAtcAndType(@Param("articleId") Integer articleId);

		@Query(value = "select c.id,added,article_id as articleId,comment_id as commentId,deleted,text,type,user_name as userName,user_id as userId,ava.userAvatar "
				+ "from comment as c "
				+ "left join "
				+ "(Members as m inner join CustomizedUserAvatar as ava on m.customizedUserAvatar = ava.id) "
				+ "on c.user_id = m.id where article_id = :articleId and type = 'a' and deleted = 'n' ORDER BY added desc", nativeQuery = true)
		public List<Map<String,Object>> findCommentByAtcAndType(@Param("articleId") Integer articleId);
		
		@Query(value = "select c.id,added,article_id as articleId,comment_id as commentId,deleted,text,type,user_name as userName,user_id as userId,ava.userAvatar "
				+ "from comment as c "
				+ "left join "
				+ "(Members as m inner join CustomizedUserAvatar as ava on m.customizedUserAvatar = ava.id) "
				+ "on c.user_id = m.id where article_id = :articleId and type = 'a' ORDER BY added desc", nativeQuery = true)
		public List<Map<String,Object>> findCommentByAtcAndTypeAdmin(@Param("articleId") Integer articleId);
		
//		@Query(value = "select * from comment where article_id = :articleId and comment_Id = :commentId and type = 'b' and deleted = 'n' ORDER BY added asc", nativeQuery = true)
//		public List<Comment> findReplyByAtcAndType(@Param("articleId") Integer articleId, @Param("commentId") Integer commentId);

		@Query(value = "select c.id,added,article_id as articleId,comment_id as commentId,deleted,text,type,user_name as userName,user_id as userId,ava.userAvatar "
				+ "from comment as c "
				+ "left join "
				+ "(Members as m inner join CustomizedUserAvatar as ava on m.customizedUserAvatar = ava.id) "
				+ "on c.user_id = m.id where article_id = :articleId and comment_Id = :commentId and type = 'b' and deleted = 'n' ORDER BY added desc", nativeQuery = true)
		public List<Map<String,Object>> findReplyByAtcAndType(@Param("articleId") Integer articleId, @Param("commentId") Integer commentId);
		
		@Query(value = "select c.id,added,article_id as articleId,comment_id as commentId,deleted,text,type,user_name as userName,user_id as userId,ava.userAvatar "
				+ "from comment as c "
				+ "left join "
				+ "(Members as m inner join CustomizedUserAvatar as ava on m.customizedUserAvatar = ava.id) "
				+ "on c.user_id = m.id where article_id = :articleId and comment_Id = :commentId and type = 'b' ORDER BY added desc", nativeQuery = true)
		public List<Map<String,Object>> findReplyByAtcAndTypeAdmin(@Param("articleId") Integer articleId, @Param("commentId") Integer commentId);
		
		@Query(value = "select count( * ) as count from comment where article_id = :articleId and type = :type and deleted = 'n'", nativeQuery = true)
		public Integer checkCommentNumber(@Param("articleId") Integer articleId, @Param("type") String type);

		
		@Query(value = "select c.id,added,article_id as articleId,comment_id as commentId,deleted,text,type,user_name as userName,user_id as userId,ava.userAvatar,user_email as userEmail "
				+ "from comment as c "
				+ "left join "
				+ "(Members as m inner join CustomizedUserAvatar as ava on m.customizedUserAvatar = ava.id) "
				+ "on c.user_id = m.id where c.id = :id", nativeQuery = true)
		public List<Map<String,Object>> findCRById(@Param("id")Integer id);

		@Query(value = "update comment set deleted = 'y' where id = :id", nativeQuery = true)
		public void deleteCR(Integer id);

		@Query(value = "update comment set deleted = 'n' where id = :id", nativeQuery = true)
		public void undoCR(Integer id);

		@Query(value = "select * from comment where id = :id", nativeQuery = true)
		public Comment findCommById(Integer id);

//		@Query(value = "select * from comment where deleted = 'n' ORDER BY added desc", countQuery = "select count (*) from article", nativeQuery = true)
//		public List<Comment> findAllOrderByAddedDesc();
		
//		https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#tansactions

//		@Query(value = "delete from comment where name = ?1", nativeQuery = true)
//		@Transactional // 沒有Service標註此項的話，要在修改資料的地方標註此
//		@Modifying
//		public void deleteCommentByName(String name);
		
//		https://docs.spring.io/spring-date/jpa/docs/current/
//		public List<Comment> findByLevelOrderById(Integer level);
//		public List<Comment> findByLevelOrderByIdDesc(Integer level);
		
		
}
