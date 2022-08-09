package com.Group1.CoinShell.model.Hoxton;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.Group1.CoinShell.model.Yiwen.Members;

public class Cart {

private Map<Integer,CartItem> commodityMap = new LinkedHashMap<>();

private double price;

public void addCommodity(Commodity commodity) {
	CartItem cartItem = commodityMap.get(commodity.getId());
	
	if(cartItem==null) {
		 cartItem  = new CartItem();
		 cartItem.setCommodity(commodity);
		 cartItem.setQuantity(1);
		 commodityMap.put(commodity.getId(), cartItem);
	}else {
		cartItem.setQuantity(cartItem.getQuantity()+1);
	}
}
public Integer getPrice() {
	Integer totalPrice=0;
	for(Map.Entry<Integer, CartItem> me:commodityMap.entrySet()) {
		CartItem cartItem = me.getValue();
		totalPrice = cartItem.getPrice();
	}
	return totalPrice;
}
public Map<Integer,CartItem> getCommodityMap(){
	return commodityMap;
}
public void setCommodidyMap(Map<Integer, CartItem>commodityMap) {
	this.commodityMap=commodityMap;
}

public void setPrice(double price) {
	this.price=price;
}

	
}
