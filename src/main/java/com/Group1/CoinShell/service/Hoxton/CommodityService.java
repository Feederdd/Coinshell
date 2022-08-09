package com.Group1.CoinShell.service.Hoxton;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Group1.CoinShell.model.Hoxton.Cart;
import com.Group1.CoinShell.model.Hoxton.Commodity;
import com.Group1.CoinShell.model.Hoxton.CommodityDao;

@Service
@Transactional
public class CommodityService {

	@Autowired
	private CommodityDao dao;

	public void insertcommodity(String commodityName,String discribe,String photo,Integer price,Integer volume,Integer myShell,String shellOrCoin) {
		dao.insertcommodity(commodityName, discribe, photo, price, volume, myShell, shellOrCoin);
	}

	public void deleteCommodityById(Integer id) {
		dao.deleteCommodityById(id);
	}

	public List<Commodity> findCommodityByName(String commodityName) {
		List<Commodity> commodityList = dao.findCommodityByName(commodityName);
		return commodityList;
	}
	
	public Commodity findCommodityById(Integer Id) {
		Commodity commodity = dao.findCommodityById(Id);
		return commodity;
	}
	
	public void updateCommodityById(String commodityName, String discribe, String shell_or_coin,Integer myShell ,Integer coin, Integer volume,Integer id) {
		dao.updateCommodityById(commodityName, discribe, shell_or_coin, myShell, coin, volume, id);
	}
	
	public List<Commodity> findAllCommodity(){
		List<Commodity> commodityList = dao.findAllCommodity();
		return commodityList;
	}
	
	public Map getAll() {
		return (Map) dao.findAll();
	}
	
	public void buyCommodity(Integer id , Cart cart) {
		Commodity commodity = dao.findCommodityById(id);
		cart.addCommodity(commodity);
	}
	
	public void deleteCommodity(Integer id,Cart cart){
		if(cart == null) {
			System.out.println("購物車為空");
		}
		cart.getCommodityMap().remove(id);
	}

}
