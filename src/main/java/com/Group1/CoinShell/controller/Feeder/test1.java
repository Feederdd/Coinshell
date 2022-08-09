package com.Group1.CoinShell.controller.Feeder;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Group1.CoinShell.model.Feeder.Coin;
import com.Group1.CoinShell.service.Feeder.CoinService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class test1 {

	private static CoinService coinService;

//	@Scheduled(initialDelay = 2000, fixedRate = 500000)
	public static void test() throws JsonParseException, IOException {

		// 取得網頁內容並生成JAVA字串物件 網址內容本身就是JSON字串 故不用再轉JSON格式
		String strUrl    = "https://api.coinmarketcap.com/data-api/v3/cryptocurrency/listing?start=1&limit=100&sortBy=market_cap&sortType=desc&convert=USD&cryptoType=all&tagType=all&audited=false";
		String coinstr1  = coinService.getContent1(strUrl);

		JSONArray jArray = new JSONArray(coinstr1);
		if (jArray != null) {
			for (Object obj : jArray) {
				JSONObject jo = (JSONObject) obj;

				Integer coinId  = jo.getInt("id");
				String  name    = jo.getString("name");
				String  symbol  = jo.getString("symbol");
				String  slug    = jo.getString("slug");
//				String  tags    = jo.getJSONArray("tags").toString();  //list 目前不會寫
				Integer cmcRank = jo.getInt("cmcRank");
				Integer marketPairCount   = jo.getInt("marketPairCount");
				Double  circulatingSupply = jo.getDouble("circulatingSupply");
				Double  selfRCSupply      = jo.getDouble("selfReportedCirculatingSupply");
				Double  totalSupply       = jo.getDouble("totalSupply");
				
				//如果 沒有 "maxSupply" 這個key 則補 key : value 為  "maxSupply" : 0.0
				if(!jo.has("maxSupply")) {
					jo.put("maxSupply", 0.0);
				}
				
				Double  maxSupply        = jo.getDouble("maxSupply");
				Integer isActive         = jo.getInt("isActive");
				String  lastUpdated      = jo.getString("lastUpdated");
				String  dateAdded        = jo.getString("dateAdded");
				String  quotesName       = jo.getJSONArray("quotes").getJSONObject(0).getString("name"); //找到quotes下的第1層[]裡面的key
				Double  price            = jo.getJSONArray("quotes").getJSONObject(0).getDouble("price");
				Double  volume24h        = jo.getJSONArray("quotes").getJSONObject(0).getDouble("volume24h");
				Double  marketCap        = jo.getJSONArray("quotes").getJSONObject(0).getDouble("marketCap");
				Double  percentChange1h  = jo.getJSONArray("quotes").getJSONObject(0).getDouble("percentChange1h");
				Double  percentChange24h = jo.getJSONArray("quotes").getJSONObject(0).getDouble("percentChange24h");
				Double  percentChange7d  = jo.getJSONArray("quotes").getJSONObject(0).getDouble("percentChange7d");
				Double  percentChange30d = jo.getJSONArray("quotes").getJSONObject(0).getDouble("percentChange30d");
				Double  percentChange60d = jo.getJSONArray("quotes").getJSONObject(0).getDouble("percentChange60d");
				Double  percentChange90d = jo.getJSONArray("quotes").getJSONObject(0).getDouble("percentChange90d");
				Double  fullyDilluttedMarketCap  = jo.getJSONArray("quotes").getJSONObject(0).getDouble("fullyDilluttedMarketCap");
				Double  marketCapByTotalSupply   = jo.getJSONArray("quotes").getJSONObject(0).getDouble("marketCapByTotalSupply");
				Double  ytdPriceChangePercentage = jo.getJSONArray("quotes").getJSONObject(0).getDouble("ytdPriceChangePercentage");
				Double  dominance   = jo.getJSONArray("quotes").getJSONObject(0).getDouble("dominance");
				Double  turnover    = jo.getJSONArray("quotes").getJSONObject(0).getDouble("turnover");
				boolean isAudited   = jo.getBoolean("isAudited");
				

				Coin coin = new Coin();
				
				coin.setId(coinId); // ( 存的是貨幣本身的ID代號 save方法:已經有id的值會自動變更新)
				coin.setName(name);
				coin.setSymbol(symbol);
				coin.setSlug(slug);
				coin.setCmcRank(cmcRank);
				coin.setMarketPairCount(marketPairCount);
				coin.setCirculatingSupply(circulatingSupply);
				coin.setSelfReportedCirculatingSupply(selfRCSupply);
				coin.setTotalSupply(totalSupply);
				coin.setMaxSupply(maxSupply);
				coin.setIsActive(isActive);
				coin.setLastUpdated(lastUpdated);
				coin.setDateAdded(dateAdded);
				coin.setQuotesName(quotesName);
				coin.setPrice(price);
				coin.setVolume24h(volume24h);
				coin.setMarketCap(marketCap);
				coin.setPercentChange1h(percentChange1h);
				coin.setPercentChange24h(percentChange24h);
				coin.setPercentChange7d(percentChange7d);
				coin.setPercentChange30d(percentChange30d);
				coin.setPercentChange60d(percentChange60d);
				coin.setPercentChange90d(percentChange90d);
				coin.setFullyDilluttedMarketCap(fullyDilluttedMarketCap);
				coin.setMarketCapByTotalSupply(marketCapByTotalSupply);
				coin.setDominance(dominance);
				coin.setTurnover(turnover);
				coin.setYtdPriceChangePercentage(ytdPriceChangePercentage);
				coin.setAudited(isAudited);

				coinService.save(coin);
			}
		}

}
	@Autowired
	public void setCoinService(CoinService coinService) {
		this.coinService = coinService;
	}

}
