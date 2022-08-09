package com.Group1.CoinShell.service.Feeder;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Group1.CoinShell.model.Feeder.Coin;
import com.Group1.CoinShell.model.Feeder.News;
import com.Group1.CoinShell.model.Feeder.NewsDao;

@Service
@Transactional
public class NewsService {

	@Autowired
	private NewsDao newsdao;
	
	public void save(News news) {
		newsdao.save(news);
	}
	
	public List<News> findAll() {
		return newsdao.findAll();
	}
	
	//型態為List<News>
	public List<News> findByNewsId(Integer id) {
		return newsdao.findByNewsId(id);
	}
	
	//最新20筆
	public List<News> findByNewsTop20Id() {
		return newsdao.findByNewsTop20Id();
	}
	
	//刪除
	public void deleteByNewsId(Integer id) {
		newsdao.deleteById(id);
	}
	
	//模糊查詢Title
	public List<News> findByTitle(String title) {
		return  newsdao.findByTitle(title);
	    }
	
	//找全部後降冪
	public List<News> findAllOrderByDESC() {
		return newsdao.findAllOrderByDESC();
	}
	
}
