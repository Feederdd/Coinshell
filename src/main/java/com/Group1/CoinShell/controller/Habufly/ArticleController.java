package com.Group1.CoinShell.controller.Habufly;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.Group1.CoinShell.model.Habufly.Article;
import com.Group1.CoinShell.service.Habufly.ArticleService;
import com.Group1.CoinShell.service.Habufly.CommentService;

@Controller
public class ArticleController {

	@Autowired
	private ArticleService aService;
	@Autowired
	private CommentService cService;

	@GetMapping("/viewArticle/{id}")
	public String viewArticle(HttpSession session, Model model, @PathVariable("id") Integer id) throws IOException {
		Article atc = aService.findById(id);
		
		Integer authorId = atc.getAuthorId();
		String img = aService.findImg(authorId);
		model.addAttribute("img", img);
		
		String userName = aService.getUserName(authorId);
		model.addAttribute("userName", userName);
		
		model.addAttribute("Article", atc);
		aService.increasePageView(session, id);
		return "forum/viewArticle";
	}
		
	@GetMapping("/article/add") // ModelAndView 參數一定要放在第一個
	public ModelAndView goAddArticle(ModelAndView mav) {
		Article atc = new Article();

		// model.addAttribute("名字", 物件)
		mav.getModel().put("article", atc);

		mav.setViewName("/forum/addArticle");

		Article lastestArticle = aService.getFirstNewArticle();
		mav.getModel().put("lastestArticle", lastestArticle);

		return mav;
	}

	@PostMapping("/article/add")
	public ModelAndView postMessage(ModelAndView mav, @ModelAttribute(name = "article") Article atc) {
		aService.save(atc);

		// save完之後，再帶入一個新的進去，否則格子內還是舊的
		Article newAtc = new Article();
		mav.getModel().put("article", newAtc);

		// 回傳後顯示最新的那一筆留言
		Article lastestArticle = aService.getFirstNewArticle();
		mav.getModel().put("lastestArticle", lastestArticle);
		mav.setViewName("forum/viewAllArticle");
		return mav;
	}

	@ResponseBody // 由於是寫在一般Controller底下，要將java物件序列化轉成Json格式，需寫
	@GetMapping("/article/viewAllAjax")
	public List<Map<String,Object>> viewArticlePage(@RequestParam String tag) {
		List<Map<String,Object>> allAtc;

		if ("All".equals(tag)) {
			allAtc = aService.findAll();
		} else {
			allAtc = aService.findByTag(tag);
		}
		return allAtc;
	}
	// http://localhost:8080/coinshell/article/viewAllAjax?tag=btc
	
	@ResponseBody
	@GetMapping("/article/viewAllAjaxByTitle")
	public List<Map<String,Object>> viewArticleByTitle(@RequestParam String titlePart) {
		List<Map<String,Object>> allAtc;

		allAtc = aService.findByTitle(titlePart);
//		System.out.println(allAtc);
		return allAtc;
	}
	// http://localhost:8080/coinshell/article/viewAllAjax?tag=btc
	
	@ResponseBody
	@GetMapping("/article/viewAllAjaxByAuthorId")
	public List<Map<String,Object>> viewArticleByAuthorId(@RequestParam String authorId) {
		List<Map<String,Object>> allAtc;
		
		allAtc = aService.findByAuthorId(authorId);
		return allAtc;
	}
	// http://localhost:8080/coinshell/article/viewAllAjaxByAuthorId?authorId=1

	@ResponseBody
	@GetMapping("/article/viewArticleByGoods")
	public List<Map<String,Object>> viewArticleByGoods() {
		List<Map<String,Object>> allAtc;
		
		allAtc = aService.findByGoods();
		return allAtc;
	}
	// http://localhost:8080/coinshell/article/viewArticleByGoods
	
	@GetMapping("/editArticle/{id}")
	public String editArticle(Model model, @PathVariable("id") Integer id) {
		Article atc = aService.findById(id);
		model.addAttribute("article", atc);
		return "forum/editArticle";
	}

	@PostMapping("/postEditArticle")
	public String editArticle(Model model, @ModelAttribute("article") Article atc) {
		aService.save(atc);// save方法，有此id的話就會做update
		Integer id = atc.getId();
		System.out.println(id);
		model.addAttribute("id", id);
		return "redirect:/viewArticle/" + id + "/";
	}

	@GetMapping("/deleteArticle/{id}")
	public String deleteArticle(@PathVariable("id") Integer id) {
		Article atc = aService.findById(id);
		atc.setDeleted("y");
		aService.save(atc);
		return "redirect:/viewAllArticle";
	}
	
	@ResponseBody
	@GetMapping("/countGoods")
	public List<Object> countGoods(@RequestParam Integer id, @RequestParam Integer userId) throws IOException {
		Integer goods = aService.getGoods(id, userId);
		Article atc = aService.findById(id);
		Integer goodNum = atc.getGoodNum();
		List<Object> list = Arrays.asList(goods, goodNum);
		
		return list;
	}

	@ResponseBody
	@GetMapping("/doGoods")
	public void doGoods(@RequestParam Integer id, @RequestParam Integer userId) throws IOException {
		Integer goods = aService.getGoods(id, userId);
		if(goods==0) {
			aService.increaseGoods(id, userId);
		}else {
			aService.decreaseGoods(id, userId);
		}
		return;
	}
	
//	##################################################################
//	下方為後臺使用
//	##################################################################
	@GetMapping("/viewArticleAdmin/{id}")
	public String viewArticleAdmin(HttpSession session, Model model, @PathVariable("id") Integer id) throws IOException {
		Article atc = aService.findById(id);
		
		Integer authorId = atc.getAuthorId();
		String img = aService.findImg(authorId);
		model.addAttribute("img", img);
		String userName = aService.getUserName(authorId);
		model.addAttribute("userName", userName);
		
		model.addAttribute("Article", atc);
		aService.increasePageView(session, id);
		return "backend/article/viewArticleAdmin";
	}
	
	@ResponseBody // 由於是寫在一般Controller底下，要將java物件序列化轉成Json格式，需寫
	@GetMapping("/article/viewAllAjaxAdmin")
	public List<Map<String,Object>> viewArticlePageAdmin(@RequestParam String tag) {
		List<Map<String,Object>> allAtc;

		if ("All".equals(tag)) {
			allAtc = aService.findAllAdmin();
		} else {
			allAtc = aService.findByTagAdmin(tag);
		}
		return allAtc;
	}
	// http://localhost:8080/coinshell/article/viewAllAjax?tag=btc
	
	@ResponseBody
	@GetMapping("/article/viewAllAjaxByTitleAdmin")
	public List<Map<String,Object>> viewArticleByTitleAdmin(@RequestParam String titlePart) {
		List<Map<String,Object>> allAtc;

		allAtc = aService.findByTitleAdmin(titlePart);
//		System.out.println(allAtc);
		return allAtc;
	}
	// http://localhost:8080/coinshell/article/viewAllAjax?tag=btc
	
	@ResponseBody
	@GetMapping("/article/viewAllAjaxByAuthorIdAdmin")
	public List<Map<String,Object>> viewArticleByAuthorIdAdmin(@RequestParam String authorId) {
		List<Map<String,Object>> allAtc;
		
		allAtc = aService.findByAuthorIdAdmin(authorId);
		return allAtc;
	}
	// http://localhost:8080/coinshell/article/viewAllAjaxByAuthorId?authorId=btc
	
	@GetMapping("/editArticleAdmin/{id}")
	public String editArticleAdmin(Model model, @PathVariable("id") Integer id) {
		Article atc = aService.findById(id);
		model.addAttribute("article", atc);
		return "backend/article/editArticleAdmin";
	}
	
	@PostMapping("/postEditArticleAdmin")
	public String editArticleAdmin(Model model, @ModelAttribute("article") Article atc) {
		aService.save(atc);// save方法，有此id的話就會做update
		Integer id = atc.getId();
		System.out.println(id);
		model.addAttribute("id", id);
		return "redirect:/viewArticleAdmin/" + id + "/";
	}

	@GetMapping("/deleteArticleAdmin/{id}")
	public String deleteArticleAdmin(@PathVariable("id") Integer id) {
		Article atc = aService.findById(id);
		atc.setDeleted("y");
		aService.save(atc);
		return "backend/article/viewAllArticleAdmin";
	}
	
	@GetMapping("/undoArticleAdmin/{id}")
	public String undoArticleAdmin(@PathVariable("id") Integer id) {
		Article atc = aService.findById(id);
		atc.setDeleted("n");
		aService.save(atc);
		return "backend/article/viewAllArticleAdmin";
	}

	@ModelAttribute("tagList")
	public Map<String, String> getTags() {
		Map<String, String> tagList = new LinkedHashMap<String, String>();
		tagList.put("BTC", "BTC");
        tagList.put("ETH", "ETH");
        tagList.put("USDT", "USDT");
        tagList.put("USDC", "USDC");
        tagList.put("BNB", "BNB");
        tagList.put("XRP", "XRP");
        tagList.put("ADA", "ADA");
        tagList.put("BUSD", "BUSD");
        tagList.put("SOL", "SOL");
        tagList.put("DOGE", "DOGE");
        tagList.put("DOT", "DOT");
        tagList.put("AVAX", "AVAX");
        tagList.put("WBTC", "WBTC");
        tagList.put("TRX", "TRX");
        tagList.put("SHIB", "SHIB");
        tagList.put("DAI", "DAI");
        tagList.put("MATIC", "MATIC");
        tagList.put("CRO", "CRO");
        tagList.put("LEO", "LEO");
        tagList.put("LTC", "LTC");
        tagList.put("NEAR", "NEAR");
        tagList.put("FTT", "FTT");
        tagList.put("BCH", "BCH");
        tagList.put("UNI", "UNI");
        tagList.put("LINK", "LINK");
        tagList.put("XLM", "XLM");
        tagList.put("ATOM", "ATOM");
        tagList.put("ALGO", "ALGO");
        tagList.put("XMR", "XMR");
        tagList.put("FLOW", "FLOW");
        tagList.put("ETC", "ETC");
        tagList.put("APE", "APE");
        tagList.put("MANA", "MANA");
        tagList.put("HBAR", "HBAR");
        tagList.put("EGLD", "EGLD");
        tagList.put("VET", "VET");
        tagList.put("ICP", "ICP");
        tagList.put("FIL", "FIL");
        tagList.put("SAND", "SAND");
        tagList.put("XTZ", "XTZ");
        tagList.put("MKR", "MKR");
        tagList.put("ZEC", "ZEC");
        tagList.put("KCS", "KCS");
        tagList.put("THETA", "THETA");
        tagList.put("CAKE", "CAKE");
        tagList.put("EOS", "EOS");
        tagList.put("AXS", "AXS");
        tagList.put("TUSD", "TUSD");
        tagList.put("GRT", "GRT");
        tagList.put("AAVE", "AAVE");
        tagList.put("UST", "UST");
        tagList.put("KLAY", "KLAY");
        tagList.put("HT", "HT");
        tagList.put("RUNE", "RUNE");
        tagList.put("HNT", "HNT");
        tagList.put("BTT", "BTT");
        tagList.put("BSV", "BSV");
        tagList.put("MIOTA", "MIOTA");
        tagList.put("USDP", "USDP");
        tagList.put("XEC", "XEC");
        tagList.put("FTM", "FTM");
        tagList.put("GMT", "GMT");
        tagList.put("QNT", "QNT");
        tagList.put("USDN", "USDN");
        tagList.put("NEXO", "NEXO");
        tagList.put("STX", "STX");
        tagList.put("OKB", "OKB");
        tagList.put("NEO", "NEO");
        tagList.put("WAVES", "WAVES");
        tagList.put("CHZ", "CHZ");
        tagList.put("CVX", "CVX");
        tagList.put("KSM", "KSM");
        tagList.put("ZIL", "ZIL");
        tagList.put("ENJ", "ENJ");
        tagList.put("DASH", "DASH");
        tagList.put("CELO", "CELO");
        tagList.put("LRC", "LRC");
        tagList.put("CRV", "CRV");
        tagList.put("GALA", "GALA");
        tagList.put("PAXG", "PAXG");
        tagList.put("BAT", "BAT");
        tagList.put("AMP", "AMP");
        tagList.put("GNO", "GNO");
        tagList.put("ONE", "ONE");
        tagList.put("XDC", "XDC");
        tagList.put("AR", "AR");
        tagList.put("MINA", "MINA");
        tagList.put("XEM", "XEM");
        tagList.put("DCR", "DCR");
        tagList.put("KDA", "KDA");
        tagList.put("COMP", "COMP");
        tagList.put("HOT", "HOT");
        tagList.put("KAVA", "KAVA");
        tagList.put("LDO", "LDO");
        tagList.put("GT", "GT");
        tagList.put("FEI", "FEI");
        tagList.put("QTUM", "QTUM");
        tagList.put("BNT", "BNT");
        tagList.put("1INCH", "1INCH");
        tagList.put("XYM", "XYM");
//		tagList.put("BTC", "比特幣");
//		tagList.put("BCH", "比特幣現金");
//		tagList.put("ETH", "以太幣");
//		tagList.put("XRP", "瑞波幣");
//		tagList.put("LTC", "萊特幣");
//		tagList.put("EOS", "柚子幣");
//		tagList.put("XLM", "恆星幣");
//		tagList.put("ADA", "艾達幣");
		return tagList;
	}



//	@PostMapping("/viewArticle/{id}")
//	public void viewArticle2(HttpSession session, Model model, @PathVariable("id") Integer id,  @RequestParam(name="p", defaultValue ="1") Integer pageNumber) throws IOException{
//		//增加文章瀏覽數
//		aService.increasePageView(session, id);
//	}

//	@GetMapping("/viewArticle/{id}")
//    public String viewArticle(HttpSession session, Model model, @PathVariable("id") Integer id) throws IOException{
//		Page<Comment> page = cService.findByPage(pageNumber);
//		model.addAttribute("page",page);

//        List<Comment> commentsList;
//        List<Comment> replyList;

//		Article atc = aService.findById(id);
//		model.addAttribute("Article", atc);	

//		Comment comm = new Comment();
//		model.addAttribute("comment", comm);
//		
//		Comment reply = new Comment();
//		model.addAttribute("reply", reply);

	// 增加文章瀏覽數
//		long lastAccessedTime = session.getLastAccessedTime();
//		long creationTime = session.getCreationTime();
//		System.out.println("lastAccessedTime:"+lastAccessedTime);
//		System.out.println("creationTime:"+creationTime);
//		System.out.println(lastAccessedTime-creationTime);
//		aService.increasePageView(session, id);

//        synchronized (ArticleController.class) {
//            commentsList = cService.selectComm(id);  //查詢所有評論
//            replyList = cService.selectReply(id);  //查詢所有對評論的回復
//        }
//        model.addAttribute("commentsList", commentsList);
//        model.addAttribute("replyList", replyList);

//        return "viewArticle";
//    }

//	@GetMapping("/article/viewArticleByTag")
//	public String viewArticlePageByTag(Model model, @RequestParam("tag")String rTag ,@RequestParam(name="p", defaultValue ="1") Integer pageNumber) {
//		
//		System.out.println("#########################################"+rTag);
//		Page<Article> page = aService.findByPageAndTag(pageNumber, rTag);
//		model.addAttribute("page",page);
//		
//		return "viewAll";
//	}

//	@GetMapping("/article/viewArticle")
//	public String viewArticlePage(Model model, Article atc, @ModelAttribute("tag")String tag ,@RequestParam(name="p", defaultValue ="1") Integer pageNumber) {
//		
//		Page<Article> page = aService.findByPage(pageNumber);
//		model.addAttribute("page",page);
//		
//		model.addAttribute("tag", atc.getTag());
//		
//		return "viewAll";
//	}

//	@ResponseBody
//	@GetMapping("/commentList")
//	public List<Comment> commentList(@RequestParam Integer aid) {
//		
//		
//		List<Comment> allComm = cService.selectComm(aid);
//		System.out.println(allComm);
//		return allComm;
//	}

//	@ResponseBody
//	@GetMapping("/replyList")
//	public List<Comment> replyList(@RequestParam Integer aid) {
//		List<Comment> allComm;
//		
//		allComm = cService.selectReply(aid);
//		System.out.println(allComm);
//		return allComm;
//	}

}
