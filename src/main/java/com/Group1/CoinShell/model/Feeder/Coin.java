package com.Group1.CoinShell.model.Feeder;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "coin")
public class Coin {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

//	@Id
//	@Column(name = "coinid")
//	private Integer coid;

	@Column(name = "name")
	private String name;

	@Column(name = "symbol")
	private String symbol;

	@Column(name = "slug")
	private String slug;

	@Column(name = "tags")
	private String[] tags;

	@Column(name = "cmcRank")
	private Integer cmcRank;

	@Column(name = "marketPairCount")
	private Integer marketPairCount;

	@Column(name = "circulatingSupply")
	private Double circulatingSupply;

	@Column(name = "selfReportedCirculatingSupply")
	private Double selfReportedCirculatingSupply;

	@Column(name = "totalSupply")
	private Double totalSupply;

	@Column(name = "maxSupply")
	private Double maxSupply;

	@Column(name = "isActive")
	private Integer isActive;

	// @JsonFormat(locale = "tw", timezone = "GMT+8", pattern = "yyyy-MM-dd
	// HH:mm:ss")
	@Column(name = "lastUpdated")
	private String lastUpdated;

	// @JsonFormat(locale = "tw", timezone = "GMT+8", pattern = "yyyy-MM-dd
	// HH:mm:ss")
	@Column(name = "dateAdded")
	private String dateAdded;

	@Column(name = "quotesName")
	private String quotesName;

	@Column(name = "price")
	private Double price;

	@Column(name = "volume24h")
	private Double volume24h;

	@Column(name = "marketCap")
	private Double marketCap;

	@Column(name = "percentChange1h")
	private Double percentChange1h;

	@Column(name = "percentChange24h")
	private Double percentChange24h;

	@Column(name = "percentChange7d")
	private Double percentChange7d;

	@Column(name = "percentChange30d")
	private Double percentChange30d;

	@Column(name = "percentChange60d")
	private Double percentChange60d;

	@Column(name = "percentChange90d")
	private Double percentChange90d;

	@Column(name = "fullyDilluttedMarketCap")
	private Double fullyDilluttedMarketCap;

	@Column(name = "marketCapByTotalSupply")
	private Double marketCapByTotalSupply;

	@Column(name = "dominance")
	private Double dominance;

	@Column(name = "turnover")
	private Double turnover;

	@Column(name = "ytdPriceChangePercentage")
	private Double ytdPriceChangePercentage;

	@Column(name = "isAudited")
	private boolean isAudited;

	@Column(name = "auditor")
	private String auditor;

	@Column(name = "auditStatus")
	private Integer auditStatus;

	@Column(name = "reportUrl")
	private String reportUrl;
	
//	@Column(name = "flag")
//	private String flag;

	public Coin() {
	}


	@Override
	public String toString() {
		return "Coin [id=" + id + ", name=" + name + ", symbol=" + symbol + ", slug=" + slug + ", tags="
				+ Arrays.toString(tags) + ", cmcRank=" + cmcRank + ", marketPairCount=" + marketPairCount
				+ ", circulatingSupply=" + circulatingSupply + ", selfReportedCirculatingSupply="
				+ selfReportedCirculatingSupply + ", totalSupply=" + totalSupply + ", maxSupply=" + maxSupply
				+ ", isActive=" + isActive + ", lastUpdated=" + lastUpdated + ", dateAdded=" + dateAdded
				+ ", quotesName=" + quotesName + ", price=" + price + ", volume24h=" + volume24h + ", marketCap="
				+ marketCap + ", percentChange1h=" + percentChange1h + ", percentChange24h=" + percentChange24h
				+ ", percentChange7d=" + percentChange7d + ", percentChange30d=" + percentChange30d
				+ ", percentChange60d=" + percentChange60d + ", percentChange90d=" + percentChange90d
				+ ", fullyDilluttedMarketCap=" + fullyDilluttedMarketCap + ", marketCapByTotalSupply="
				+ marketCapByTotalSupply + ", dominance=" + dominance + ", turnover=" + turnover
				+ ", ytdPriceChangePercentage=" + ytdPriceChangePercentage + ", isAudited=" + isAudited + ", auditor="
				+ auditor + ", auditStatus=" + auditStatus + ", reportUrl=" + reportUrl + "]";
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String[] getTags() {
		return tags;
	}

	public void setTags(String[] tags) {
		this.tags = tags;
	}

	public Integer getCmcRank() {
		return cmcRank;
	}

	public void setCmcRank(Integer cmcRank) {
		this.cmcRank = cmcRank;
	}

	public Integer getMarketPairCount() {
		return marketPairCount;
	}

	public void setMarketPairCount(Integer marketPairCount) {
		this.marketPairCount = marketPairCount;
	}

	public Double getCirculatingSupply() {
		return circulatingSupply;
	}

	public void setCirculatingSupply(Double circulatingSupply) {
		this.circulatingSupply = circulatingSupply;
	}

	public Double getSelfReportedCirculatingSupply() {
		return selfReportedCirculatingSupply;
	}

	public void setSelfReportedCirculatingSupply(Double selfReportedCirculatingSupply) {
		this.selfReportedCirculatingSupply = selfReportedCirculatingSupply;
	}

	public Double getTotalSupply() {
		return totalSupply;
	}

	public void setTotalSupply(Double totalSupply) {
		this.totalSupply = totalSupply;
	}

	public Double getMaxSupply() {
		return maxSupply;
	}

	public void setMaxSupply(Double maxSupply) {
		this.maxSupply = maxSupply;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public String getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public String getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(String dateAdded) {
		this.dateAdded = dateAdded;
	}

	public String getQuotesName() {
		return quotesName;
	}

	public void setQuotesName(String quotesName) {
		this.quotesName = quotesName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getVolume24h() {
		return volume24h;
	}

	public void setVolume24h(Double volume24h) {
		this.volume24h = volume24h;
	}

	public Double getMarketCap() {
		return marketCap;
	}

	public void setMarketCap(Double marketCap) {
		this.marketCap = marketCap;
	}

	public Double getPercentChange1h() {
		return percentChange1h;
	}

	public void setPercentChange1h(Double percentChange1h) {
		this.percentChange1h = percentChange1h;
	}

	public Double getPercentChange24h() {
		return percentChange24h;
	}

	public void setPercentChange24h(Double percentChange24h) {
		this.percentChange24h = percentChange24h;
	}

	public Double getPercentChange7d() {
		return percentChange7d;
	}

	public void setPercentChange7d(Double percentChange7d) {
		this.percentChange7d = percentChange7d;
	}

	public Double getPercentChange30d() {
		return percentChange30d;
	}

	public void setPercentChange30d(Double percentChange30d) {
		this.percentChange30d = percentChange30d;
	}

	public Double getPercentChange60d() {
		return percentChange60d;
	}

	public void setPercentChange60d(Double percentChange60d) {
		this.percentChange60d = percentChange60d;
	}

	public Double getPercentChange90d() {
		return percentChange90d;
	}

	public void setPercentChange90d(Double percentChange90d) {
		this.percentChange90d = percentChange90d;
	}

	public Double getFullyDilluttedMarketCap() {
		return fullyDilluttedMarketCap;
	}

	public void setFullyDilluttedMarketCap(Double fullyDilluttedMarketCap) {
		this.fullyDilluttedMarketCap = fullyDilluttedMarketCap;
	}

	public Double getMarketCapByTotalSupply() {
		return marketCapByTotalSupply;
	}

	public void setMarketCapByTotalSupply(Double marketCapByTotalSupply) {
		this.marketCapByTotalSupply = marketCapByTotalSupply;
	}

	public Double getDominance() {
		return dominance;
	}

	public void setDominance(Double dominance) {
		this.dominance = dominance;
	}

	public Double getTurnover() {
		return turnover;
	}

	public void setTurnover(Double turnover) {
		this.turnover = turnover;
	}

	public Double getYtdPriceChangePercentage() {
		return ytdPriceChangePercentage;
	}

	public void setYtdPriceChangePercentage(Double ytdPriceChangePercentage) {
		this.ytdPriceChangePercentage = ytdPriceChangePercentage;
	}

	public boolean isAudited() {
		return isAudited;
	}

	public void setAudited(boolean isAudited) {
		this.isAudited = isAudited;
	}

	public String getAuditor() {
		return auditor;
	}

	public void setAuditor(String auditor) {
		this.auditor = auditor;
	}

	public Integer getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(Integer auditStatus) {
		this.auditStatus = auditStatus;
	}

	public String getReportUrl() {
		return reportUrl;
	}

	public void setReportUrl(String reportUrl) {
		this.reportUrl = reportUrl;
	}
	

}