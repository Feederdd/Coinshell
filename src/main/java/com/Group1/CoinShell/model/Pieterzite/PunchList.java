package com.Group1.CoinShell.model.Pieterzite;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.Group1.CoinShell.model.Yiwen.Members;

@Entity
@Table(name = "punch_list") // 簽到表
public class PunchList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "list_Id") // 表單編號
	private Integer listId; 
	
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "punch_count") // 連續簽到天數
	private Integer punchCount; 
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "punch_datetime") // 簽到時間
	private Date punchDateTime;
	
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "member_Id") 
	private Members member;
	
	
	public PunchList() {
	}

	public Integer getListId() {
		return listId;
	}

	public void setListId(Integer listId) {
		this.listId = listId;
	}

	public int getPunchCount() {
		return punchCount;
	}

	public void setPunchCount(Integer punchCount) {
		this.punchCount = punchCount;
	}

	public Date getPunchDateTime() {
		return punchDateTime;
	}

	public void setPunchDateTime(Date punchDateTime) {
		this.punchDateTime = punchDateTime;
	}

	public int getMemberId() {
		return member.getId();
	}

	public void setMember(Members member) {
		this.member = member;
	}
}
