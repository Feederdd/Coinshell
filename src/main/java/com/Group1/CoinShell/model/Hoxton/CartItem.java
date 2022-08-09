package com.Group1.CoinShell.model.Hoxton;

public class CartItem {
	
private Commodity commodity;
private Integer quantity;
private Integer price;

public Commodity getCommodity() {
	return commodity;
}

public void setCommodity(Commodity commodity) {
	this.commodity = commodity;
}
public Integer getQuantity() {
	return quantity;
}
public void setQuantity(Integer quantity) {
	this.quantity = quantity;
}
public Integer getPrice() {
	return commodity.getShell()*this.quantity;
}
public void setPrice(Integer price) {
	this.price = price;
}


}
