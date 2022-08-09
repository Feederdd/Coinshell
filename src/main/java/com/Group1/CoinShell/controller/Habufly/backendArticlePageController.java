package com.Group1.CoinShell.controller.Habufly;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class backendArticlePageController {

	//這個class都是用來控制後臺頁面跳轉的地方
	@GetMapping("/administrator/article")
	public String changePageArticle() {
		return "backend/article/viewAllArticleAdmin";
	}
	
}
