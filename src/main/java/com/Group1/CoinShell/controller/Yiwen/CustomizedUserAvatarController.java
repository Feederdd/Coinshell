package com.Group1.CoinShell.controller.Yiwen;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.Group1.CoinShell.model.Yiwen.CustomizedUserAvatar;
import com.Group1.CoinShell.model.Yiwen.CustomizedUserAvatarDao;
import com.Group1.CoinShell.service.Yiwen.CustomizedUserAvatarService;

@Controller
public class CustomizedUserAvatarController {

	@Autowired
	private CustomizedUserAvatarService cuaService;
	@Autowired
	private CustomizedUserAvatarDao cuaDao;
	
	@GetMapping(value="avatar/delete/{id}")
	public boolean deleteCustomizedUserAvatar(@PathVariable Integer id) {
		cuaDao.deleteById(id);
		return true;
	}
	
	@PostMapping("uploadcua")
	public String addNewAvatar(@RequestParam("alias")String aliasAvatar, 
								  @RequestParam("file")MultipartFile  userAvatar) {
		CustomizedUserAvatar cua = new CustomizedUserAvatar();
		cua.setAliasAvatar(aliasAvatar);
		try {
			byte[] bytes = userAvatar.getBytes(); 
			cua.setUserAvatar(bytes);
		}catch (IOException e) {
			e.printStackTrace();
		}
		cuaDao.save(cua);
		return "redirect:/adm-showAllAvatars";
	}
	
	/**
	 * localhost:8080/coinshell/editcua?id=XX
	 * @param id
	 * @return
	 */
	@GetMapping("/editcua")
	public ModelAndView changePageToEditAvatar(@RequestParam("id")Integer id) {
		CustomizedUserAvatar cua = cuaService.findAvatarById(id);
		return new ModelAndView("backend/account/editcua","cua", cua);
	}
	
	@PostMapping("/editcua")
	public String editAvatar (@RequestParam("alias") String aliasAvatar, 
							  @RequestParam("file") byte[] userAvatar,
							  @RequestParam("id") Integer id) {
		cuaService.updateAvatarById(aliasAvatar, userAvatar, id);
		return "redirect:/adm-showAllAvatars";
	}
	
	//DeletebyId
	@GetMapping("/deletecua")
	public String deleteAvatar(@RequestParam("id")Integer id) {
		cuaService.deleteAvatarById(id);
		return "redirect:/adm-showAllAvatars";
	}
	

	@GetMapping("administrator/account/search")
	public String findAvatarByName(@RequestParam("alias") String aliasAvatar) {
		return "backend/store/one_cua";
	}
	

 

}