package com.Group1.CoinShell.controller.Habufly;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Group1.CoinShell.model.Habufly.Comment;
import com.Group1.CoinShell.service.Habufly.ArticleService;
import com.Group1.CoinShell.service.Habufly.CommentService;

@Controller
public class ComPostController {
    @Autowired
    private CommentService cService;
    @Autowired
    private ArticleService aService;

    @ResponseBody
    @GetMapping("/viewComment")
    public List<Map<String,Object>> viewComment(@RequestParam Integer articleId) throws IOException{
    	List<Map<String,Object>> allComm = cService.selectComm(articleId);
    	return allComm;
    }
 // http://localhost:8080/coinshell/viewComment?articleId=1
    
    @ResponseBody
    @GetMapping("/viewReplyAdmin")
    public List<Map<String,Object>> viewReplyAdmin(@RequestParam Integer articleId, @RequestParam Integer commentId) throws IOException{
    	List<Map<String,Object>> allReply = cService.selectReplyAdmin(articleId, commentId);
    	return allReply;
    }
    
    @ResponseBody
    @GetMapping("/viewCommentAdmin")
    public List<Map<String,Object>> viewCommentAdmin(@RequestParam Integer articleId) throws IOException{
    	List<Map<String,Object>> allComm = cService.selectCommAdmin(articleId);
    	return allComm;
    }
 // http://localhost:8080/coinshell/viewComment?articleId=1
    
    @ResponseBody
    @GetMapping("/viewReply")
    public List<Map<String,Object>> viewReply(@RequestParam Integer articleId, @RequestParam Integer commentId) throws IOException{
    	List<Map<String,Object>> allReply = cService.selectReply(articleId, commentId);
    	return allReply;
    }
    
    @ResponseBody
    @PostMapping("/doComment")
    public List<Map<String,Object>> doComment(@RequestBody Comment comm) throws IOException{
		
    	Integer articleId = comm.getArticleId();
    	List<Map<String,Object>> oldComm = cService.selectComm(articleId);
		System.out.println(oldComm);
		
    	if (comm.getText().equals("") || comm.getUserEmail().equals("") || comm.getUserName().equals("")) {
    		return oldComm;
        }
        //判斷Email的正則表達
        String checkemail = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern regex = Pattern.compile(checkemail);
        Matcher matcher = regex.matcher(comm.getUserEmail());
        if (matcher.matches()==false){
        	return oldComm;
        }
        //設定同時只能執行一個              
        synchronized (ComPostController.class){
        cService.inserComm(comm);
        }
        //取得該Article的評論數並更新
        Integer commentNum = cService.checkCommentNum(articleId, "a");
        aService.updatCommentNum(articleId, commentNum);
        
        List<Map<String,Object>> allComm = cService.selectComm(articleId);
        return allComm;
    }
    
    @ResponseBody
    @PostMapping("/doReply")
    public List<Map<String,Object>> doReply(@RequestBody Comment comm, @RequestParam Integer commentId) throws IOException{
    	
    	Integer articleId = comm.getArticleId();
    	List<Map<String,Object>> oldReply = cService.selectReply(articleId, commentId);
    	System.out.println(oldReply);
    	
    	if (comm.getText().equals("") || comm.getUserEmail().equals("") || comm.getUserName().equals("")) {
    		return oldReply;
    	}
    	//判斷Email的正則表達
    	String checkemail = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
    	Pattern regex = Pattern.compile(checkemail);
    	Matcher matcher = regex.matcher(comm.getUserEmail());
    	if (matcher.matches()==false){
    		return oldReply;
    	}
    	//設定同時只能執行一個              
    	synchronized (ComPostController.class){
    		cService.inserComm(comm);
    	}
    	
    	List<Map<String,Object>> allReply = cService.selectReply(articleId, commentId);
    	return allReply;
    }

    @ResponseBody
    @GetMapping("/editSection")
    public List<Map<String,Object>> editSection(@RequestParam Integer cid) throws IOException {
		List<Map<String,Object>> cR;
		
		cR = cService.findCRById(cid);
		return cR;
    }
 // http://localhost:8080/coinshell/editSection?cid=1
    
    @ResponseBody
    @PostMapping("/postEdit")
    public void postEdit(@RequestBody Comment comm) throws IOException{
    	   	
    	if (comm.getText().equals("") || comm.getUserEmail().equals("") || comm.getUserName().equals("")) {
    		return;
    	}
    	//判斷Email的正則表達
    	String checkemail = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
    	Pattern regex = Pattern.compile(checkemail);
    	Matcher matcher = regex.matcher(comm.getUserEmail());
    	if (matcher.matches()==false){
    		return;
    	}
    	//設定同時只能執行一個              
    	synchronized (ComPostController.class){
    		cService.inserComm(comm);
    	}
    	
    	return;
    }
    // http://localhost:8080/coinshell/postEdit
    
    @ResponseBody
    @GetMapping("/deleteCR")
    public void deleteCR(@RequestParam Integer id, @RequestParam Integer articleId)throws IOException {
    	//刪除
    	cService.delete(id); 
    	
    	//取得該Article的評論數並更新
        Integer commentNum = cService.checkCommentNum(articleId, "a");
        aService.updatCommentNum(articleId, commentNum);
        
    	return;
    }
    
    @ResponseBody
    @GetMapping("/undoCR")
    public void undoCR(@RequestParam Integer id, @RequestParam Integer articleId)throws IOException {
    	//刪除
    	cService.undoCR(id); 
    	
    	//取得該Article的評論數並更新
        Integer commentNum = cService.checkCommentNum(articleId, "a");
        aService.updatCommentNum(articleId, commentNum);
        
    	return;
    }
    
//    @RequestMapping(value = "/manage/deletecomment", method = RequestMethod.POST)
//    public @ResponseBody String setArticle(@RequestParam int id,@RequestParam int page,HttpServletRequest request)throws IOException{
////        String Iid = request.getParameter("delete");
////        int IDid = Integer.parseInt(id);
////        System.out.println("delete: "+Iid);
//        commentService.deleteReply(id);          //先刪除所有對評論的回覆
//        commentService.deleteCom(id);			//刪除評論
//        return "success";
//    }
//
}
