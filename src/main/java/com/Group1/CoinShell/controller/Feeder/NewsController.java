package com.Group1.CoinShell.controller.Feeder;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Group1.CoinShell.model.Feeder.Coin;
import com.Group1.CoinShell.model.Feeder.News;
import com.Group1.CoinShell.model.Feeder.StarDTO;
import com.Group1.CoinShell.model.Feeder.Watch;
import com.Group1.CoinShell.service.Feeder.CoinService;
import com.Group1.CoinShell.service.Feeder.NewsService;
import com.fasterxml.jackson.core.JsonProcessingException;

@Component // 在 SpringbootdemoApplication 注入@EnableScheduling 搭配下面@Scheduled 以啟動定時器排程
@RestController
public class NewsController {

	@Autowired
	private CoinService coinService;
	@Autowired
	private NewsService newsService;

//	@Scheduled(cron="0 0 14 * * ?") //cron表達式 每日14點執行(等於更新當日新聞)
//	@Scheduled(initialDelay = 2000, fixedRate = 86400000)// 定時器 啟動專案 initialDelay 毫秒 後啟動 每 fixedRate 毫秒 RUN一次
//	@PostMapping("news/insert")
	public void inserNews() throws JsonProcessingException {

		LocalDate todaysDate = LocalDate.now();
		System.out.println(todaysDate);

		// 網址中插入變數todaysDate  為取得每日新聞 EX 2022-06-03
		String strUrl = "https://newsapi.org/v2/everything?q=cryptocurrency&from=" + todaysDate + "&to=" + todaysDate
				      + "&sortBy=popularity&apiKey=984ba8ce4d3a426a99cf05daed1742e6";
		String newsStr = coinService.getContent(strUrl);

		String newsStr1 = newsStr.substring(newsStr.indexOf("["), newsStr.lastIndexOf("]") + 1);    // +1 為切到 " ] " 後面一個字元
																									// ( 目的為保留 " ] ")

		JSONArray jArray = new JSONArray(newsStr1);

		if (jArray != null) {
			for (Object obj : jArray) {
				JSONObject jo = (JSONObject) obj;
				
				String title  = jo.getString("title");
				String url    = jo.getString("url");
				String imgUrl = jo.get("urlToImage").toString();  //圖片網只有時為null 不能直接用getString
				
				//圖片網址不為空才存SQL
				if(imgUrl != "null") {
					News news = new News();
					
					news.setTitle(title);
					news.setUrl(url);
					news.setImgUrl(imgUrl);
					news.setDate(todaysDate.toString());
					
					newsService.save(news);
				}
			}
		}
	}

	@GetMapping("news/getAll")
	public List<News> findAllNews() {
		List<News> allNewsList = newsService.findAllOrderByDESC();
		return allNewsList;
	}
	
	@GetMapping("/newsId")
	public List<News> coinList(@RequestParam Integer id) {
		
		List<News> news = newsService.findByNewsId(id);
		
		return news;
	}
    
	//找到最新20筆 以求更新頁面每日新聞
	@GetMapping("news/getTop20")
	public List<News> findByNewsTop20Id() {
		List<News> top20NewsList = newsService.findByNewsTop20Id();
		return top20NewsList;
	}
	
	//刪除 傳ID回來找到對應ID刪除
	@DeleteMapping("/deleteNews/{id}")
    public Map<String, String> deleteNews(@RequestBody StarDTO dto) {
    	System.out.println("delete :  NewsId =  " + dto.getNewsId());
    	
    	
    	newsService.deleteByNewsId(dto.getNewsId());
    	
    	Map<String, String> result = new HashMap<String, String>();
    	result.put("status", "200");
    	return result;
    }
	
    //模糊查詢
    @ResponseBody
    @GetMapping("/news/select")
    public List<News> selectCoinByTitle(@RequestParam String title) {
    	List<News> SelectNews;
    	SelectNews = newsService.findByTitle(title);
    	
    	return SelectNews;
    }
    
    
    @PostMapping("/news/add")
    public Map<String, String> addNews(@RequestBody StarDTO dto) {
    	LocalDate todaysDate = LocalDate.now();
    	System.out.println("Title:   " + dto.getNewsTitle());
    	System.out.println("Url:   " + dto.getNewsUrl());
    	System.out.println("ImgUrl:   " + dto.getNewsImgUrl());
    	
    	News news = new News();
    	news.setTitle(dto.getNewsTitle());
    	news.setUrl(dto.getNewsUrl());
    	news.setImgUrl(dto.getNewsImgUrl());
    	news.setDate(todaysDate.toString());
    	
    	newsService.save(news);
    	
    	Map<String, String> result = new HashMap<String, String>();
    	result.put("status", "200");
    	return result;
    }
    
    @PostMapping("/news/upSave")
    public Map<String, String> upSaveNews(@RequestBody StarDTO dto) {
    	LocalDate todaysDate = LocalDate.now();
    	System.out.println("id:   " + dto.getNewsId());
    	System.out.println("Title:   " + dto.getNewsTitle());
    	System.out.println("Url:   " + dto.getNewsUrl());
    	System.out.println("ImgUrl:   " + dto.getNewsImgUrl());
    	
    	News news = new News();
    	news.setId(dto.getNewsId());
    	news.setTitle(dto.getNewsTitle());
    	news.setUrl(dto.getNewsUrl());
    	news.setImgUrl(dto.getNewsImgUrl());
    	news.setDate(todaysDate.toString());
    	
    	newsService.save(news);
    	
    	Map<String, String> result = new HashMap<String, String>();
    	result.put("status", "200");
    	return result;
    }
}
