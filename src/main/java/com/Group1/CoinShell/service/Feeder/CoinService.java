package com.Group1.CoinShell.service.Feeder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Group1.CoinShell.model.Feeder.Coin;
import com.Group1.CoinShell.model.Feeder.CoinDao;

@Service
@Transactional
public class CoinService {

	@Autowired
	private CoinDao coindao;

	//從coinmarketAPI抓資料存進coin用
	public Coin save(Coin coin) {
		return coindao.save(coin);
	}

	public void saveAll(List<Coin> coin) {
		coindao.saveAll(coin);
	}
	
	//從資料庫抓全部coin的資料出來
	public List<Coin> findAll() {
		return coindao.findAll();
	}
	//有參數時(有登入時)
	public List<Map<String, Object>> getCoin(Integer memberId) {
		return coindao.getCoin(memberId);
	}
	//無參數時(未登入 member=null時)
	public List<Map<String, Object>> getCoin() {
		return coindao.getCoin();
		}
	
	public List<Map<String, Object>> getHeighSetCoin(Integer memberId) {
		return coindao.getHeighSetCoin(memberId);
	}
	public List<Map<String, Object>> getLowerSetCoin(Integer memberId) {
		return coindao.getLowerSetCoin(memberId);
	}
	
	//給watch用name抓幣用
	public List<Coin> findByName(String name) {
		return coindao.findByName(name);
	}
	
	//透過name跟symbol模糊查詢幣
	public List<Coin> findByName2(String name) {
		return  coindao.findByName2(name);
	    }
	
	//型態為Coin
	public Coin findByName3(String name) {
		return coindao.findByName3(name);
	}

	//型態為List<Coin>
	public List<Coin> findByCoinId(Integer id) {
		return coindao.findByCoinId(id);
	}
	
	//型態為Coin
	public Coin findByCoinId2(Integer id) {
		return coindao.findByCoinId2(id);
	}
	
	public String getContent(String strUrl) {
		// 一個public方法,返回字串,錯誤則返回"error open url"
		try {
			URL url = new URL(strUrl);
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
			String s = "";
			StringBuffer sb = new StringBuffer("");
			while ((s = br.readLine()) != null) {
				sb.append(s);
			}
			br.close();
			return sb.toString();

		} catch (Exception e) {
			return "error open url: " + strUrl;
		}
	}
	
	public String getContent1(String strUrl) {
		// 一個public方法,返回字串,錯誤則返回"error open url"
		try {
			URL url = new URL(strUrl);
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
			String s = "";
			StringBuffer sb = new StringBuffer("");
			while ((s = br.readLine()) != null) {
				sb.append(s);
			}
			br.close();
			return sb.substring(sb.indexOf("["), sb.lastIndexOf("]") + 1).toString();

		} catch (Exception e) {
			return "error open url: " + strUrl;
		}
	}

	public Coin findLastestCurrencyInformation(String currencyName) {
		Coin findLastestCurrencyInformation = coindao.findLastestCurrencyInformation(currencyName);
		return findLastestCurrencyInformation;
	}

}
