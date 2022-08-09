package com.Group1.CoinShell.controller.Feeder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.Group1.CoinShell.model.Feeder.Coin;
import com.Group1.CoinShell.service.Feeder.CoinService;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

@Component
public class test2 {

	private static CoinService coinService;

//	@Scheduled(initialDelay = 2000, fixedRate = 500000)
	public static void test() throws JsonParseException, IOException {
		String strUrl 	= "https://api.coinmarketcap.com/data-api/v3/cryptocurrency/listing?start=1&limit=100&sortBy=market_cap&sortType=desc&convert=USD&cryptoType=all&tagType=all&audited=false";
		String coinstr 	= coinService.getContent(strUrl);
		
		Coin coin = new Coin();
		JsonFactory factory = new JsonFactory();
		JsonParser  parser  = factory.createParser(coinstr);
		//while (parser.nextToken() != JsonToken.END_OBJECT){...
		while (!parser.isClosed()) {
			JsonToken jsonToken = parser.nextToken();
			
			if (JsonToken.FIELD_NAME.equals(jsonToken)) {
				String fieldName  = parser.getCurrentName();
				jsonToken = parser.nextToken();
				
				
				
			if ("data".equals(fieldName) || "cryptoCurrencyList".equals(fieldName))   {
				continue;
			}
			if ("id".equals(fieldName))   {
				coin.setId(parser.getValueAsInt());
			}
			if ("slug".equals(fieldName))   {
				coin.setName(parser.getValueAsString());
			}
			if ("price".equals(fieldName)){
				coin.setPrice(parser.getValueAsDouble());
			}
			if ("symbol".equals(fieldName))   {
				coin.setSymbol(parser.getValueAsString());
			}
			if ("cmcRank".equals(fieldName))   {
				coin.setCmcRank(parser.getValueAsInt());
			}
			if ("marketPairCount".equals(fieldName))   {
				coin.setMarketPairCount(parser.getValueAsInt());
			}
			if ("circulatingSupply".equals(fieldName))   {
				coin.setCirculatingSupply(parser.getValueAsDouble());
			}
			if ("selfReportedCirculatingSupply".equals(fieldName))   {
				coin.setSelfReportedCirculatingSupply(parser.getValueAsDouble());
			}
			if ("totalSupply".equals(fieldName))   {
				coin.setTotalSupply(parser.getValueAsDouble());
			}
			if ("maxSupply".equals(fieldName))   {
				coin.setMaxSupply(parser.getValueAsDouble());
			}
			if ("isActive".equals(fieldName))   {
				coin.setIsActive(parser.getValueAsInt());
			}
			if ("lastUpdated".equals(fieldName))   {
				coin.setLastUpdated(parser.getValueAsString());
			}
			if ("dateAdded".equals(fieldName))   {
				coin.setDateAdded(parser.getValueAsString());
			}
			if ("name".equals(fieldName))   {
				coin.setQuotesName("USD");
			}
			if ("volume24h".equals(fieldName))   {
				coin.setVolume24h(parser.getValueAsDouble());
			}
			if ("marketCap".equals(fieldName))   {
				coin.setMarketCap(parser.getValueAsDouble());
			}
			if ("percentChange1h".equals(fieldName))   {
				coin.setPercentChange1h(parser.getValueAsDouble());
			}
			if ("percentChange24h".equals(fieldName))   {
				coin.setPercentChange24h(parser.getValueAsDouble());
			}
			if ("percentChange7d".equals(fieldName))   {
				coin.setPercentChange7d(parser.getValueAsDouble());
			}
			if ("percentChange30d".equals(fieldName))   {
				coin.setPercentChange30d(parser.getValueAsDouble());
			}
			if ("percentChange60d".equals(fieldName))   {
				coin.setPercentChange60d(parser.getValueAsDouble());
			}
			if ("percentChange90d".equals(fieldName))   {
				coin.setPercentChange90d(parser.getValueAsDouble());
			}
			if ("fullyDilluttedMarketCap".equals(fieldName))   {
				coin.setFullyDilluttedMarketCap(parser.getValueAsDouble());
			}
			if ("marketCapByTotalSupply".equals(fieldName))   {
				coin.setMarketCapByTotalSupply(parser.getValueAsDouble());
			}
			if ("ytdPriceChangePercentage".equals(fieldName))   {
				coin.setYtdPriceChangePercentage(parser.getValueAsDouble());
			}
			if ("dominance".equals(fieldName))   {
				coin.setDominance(parser.getValueAsDouble());
			}
			if ("turnover".equals(fieldName))   {
				coin.setTurnover(parser.getValueAsDouble());
			}
			if ("isAudited".equals(fieldName))   {
				coin.setAudited(parser.getValueAsBoolean());
			}
			coinService.save(coin);
			}
		}
	}

	@Autowired
	public void setCoinService(CoinService coinService) {
		this.coinService = coinService;
	}
	
}

