package com.Group1.CoinShell.model.Feeder;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

@Component
public class StarDTO {
	
	@JsonProperty("memId")
	private Integer memId;
	@JsonProperty("coinId")
	private Integer coinId;
	@JsonProperty("setPrice")
	private Float setPrice;
	@JsonProperty("id")
	private Integer newsId;
	@JsonProperty("title")
	private String newsTitle;
	@JsonProperty("url")
	private String newsUrl;
	@JsonProperty("imgUrl")
	private String newsImgUrl;
	
	private String type;
	
	public Integer getMemId() {
		return memId;
	}
	public void setMemId(Integer memId) {
		this.memId = memId;
	}
	public Integer getCoinId() {
		return coinId;
	}
	public void setCoinId(Integer coinId) {
		this.coinId = coinId;
	}
	public Float getSetPrice() {
		return setPrice;
	}
	public void setSetPrice(Float setPrice) {
		this.setPrice = setPrice;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getNewsId() {
		return newsId;
	}
	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}
	public String getNewsTitle() {
		return newsTitle;
	}
	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}
	public String getNewsUrl() {
		return newsUrl;
	}
	public void setNewsUrl(String newsUrl) {
		this.newsUrl = newsUrl;
	}
	public String getNewsImgUrl() {
		return newsImgUrl;
	}
	public void setNewsImgUrl(String newsImgUrl) {
		this.newsImgUrl = newsImgUrl;
	}
	
	

}
