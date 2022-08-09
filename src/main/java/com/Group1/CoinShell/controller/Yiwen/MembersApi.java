package com.Group1.CoinShell.controller.Yiwen;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.Group1.CoinShell.model.Yiwen.Members;
import com.Group1.CoinShell.service.Yiwen.MembersService;



@RestController  
public class MembersApi {
	
	@Autowired
	private MembersService memService;


	@GetMapping("/allMem")
	public List<Members> findAllMembers(){
		List<Members> allMemList = memService.findAllMembers();
		return allMemList;
	}
	
	@GetMapping("/Mem")
	public List<Map<String, Object>> findMemberByName(@RequestParam("name")String customizedUserName){
		List<Map<String, Object>> memList = memService.findMemberByName(customizedUserName);
		return memList;
	}
}

//	@Autowired
//	private MembersDao dao;
//	
//	/**
//	 * SignUp 註冊功能 CREATE an account
//	 * @param mem
//	 * @return
//	 */
//	@PostMapping(value = "/members/signUp")
//	public Members insertMembers(@RequestBody Members mem) {
//		Members resMem = dao.save(mem);
//		return resMem;
//	}
//	
//	/**
//	 * LogIn/SignIn 登入功能
//	 * @param eMail @param password @param httpSession @param redirectAttributes
//	 * @return
//	 */
//	@PostMapping("/members/login")
//	public String postForm(@RequestParam("eMail") String eMail, @RequestParam("password")
//			String password, HttpSession httpSession, RedirectAttributes redirectAttributes) {
//		Members memRes = dao.findByEMailAndPassword(eMail, password);
//		
//		if (memRes == null) {
//			redirectAttributes.addFlashAttribute("loginError", "帳號密碼錯誤，請重新輸入");
//			return "redirect:loginMember";
//		}
//		httpSession.setAttribute("loginMember", memRes);
//		return "loginOK";
//	}
//	
//	/**
//	 * AccountSetting 修改使用者資料；Update my profile
//	 * @param id
//	 * @param members
//	 * @return
//	 */
//	@PutMapping(value="/members/u-setting/{id}")
//	public Members updateMemberDetail(@PathVariable("id") Integer id, @RequestBody Members members) {
//		Members ResMem = dao.updateUSettingById(id, members);
//		return ResMem;
//	}
//	
//	/**
//	 * 變更使用者密碼
//	 * @param id
//	 * @param members
//	 * @return
//	 */
//	@PutMapping(value="/members/u-pwd/{id}")
//	public Members updateMemberPassword(@PathVariable("id") Integer id, @RequestBody Members members) {
//		Members resMem = dao.updatePasswordById(id, members);
//		return resMem;
//	}
//}
//	
//	
///////////////////////以下無關/////////////////////////////
/////**
////* AccountSetting 檢視使用者: READ my profile
////* @param id
////* @return
////*/
////@GetMapping(value="members/get")
////public Members getMembersById2(@RequestParam Integer id) {
////	Optional<Members> responseMem = dao.findById(id);
////	
////	if(responseMem.isPresent()) {
////		return responseMem.get();
////	}
////	return null;
////}
////	
////	/**
////	 * AccountSetting 檢視使用者: READ my profile
////	 * @param id
////	 * @return
////	 */
////	@GetMapping(value="members/get/{id}")
////	public Members getMembersById(@PathVariable Integer id) {
////		Optional<Members> responseMem = dao.findById(id);
////		
////		if(responseMem.isPresent()) {
////			return responseMem.get();
////		}
////		return null;
////	}
////
////	
////	/**
////	 * (後台專用) 刪除使用者資料
////	 * Postman Get 方法 => localhost:8080/(context-path)/members/delete/(要刪除的id#)
////	 * @param id
////	 * @return
////	 */
////	@GetMapping(value="members/delete/{id}")
////	public boolean deleteMember(@PathVariable Integer id) {
////		dao.delByid(id);
////		return true;
////	}
////	
////	/**
////	 * (後台專用) 使用 Postman Post方法 JSON 格式 新增多筆資料
////	 * @param mem
////	 * @return
////	 */
////	@PostMapping(value = "members/insertAll")
////	public List<Members> insertMembers(@RequestBody List<Members> mem) {
////		List<Members> responseList = dao.saveAll(mem);
////		return responseList;
////	}
////	
////	
////	/**
////	 * (後台專用) 從第一頁開始， 每頁2筆，以id升冪排列，根據頁面做排序
////	 * @param pageNumber
////	 * @return
////	 */
////	@GetMapping(value="members/page/{pageNumber}")
////	public List<Members> findByPage(@PathVariable Integer pageNumber) {
////		Pageable pgb = PageRequest.of(pageNumber-1, 2, Sort.Direction.ASC, "id");
////		Page<Members> page = dao.findAll(pgb);
////		List<Members> list = page.getContent();
////		return list;
////	}
////	
////	/**
////	 * (後台專用) Postman Get 方法(JPQL)。KEY: CustomizedUserName | VALUE: 用戶名。 
////	 * @param customizedUserName
////	 * @return
////	 */
////	@GetMapping(value="members/findByName")
////	public List<Members> findByName(@RequestParam String customizedUserName){
////		return dao.findByName(customizedUserName);
////	}
////	
////	/**
////	 * (後台專用) Postman Get 方法(原生SQL)。KEY: CustomizedUserName | VALUE: 用戶名。 
////	 * @param customizedUserName
////	 * @return
////	 */
////	@GetMapping(value="members/findByName2")
////	public List<Members> findByName2(@RequestParam String customizedUserName){
////		return dao.findByName2(customizedUserName);
////	}
////	
////
////	/**
////	 * (後台專用) 列出豪華旗艦版有加值的會員
////	 * @param isPresmum
////	 * @return
////	 */
////	@GetMapping(value="members/ispremium/{isPremium}")
////	public List<Members> findByIsPremiumTrue(@PathVariable Boolean isPremium){
////		return dao.findByisPremiumTrue(isPremium);
////	}


