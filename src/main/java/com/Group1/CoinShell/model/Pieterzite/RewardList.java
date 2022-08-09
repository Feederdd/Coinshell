package com.Group1.CoinShell.model.Pieterzite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reward_list") // 獎勵表
public class RewardList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "days") // 簽到天數
	private Integer days;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reward") // 對應獎勵
	private Integer reward;
	
	@SuppressWarnings("unused")
	private  RewardList() {
	}

	public RewardList(Integer days, Integer reward) {
		super();
		this.days = days;
		this.reward = reward;
	}

	public Integer getDays() {
		return days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}

	public Integer getReward() {
		return reward;
	}

	public void setReward(Integer reward) {
		this.reward = reward;
	}
}
