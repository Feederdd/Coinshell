package com.Group1.CoinShell.model.Yiwen;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customizedUserAvatar")
public class CustomizedUserAvatar {

	@Id
	@Column(name="id", columnDefinition="int")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="userAvatar", columnDefinition="VARBINARY(MAX)", nullable = false)
	private byte[] userAvatar;
	
	@Column(name="aliasAvatar", columnDefinition="nvarchar(50)", nullable = false)
	private String aliasAvatar;
	

//	@OneToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "member_id")
//	private Members members;
	

	public CustomizedUserAvatar() {
	}

	public CustomizedUserAvatar(Integer id, byte[] userAvatar, String aliasAvatar) {
		super();
		this.id = id;
		this.userAvatar = userAvatar;
		this.aliasAvatar = aliasAvatar;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public byte[] getUserAvatar() {
		return userAvatar;
	}

	public void setUserAvatar(byte[] userAvatar) {
		this.userAvatar = userAvatar;
	}

	public String getAliasAvatar() {
		return aliasAvatar;
	}

	public void setAliasAvatar(String aliasAvatar) {
		this.aliasAvatar = aliasAvatar;
	}

}
