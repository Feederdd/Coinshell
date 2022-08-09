package com.Group1.CoinShell.controller.Yiwen;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Group1.CoinShell.model.Yiwen.Members;
import com.Group1.CoinShell.model.Yiwen.MembersDao;
import com.Group1.CoinShell.service.Hoxton.EmailSenderService;
import com.Group1.CoinShell.service.Yiwen.MembersService;

@Controller
public class MembersController {
	
	@Autowired
	MembersService memService;
	
	@Autowired
	EmailSenderService senderService;
	
	@Autowired
	MembersDao dao;
	
	@GetMapping("/signup")
	public String signupPage(Model model) {
		model.addAttribute("memberBean", new Members());
		return "signup";
	}	
	
	@PostMapping("/signup")
	public String signUp(@RequestParam("e-mail")String eMail ,@RequestParam("password") String password) {
		SimpleDateFormat sdf = new SimpleDateFormat();
		senderService.sendEmail(eMail, "恭喜你註冊CoinShell會員！", "歡迎你"+eMail+"！　\r\n 一起在虛擬貨幣的海洋中漫遊吧！");
		Date date = new Date();
		Members member = new Members();
		member.setCustomizedUserAvatar(5);
		member.setMyShell(1000);
		member.setCoin(1000);
		member.seteMail(eMail);
		member.setJoinTime(date);
		member.setPassword(password);
		member.setCustomizedUserName("New User");
		memService.save(member);
		
		return "signupOK";
	}
	
	@GetMapping("/account/set")
	public String getAccountSet(Model model) {
		model.addAttribute("memberBean", new Members());
		return "/account/set";
	}
	
	
	
	@GetMapping("/account/referral")
	public String getReferral(Model model) {
		model.addAttribute("memberBean", new Members());
		return "/account/referral";
	}
	
	@GetMapping("/aboutUs/intro")
	public String getIntro() {
		return "aboutUs/intro";
	}
	
	@GetMapping("/aboutUs/nice-intro")
	public String getFancyIntro() {
		return "aboutUs/gen2_intro";
	}
	 
	
	@GetMapping("/account/privacy")
	public String getPrivacy() {
		return "account/privacy";
	}
	
	@GetMapping("/account/freAQ")
	public String getFAQ() {
		return "account/freAQ";
	}
	
	@GetMapping("/account/cookie")
	public String getCookie() {
		return "account/cookie";
	}
	

	@GetMapping("/login")
	public String getloginPage(Model model) {
		model.addAttribute("memberBean", new Members());
		return "login";
	}

	
	@PostMapping("/login")
	public String postLogin(@RequestParam("eMail") String eMail, 
			HttpSession httpSession, RedirectAttributes redirectAttributes) {
		Members memRes = dao.findMemberByEMail(eMail);
		
		if(memRes == null) {
			redirectAttributes.addFlashAttribute("loginError", "帳號密碼錯誤，請重新輸入");
			return "redirect:/";
		}
		httpSession.setAttribute("login", memRes);
		
		/*張翔使用：取得登入中的使用者圖片，存入session*/
		Integer memId = memRes.getId();
		String img = null;
		try {
			byte[] imgByte = dao.getImg(memId);
			img = Base64.getEncoder().encodeToString(imgByte);
		}catch(Exception e) {
			e.printStackTrace();
		}
		httpSession.setAttribute("memImg", img);
		
		return "index";
	}
	
	@GetMapping("/logout")
	public String LogOut(HttpSession httpSession, HttpServletRequest request, HttpServletResponse response,
			RedirectAttributes redirectAttributes) {
		request.getSession().invalidate();
		Cookie[] cookies = request.getCookies();
		for (Cookie c : cookies) {
			if (c.getName().equals("JSESSIONID")) {
				c.setMaxAge(0);
				break;
			}
		}
		return "redirect:/";
		
	}
	
	@PostMapping("account/selectAvatar")
	public String updateCustomizedUserAvatarById(@RequestParam("id") Integer id, @RequestParam("radio-emotion") Integer avatarId) {
		memService.updateCustomizedUserAvatarById(id, avatarId);
		return "redirect:/account/set";
	}
	
	@ResponseBody
	@GetMapping("/selectMemAvatar")
	public String selectMemAvatar(@RequestParam("id") Integer id) {
		String img = null;
		try {
			byte[] imgByte = dao.getImg(id);
			img = Base64.getEncoder().encodeToString(imgByte);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return img;
	}

	@PostMapping("account/changeUsername")
	public String updateCustomizedUserNameById
	(@RequestParam("customizedUserName")String customizedUserName,
			@RequestParam("eMail")String eMail,
			@RequestParam("id")Integer id,
			HttpSession httpSession) {
		memService.updateCustomizedUserNameById(customizedUserName, id);
		Members member = memService.findMemberByEMail(eMail);
		httpSession.setAttribute("login", member);
		return "/account/set";
	}
	
	@PostMapping("account/sendResetEmail")
	public String sendResetEmail
	(@RequestParam("eMail")String eMail) {
		senderService.sendEmail(eMail, "重置密碼認證信", "更改你的密碼呦");
		return "redirect:/";
	}
	
	@ResponseBody
	@GetMapping("account/getAll")
	public List<Map<String,Object>> findAllMembers(){
		List<Map<String,Object>> allMemList = memService.findAllMembers2();
		return allMemList;
	}
	
	/**
	 * 後台 AJAX 新增
	 * @param dto
	 * @return
	 */
	@ResponseBody
	@PostMapping("/account/add")
	public Map<String, String> addAccount(@RequestBody OkrDTO dto) {
		Date date = new Date();
		System.out.println("Name: " + dto.getName());
		System.out.println("Email: " + dto.getEmail());
		System.out.println("Password: " + dto.getPassword());
		
		Members mem = new Members();
		mem.setCustomizedUserName(dto.getName());
		mem.seteMail(dto.getEmail());
		mem.setPassword(dto.getPassword());
		mem.setJoinTime(date);
		mem.setCustomizedUserAvatar(5);
		mem.setMyShell(1000);
		mem.setCoin(1000);
		
		memService.save(mem);
		
		Map<String, String> result = new HashMap<String, String>();
		result.put("status", "200");
		return result;
	}
	
	/**
	 * 後台 AJAX 刪除: 傳會員ID回來找到對應ID刪除
	 */
	@ResponseBody
	@DeleteMapping("/deleteAccount/{id}")
	public Map<String, String> deleteAccount(@RequestBody OkrDTO dto){
		System.out.println("delete : memId = " + dto.getId());
		
		memService.deleteMemberById(dto.getId());
		
		Map<String, String> result = new HashMap<String, String>();
		result.put("status", "200");
		return result;
	}
	
	/**
	 * 模糊查詢
	 * @param name
	 * @return
	 */
	@ResponseBody
	@GetMapping("/account/select")
	public List<Map<String, Object>> selectAccountByName(@RequestParam String name) {
		List<Map<String, Object>> SelectAccount;
		SelectAccount = memService.findMemberByName(name);
		return SelectAccount;
	}
	
	/**
	 * 
	 */
	@ResponseBody
	@PostMapping("/account/upSave")
	public Map<String, String> upSaveAccount(@RequestBody OkrDTO dto){
		Date date = new Date();
		System.out.println("Id: " + dto.getId());
		System.out.println("Name: " + dto.getName());
		System.out.println("Email: " + dto.getEmail());
		System.out.println("Password: " + dto.getPassword());
		
		Members mem = new Members();
		mem.setId(dto.getId());
		mem.setCustomizedUserName(dto.getName());
		mem.seteMail(dto.getEmail());
		mem.setPassword(dto.getPassword());
		mem.setJoinTime(date);
		mem.setCustomizedUserAvatar(5);
		mem.setMyShell(1000);
		mem.setCoin(1000);
		
		memService.save(mem);
		
		Map<String, String> result = new HashMap<String, String>();
		result.put("status", "200");
		return result;
	}
	
	@ResponseBody
	@GetMapping("/memId")
	public List<Map<String, Object>> memList(@RequestParam Integer id){
		List<Map<String, Object>> mem = memService.findMemberById3(id);
		return mem;
	}
	

}
