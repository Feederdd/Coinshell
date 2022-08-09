package com.Group1.CoinShell.service.Feeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Group1.CoinShell.model.Feeder.SetPriceL;
import com.Group1.CoinShell.model.Feeder.SetPriceLDao;

@Service
@Transactional
public class SetPriceLService {
	@Autowired
	private SetPriceLDao setPriceLao;
	
	public void save(SetPriceL setPrice) {
		setPriceLao.save(setPrice);
	}
	
	public int deletegetSetCoin(Integer memId, Integer coinId) {
		return setPriceLao.deletegetSetCoin(memId,coinId);
    }
} 
