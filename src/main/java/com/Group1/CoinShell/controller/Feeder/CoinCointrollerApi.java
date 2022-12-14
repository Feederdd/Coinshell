package com.Group1.CoinShell.controller.Feeder;


import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.Group1.CoinShell.model.Feeder.Coin;
import com.Group1.CoinShell.model.Feeder.CoinDao;
import com.Group1.CoinShell.model.Feeder.SetPriceH;
import com.Group1.CoinShell.model.Feeder.SetPriceL;
import com.Group1.CoinShell.model.Feeder.StarDTO;
import com.Group1.CoinShell.model.Feeder.Watch;
import com.Group1.CoinShell.model.Yiwen.Members;
import com.Group1.CoinShell.service.Feeder.CoinService;
import com.Group1.CoinShell.service.Feeder.SetPriceHService;
import com.Group1.CoinShell.service.Feeder.SetPriceLService;
import com.Group1.CoinShell.service.Feeder.WatchService;
import com.Group1.CoinShell.service.Hoxton.EmailSenderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component // ??? SpringbootdemoApplication ??????@EnableScheduling ????????????@Scheduled ????????????????????????
@RestController
public class CoinCointrollerApi {

	private static Logger log = LogManager.getLogger(CoinCointrollerApi.class);
	private static final String Requestmethod = null;
	@Autowired
	private CoinService coinService;
	@Autowired
	private CoinDao coinDao;
	@Autowired
	private WatchService watchService;
	@Autowired
	private EmailSenderService senderService;
	@Autowired
	private SetPriceHService setPriceHService;
	@Autowired
	private SetPriceLService setPriceLService;
	                                                    // ?????????@Component
	@Scheduled(initialDelay = 2000, fixedRate = 60000)  // ????????? ???????????? initialDelay ?????? ????????? ??? fixedRate ?????? RUN??????
	@PostMapping("coin/insert")
	public void updateCoin() throws JsonProcessingException {
		// ??????????????????????????? ??????????????????
		log.info("START = " + LocalDateTime.now());
		
		// ???????????????????????????JAVA???????????? ????????????????????????JSON?????? ???????????????JSON??????
		String strUrl    = "https://api.coinmarketcap.com/data-api/v3/cryptocurrency/listing?start=1&limit=100&sortBy=market_cap&sortType=desc&convert=USD&cryptoType=all&tagType=all&audited=false";
		String coinstr   = coinService.getContent(strUrl);

		ObjectMapper objMaper = new ObjectMapper();
		JsonNode node = objMaper.readTree(coinstr);
		JsonNode arrNode = node.get("data").get("cryptoCurrencyList");
		
		Coin coin = new Coin();
		
		for (JsonNode currency:arrNode) {
			
			Integer coinId            = currency.get("id").asInt();
			Integer cmcRank           = currency.get("cmcRank").asInt();
			Integer marketPairCount   = currency.get("marketPairCount").asInt();
			Integer isActive          = currency.get("isActive").asInt();
			String  name    		  = currency.get("name").asText();
			String  symbol            = currency.get("symbol").asText();
			String  slug              = currency.get("slug").asText();
			String  lastUpdated       = currency.get("lastUpdated").asText();
			String  dateAdded         = currency.get("dateAdded").asText();
			String  quotesName        = currency.get("quotes").get(0).get("name").asText();
			Double  circulatingSupply = currency.get("circulatingSupply").asDouble();
			Double  selfRCSupply      = currency.get("selfReportedCirculatingSupply").asDouble();
			Double  totalSupply       = currency.get("totalSupply").asDouble();
			Double  price             = currency.get("quotes").get(0).get("price").asDouble();
			Double  volume24h         = currency.get("quotes").get(0).get("volume24h").asDouble();
			Double  marketCap         = currency.get("quotes").get(0).get("marketCap").asDouble();
			Double  percentChange1h   = currency.get("quotes").get(0).get("percentChange1h").asDouble();
			Double  percentChange24h  = currency.get("quotes").get(0).get("percentChange24h").asDouble();
			Double  percentChange7d   = currency.get("quotes").get(0).get("percentChange7d").asDouble();
			Double  percentChange30d  = currency.get("quotes").get(0).get("percentChange30d").asDouble();
			Double  percentChange60d  = currency.get("quotes").get(0).get("percentChange60d").asDouble();
			Double  percentChange90d  = currency.get("quotes").get(0).get("percentChange90d").asDouble();
			Double  dominance   	  = currency.get("quotes").get(0).get("dominance").asDouble();
			Double  turnover   		  = currency.get("quotes").get(0).get("turnover").asDouble();
			Double  fullyDilluttedMarketCap  = currency.get("quotes").get(0).get("fullyDilluttedMarketCap").asDouble();
			Double  marketCapByTotalSupply   = currency.get("quotes").get(0).get("marketCapByTotalSupply").asDouble();
			Double  ytdPriceChangePercentage = currency.get("quotes").get(0).get("ytdPriceChangePercentage").asDouble();
			boolean isAudited   = currency.get("isAudited").asBoolean();
			
	        try {
	        	coin.setMaxSupply(currency.get("maxSupply").asDouble());
	        } catch (Exception e) {
	        	coin.setMaxSupply(0.0);
	        }
	        
			coin.setId(coinId); 
			coin.setName(name);
			coin.setSymbol(symbol);
			coin.setSlug(slug);
			coin.setCmcRank(cmcRank);
			coin.setMarketPairCount(marketPairCount);
			coin.setCirculatingSupply(circulatingSupply);
			coin.setSelfReportedCirculatingSupply(selfRCSupply);
			coin.setTotalSupply(totalSupply);
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

	//??????????????????????????? ??? ???????????? ??????/coin/getAll (?????????JSP AJAX???????????? ????????????????????????????????????????????????)
	//@Scheduled(initialDelay = 3000, fixedRate = 20000)
	@GetMapping("coin/getAll")
	public List<Coin> findAllcoin() {
		List<Coin> allCoinList = coinService.findAll();
		return allCoinList;
	}
	//http://localhost:8080/coinshell/coin/getAll
	
	@GetMapping("coin/getCoin")
	public List<Map<String, Object>> getCoin(HttpSession session) {
		
		Members member =(Members) session.getAttribute("login");
		
		List<Map<String, Object>> result;

		if(member != null) {
		Integer memId = member.getId();
		    result = coinService.getCoin(memId);
		} else {
		    result = coinService.getCoin();
		}

		return result; 
	}
	
	@PostMapping("coin/getSetCoin")
	public Map<String, String> insertSetCoin(@RequestBody StarDTO dto,HttpSession session) {
		
		Members member =(Members) session.getAttribute("login");
		String memEMail = member.geteMail();
		
		Integer memId = dto.getMemId();
		Integer coinId =dto.getCoinId();
		Float   price =dto.getSetPrice(); 
		String  type =dto.getType();
		
		log.info("????????????: " + "MemId:" + memId + " ,CoinId:" + coinId + " ,setPrice:" + price + " ,type:" + type);
//		System.out.println("MemId:   " + memId); //??????log4j
//    	System.out.println("CoinId:   " + coinId);
//    	System.out.println("setPrice:   " + price);
//    	System.out.println("type:   " + type);
    	
    	String coinNAME = coinService.findByCoinId2(coinId).getName();  //?????????????????????COINID?????????NAME ???mail???
    	
    	if("H".equals(type)) { 			//???????????? ??????nullpointerExcetion ?????????????????????("H")???????????????????????????(type)??????
    		SetPriceH setPriceH =new SetPriceH();
    		
        	setPriceH.setMemberId(memId);
        	setPriceH.setCoinId(coinId);
        	setPriceH.setSetPriceH(price);
        	setPriceHService.save(setPriceH);
        	
        	List<Map<String, Object>> heigher = coinService.getHeighSetCoin(memId);
        	
		if(heigher.size()!=0) {
			senderService.sendEmail(memEMail, "??????????????????" + coinNAME + "????????????", "?????????????????? "+ coinNAME + " ???????????? USD: " + price + " ,?????????????????????????????????");
			setPriceHService.deletegetSetCoin(memId, coinId);
			}
    	}
    	
    	if("L".equals(type)) {				
    		SetPriceL setPriceL =new SetPriceL();
    		
        	setPriceL.setMemberId(memId);
        	setPriceL.setCoinId(coinId);
        	setPriceL.setSetPriceL(price);
        	setPriceLService.save(setPriceL);
        	
        	List<Map<String, Object>> lower = coinService.getLowerSetCoin(memId);
        	
		if(lower.size()!=0) {
			senderService.sendEmail(memEMail, "??????????????????" + coinNAME + "????????????", "?????????????????? "+ coinNAME + " ???????????? USD: " + price + " ,?????????????????????????????????");
			setPriceLService.deletegetSetCoin(memId, coinId);
			}
    	}
		
		Map<String, String> result = new HashMap<String, String>();
    	result.put("status", "200");
    	return result;
	}
	
	@DeleteMapping("coin/deletegetSetCoin/{id}")
    public Map<String, String> deletegetSetCoin(@RequestBody StarDTO dto) {
		log.info("???????????? :  MemId =  " + dto.getMemId() + " ,CoinId" + dto.getCoinId());
//    	System.out.println("delete :  MemId =  "  + dto.getMemId());
//    	System.out.println("delete :  CoinId =  " + dto.getCoinId());
    	
    	 Integer memId =dto.getMemId();
    	 Integer coinId =dto.getCoinId();
    	
    	 setPriceHService.deletegetSetCoin(memId,coinId);
    	 setPriceLService.deletegetSetCoin(memId,coinId);
    	
    	Map<String, String> result = new HashMap<String, String>();
    	result.put("status", "200");
    	return result;
    }
	
	
	//?????????JSP AJAX???????????? ????????????????????????????????????????????????
	@GetMapping("coin/page/{pageNumber}")
	public List<Coin> findByPage(@PathVariable Integer pageNumber) {
		Pageable pgb = PageRequest.of(pageNumber - 1, 10, Sort.Direction.ASC, "cmcRank");

		Page<Coin> page = coinDao.findAll(pgb);

		List<Coin> list = page.getContent();

		return list;
	}
	//http://localhost:8080/coinshell/coin/page/1
	@GetMapping("coin/getlastest")
	public Coin findLastestCurrencyInformation(@RequestParam("currencyName") String currencyName) {
		Coin lastestCoin=coinService.findLastestCurrencyInformation(currencyName);
		return lastestCoin;
		//http://localhost:8080/coinshell/coin/getlastest?currencyName=btc
		
	}
	
	//????????????NAME??????
	@GetMapping("/watch")
	public List<Coin> watchCoinName(@RequestParam("name") String name) {
		
		List<Coin> coin = coinService.findByName(name);
		
		return coin;
	}
	
    @PostMapping("/insertWatch")
    public Map<String, String> insertWatch(@RequestBody StarDTO dto) {
    	
//    	Members member =(Members) session.getAttribute("login");
//    	Integer memId = member.getMemId();
    	
    	log.info("???????????? :  MemId =  " + dto.getMemId() + " ,CoinId" + dto.getCoinId());
//    	System.out.println("MemId:   " + dto.getMemId());
//    	System.out.println("CoinId:  " + dto.getCoinId());
    	
    	Watch watch = new Watch();
    	watch.setMemberId(dto.getMemId());
    	watch.setCoinId(dto.getCoinId());
    	watchService.save(watch);
    	
    	Map<String, String> result = new HashMap<String, String>();
    	result.put("status", "200");
    	return result;
    }
    @DeleteMapping("/deleteWatch/{id}")
    public Map<String, String> deleteWatch(@RequestBody StarDTO dto) {
    	log.info("???????????? :  MemId =  " + dto.getMemId() + " ,CoinId" + dto.getCoinId());
//    	System.out.println("delete :  MemId  =  " + dto.getMemId());
//    	System.out.println("delete :  CoinId =  " + dto.getCoinId());
    	
    	 Integer memId =dto.getMemId();
    	 Integer coinId =dto.getCoinId();
    	
    	watchService.deleteByCoinId(memId,coinId);
    	
    	Map<String, String> result = new HashMap<String, String>();
    	result.put("status", "200");
    	return result;
    }
	
    //??????name???symbol????????????
    @ResponseBody
    @GetMapping("/coin/select")
    public List<Coin> selectCoinByName(@RequestParam String name) {
    	List<Coin> SelectCoin;
    	
    	SelectCoin = coinService.findByName2(name);
    	
    	return SelectCoin;
    }
    
    
    //???????????? ??????coinId > ???findByCoinId??????> ???????????? >???AJAX???
	@GetMapping("/coin/getId")
	public List<Coin> coinList(@RequestParam Integer coinId) {
		
		List<Coin> coin = coinService.findByCoinId(coinId);
		
		return coin;
	}
    
}
