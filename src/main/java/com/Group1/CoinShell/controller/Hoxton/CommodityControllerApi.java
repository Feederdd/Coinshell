package com.Group1.CoinShell.controller.Hoxton;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Group1.CoinShell.model.Hoxton.Cart;
import com.Group1.CoinShell.model.Hoxton.CartItem;
import com.Group1.CoinShell.model.Hoxton.Commodity;
import com.Group1.CoinShell.service.Hoxton.CommodityService;

@RestController
public class CommodityControllerApi {

	@Autowired
	private CommodityService service;

	@GetMapping("/allCommodity")
	public List<Commodity> findAllCommodity() {
		List<Commodity> findAllCommodity = service.findAllCommodity();
		return findAllCommodity;
	}
	// http://localhost:8080/coinshell/allCommodity

	@GetMapping("/Commodity")
	public List<Commodity> findCommodityByName(@RequestParam("name") String name) {
		List<Commodity> commodityLIst = service.findCommodityByName(name);
		return commodityLIst;
	}

	@GetMapping("showCart")
	public Map<Integer, CartItem> returnJson(HttpServletRequest req) {
		HttpSession session = req.getSession();
		String id = session.getId();
		Cart cart = (Cart) session.getAttribute("cart");
		Map<Integer, CartItem> commodityMap = cart.getCommodityMap();
		Integer price = cart.getPrice();
		String price2 = Integer.toString(price);
		return commodityMap;
	}
	// http://localhost:8080/coinshell/showCart
	
}
