package com.Group1.CoinShell.controller.Hoxton;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Group1.CoinShell.model.Habufly.Article;

@Controller
public class backendPageController {

	//這個class都是用來控制後臺頁面跳轉的地方
	@GetMapping("/administrator/store")
	public String changePageCommodity() {
		return "backend/store/administrator-store";
	}
	
	@GetMapping("administrator/store/addCommodity")
	public String changePageAddCommodity() {
		return "backend/store/addCommodity";
	}
	
	@GetMapping("administrator/store/showAllCommodities")
	public String changePageshowAllCommodities() {
		return "backend/store/showAllCommodities";
	}
	
	@GetMapping("/administrator/news")
	public String changePageNews() {
		return "backend/news/administrator-news";
	}
	

}
