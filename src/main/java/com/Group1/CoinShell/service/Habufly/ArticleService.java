package com.Group1.CoinShell.service.Habufly;

import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Group1.CoinShell.model.Habufly.Article;
import com.Group1.CoinShell.model.Habufly.ArticleDao;

@Service
@Transactional
public class ArticleService {
	
	@Autowired
	private ArticleDao dao;
	
	public void save(Article atc) {
		dao.save(atc);
	}
	
	public Article getFirstNewArticle() {
		return dao.findFirstByOrderByAddedDesc();
	}
	
	public Article findById(Integer id) {
		Optional<Article> option = dao.findById(id);
		if(option.isPresent()) {
			Article atc = option.get();
			return atc;
		}
		return null; 
	}

	public void delete(Article atc) {
		dao.delete(atc);
	}

	public void increasePageView(HttpSession session, Integer articleId) {
        Article article = dao.getById(articleId);
        Integer read_Num = article.getReadNum();
        article.setReadNum(read_Num+1);
	}
	
	public void updatCommentNum(Integer articleId, Integer CommentNum) {
		Article article = dao.getById(articleId);
		article.setCommentNum(CommentNum);
	}

	public Page<Article> findByPageAndTag(Integer pageNumber, String tag) {
		Pageable pgb = PageRequest.of(pageNumber-1, 10, Sort.Direction.DESC, "added");
		Page<Article> page = dao.findByTag(pgb, tag);
		return page;
	}

//	public List<Article> findByTag(String tag) {
//		List<Article> list = dao.findByTag(tag);
//		return list;
//	}
	
	public List<Map<String,Object>> findAll(){
		return dao.findAllOrderByAddedDesc();
	}
	
	public List<Map<String,Object>> findByTag(String tag) {
		List<Map<String,Object>> list = dao.findByTag(tag);
		return list;
	}

	public List<Map<String,Object>> findByTitle(String titlePart) {
		List<Map<String,Object>> list = dao.findByTitle(titlePart);
		return list;
	}

	public List<Map<String, Object>> findByAuthorId(String authorId) {
		List<Map<String,Object>> list = dao.findByAuthorId(authorId);
		return list;
	}
	
	public String findImg(Integer authorId) {
		byte[] imgByte = dao.findImg(authorId);
		String img = Base64.getEncoder().encodeToString(imgByte);
		return img;
	}

	public String getUserName(Integer authorId) {
		String userName = dao.getUserName(authorId);
		return userName;
	}

	public List<Map<String,Object>> findAllAdmin(){
		return dao.findAllOrderByAddedDescAdmin();
	}
	
	public List<Map<String,Object>> findByTagAdmin(String tag) {
		List<Map<String,Object>> list = dao.findByTagAdmin(tag);
		return list;
	}

	public List<Map<String,Object>> findByTitleAdmin(String titlePart) {
		List<Map<String,Object>> list = dao.findByTitleAdmin(titlePart);
		return list;
	}

	public List<Map<String, Object>> findByAuthorIdAdmin(String authorId) {
		List<Map<String,Object>> list = dao.findByAuthorIdAdmin(authorId);
		return list;
	}

	public Integer getGoods(Integer id, Integer userId) {
		Integer goods = dao.getGoods(id, userId);
		return goods;
	}

	public void increaseGoods(Integer id, Integer userId) {
		dao.insertGoods(id, userId);
		dao.increaseGoods(id);
	}

	public void decreaseGoods(Integer id, Integer userId) {
		dao.deleteGoods(id, userId);
		dao.decreaseGoods(id);
	}

	public List<Map<String, Object>> findByGoods() {
		List<Map<String,Object>> list = dao.findByGoods();
		return list;
	}

}
