package com.Group1.CoinShell.model.Feeder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "watch")
public class Watch {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "watch_id")
	private Integer watchId;

	@Column(name = "memberId")
	private Integer memberId;

	@Column(name = "coinId")
	private Integer coinId;

	public Watch() {
	}

	@Override
	public String toString() {
		return "Watch [watchId=" + watchId + ", memberId=" + memberId + ", coinId=" + coinId + "]";
	}

	public Integer getWatchId() {
		return watchId;
	}

	public void setWatchId(Integer watchId) {
		this.watchId = watchId;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public Integer getCoinId() {
		return coinId;
	}

	public void setCoinId(Integer coinId) {
		this.coinId = coinId;
	}

}