package com.Group1.CoinShell.model.Habufly;

import java.util.Date;
import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="comment")
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="user_id")
	private Integer userId;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="user_email")
	private String userEmail;

//	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")//M指月份m指分鐘//這是丟出來的資料型態
	@Temporal(TemporalType.TIMESTAMP)//這是存進去的資料型態
	@Column(name="added", columnDefinition = "datetime")
	private Date added;
	
	@Column(name="text", columnDefinition = "nvarchar(200)")//預設是varchar(255)，因為可能有中文改為nvarchar
	private String text;
	
	@Column(name="type")
	private String type;//type存'a'表示對文章的回复，存'b'表示對評論的回复,type in ('a','b')
	
	@Column(name="deleted", columnDefinition = "varchar(2) default 'n'")
	private String deleted;//deleted存'n'表示文章存在，存'y'表示文章已刪除,type in ('n','y')
	
	@Column(name="article_id")
	private Integer articleId;
	
	@Column(name="comment_id")
	private Integer commentId; //编程时规定:对评论的回复不能被回复
	
	public Comment() {
	}

    public Comment(String userName, Integer userId,String userEmail, Date added, String deleted, String text, String type, Integer articleId, Integer commentId) {
        this.userName = userName;
        this.userId = userId;
        this.userEmail = userEmail;
        this.added = added;
        this.deleted = deleted;
        this.text = text;
        this.type = type;
        this.articleId = articleId;
        this.commentId = commentId;
    }

	@PrePersist //物件狀態轉換到 persist 之前，要做的事情
	public void onCreate() {
		if(added==null) {
			added = new Date();
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Date getAdded() {
		return added;
	}

	public void setAdded(Date added) {
		this.added = added;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}

	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

	public Integer getCommentId() {
		return commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Comment [id=");
		builder.append(id);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", userName=");
		builder.append(userName);
		builder.append(", userEmail=");
		builder.append(userEmail);
		builder.append(", added=");
		builder.append(added);
		builder.append(", text=");
		builder.append(text);
		builder.append(", type=");
		builder.append(type);
		builder.append(", deleted=");
		builder.append(deleted);
		builder.append(", articleId=");
		builder.append(articleId);
		builder.append(", commentId=");
		builder.append(commentId);
		builder.append("]");
		return builder.toString();
	}

	
	
}