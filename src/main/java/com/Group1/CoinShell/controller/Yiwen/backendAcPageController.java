package com.Group1.CoinShell.controller.Yiwen;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class backendAcPageController {

	//這個class都是用來控制後臺頁面跳轉的地方
	@GetMapping("/adm-account")
	public String changePageAccount() {
		return "backend/account/administrator-account";
	}
	
	@GetMapping("/adm-addAvatar")
	public String changePageAddCua() {
		return "backend/account/addAvatar";
	}
	
	@GetMapping("/adm-showAllAvatars")
	public String changePageshowAllCuas() {
		return "backend/account/showAllAvatars";
	}
	
	@GetMapping("/adm-addMember")
	public String changePageAddMem() {
		return "backend/account/addMember";
	}
	
	@GetMapping("/adm-showAllMembers")
	public String changePageshowAllMems() {
		return "backend/account/showAllMembers";
	}
	
	
}
