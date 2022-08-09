package com.Group1.CoinShell.controller.Yiwen;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.Group1.CoinShell.model.Yiwen.CustomizedUserAvatar;

import com.Group1.CoinShell.service.Yiwen.CustomizedUserAvatarService;

@RestController
public class CustomizedUserAvatarApi {

	@Autowired
	private CustomizedUserAvatarService cuaService;
	
	@GetMapping("/allCUA")
	public List<CustomizedUserAvatar> findAllAvatars(){
		List<CustomizedUserAvatar> allCuaList = cuaService.findAllAvatars();
		return allCuaList;
	}
	//http://localhost:8080/coinshell/allCUA
	
	
	@GetMapping("/CUA")
	public List<CustomizedUserAvatar> findAvatarByName(@RequestParam("name")String aliasAvatar){
		List<CustomizedUserAvatar> cuaList = cuaService.findAvatarByName(aliasAvatar);
		return cuaList;
	}
}
