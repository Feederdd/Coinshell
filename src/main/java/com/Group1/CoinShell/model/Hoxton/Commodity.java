package com.Group1.CoinShell.model.Hoxton;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="commodity")
public class Commodity {
	
	public Commodity() {
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name="commodity_name",nullable = false)
	private String commodityName;
	
	
	
	@Column(name="shell",nullable = false)
	private Integer shell;
	
	
	@Column(name="photo",columnDefinition = "VARBINARY(MAX)",nullable = false)
	private byte[] photo;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getCommodityName() {
		return commodityName;
	}


	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}


	public Integer getShell() {
		return shell;
	}


	public void setShell(Integer shell) {
		this.shell = shell;
	}


	public byte[] getPhoto() {
		return photo;
	}


	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}


	public Commodity(String commodityName, Integer shell, byte[] photo) {
		this.commodityName = commodityName;
		this.shell = shell;
		this.photo = photo;
	}
	
	
	
	

	

	
}
