package com.Group1.CoinShell.service.Feeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Group1.CoinShell.model.Feeder.SetPriceH;
import com.Group1.CoinShell.model.Feeder.SetPriceHDao;

@Service
@Transactional
public class SetPriceHService {
	@Autowired
	private SetPriceHDao setPriceHDao;
	
	public void save(SetPriceH setPrice) {
		setPriceHDao.save(setPrice);
	}
	
	public int deletegetSetCoin(Integer memId, Integer coinId) {
		return setPriceHDao.deletegetSetCoin(memId,coinId);
    }
} 
