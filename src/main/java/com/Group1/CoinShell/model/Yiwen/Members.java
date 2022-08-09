package com.Group1.CoinShell.model.Yiwen;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.springframework.format.annotation.DateTimeFormat;

import com.Group1.CoinShell.model.Pieterzite.PunchList;

@Entity
@Table(name = "members", uniqueConstraints = { @UniqueConstraint(columnNames = { "E_Mail" }) })
public class Members {

	@Id
	@Column(name = "Id", columnDefinition = "int")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "CustomizedUserName", columnDefinition = "nvarchar(60)", nullable = false)
	private String customizedUserName;

	@Column(name = "CustomizedUserAvatar", columnDefinition = "nvarchar(50)")
	private Integer customizedUserAvatar;

	@Column(name = "E_Mail", columnDefinition = "nvarchar(100)", nullable = false)
	private String eMail;

	@Column(name = "Password", columnDefinition = "nvarchar(255)", nullable = false)
	private String password;

	@Column(name = "MyShell", columnDefinition = "money", nullable = false)
	private Integer myShell;

	@Column(name = "Coin", columnDefinition = "money", nullable = false)
	private Integer Coin;

//	@Column(name = "IsPremium", columnDefinition ="bit", nullable=false)
//  private Boolean isPremium

	@DateTimeFormat(pattern = "yyyy/MM/dd")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "JoinTime", columnDefinition = "date", nullable = false)
	private Date joinTime;
	
	@OneToOne(fetch = FetchType.EAGER, mappedBy = "member", cascade = CascadeType.ALL )
	private PunchList punchList = new PunchList();
//	@OneToOne(fetch = FetchType.EAGER, mappedBy = "members", cascade = CascadeType.ALL)
//	private CustomizedUserAvatar customizedUserAvatar1 = new CustomizedUserAvatar();
	

	public Members() {
	}

	public Members(Integer id, String customizedUserName, Integer customizedUserAvatar, String eMail, String password,
			Integer myShell, Integer Coin, Date joinTime) {
		super();
		this.id = id;
		this.customizedUserName = customizedUserName;
		this.customizedUserAvatar = customizedUserAvatar;
		this.eMail = eMail;
		this.password = password;
		this.myShell = myShell;
		this.Coin = Coin;
		this.joinTime = joinTime;
		this.customizedUserAvatar = customizedUserAvatar;
	}
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;

	}

	public String getCustomizedUserName() {
		return customizedUserName;
	}

	public void setCustomizedUserName(String customizedUserName) {
		this.customizedUserName = customizedUserName;
	}

	public Integer getCustomizedUserAvatar() {
		return customizedUserAvatar;
	}

	public void setCustomizedUserAvatar(Integer customizedUserAvatar) {
		this.customizedUserAvatar = customizedUserAvatar;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getMyShell() {
		return myShell;
	}

	public void setMyShell(Integer myShell) {
		this.myShell = myShell;
	}

	public Date getJoinTime() {
		return joinTime;
	}

	public void setJoinTime(Date joinTime) {
		this.joinTime = joinTime;
	}



	public Integer getCoin() {
		return Coin;
	}

	public void setCoin(Integer Coin) {
		this.Coin = Coin;
	}

	//public CustomizedUserAvatar getCustomizedUserAvatar1() {
	//	return customizedUserAvatar1;
	//}

	//public void setCustomizedUserAvatar1(CustomizedUserAvatar customizedUserAvatar1) {
	//	this.customizedUserAvatar1 = customizedUserAvatar1;
	//}


}
