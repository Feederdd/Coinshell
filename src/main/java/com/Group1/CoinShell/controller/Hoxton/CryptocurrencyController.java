package com.Group1.CoinShell.controller.Hoxton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Group1.CoinShell.model.Hoxton.Cryptocurrency;
import com.Group1.CoinShell.model.Hoxton.CryptocurryencyDao;

@Controller
public class CryptocurrencyController {

	@Autowired
	private CryptocurryencyDao dao;

	@GetMapping("/individualCryptocurrencyInformation")
	public String getCryptocurrency(@RequestParam("currencyName") String name, @RequestParam("currentlyDay") String day,
			Model model) {
		Cryptocurrency lastestCurrencyInformation = dao.findLastestCurrencyInformation(name);
		dao.findHistoricalCurrencyInformation(name);
		model.addAttribute("currencyInformation", lastestCurrencyInformation);
		System.out.println(lastestCurrencyInformation);
		return "individualCryptocurrencyInformation";
	}
	//http://localhost:8080/coinshell/individualCryptocurrencyInformation?currencyName=btc&currentlyDay=2022-05-17

	


}
