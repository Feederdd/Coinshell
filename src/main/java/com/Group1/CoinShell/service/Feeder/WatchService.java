package com.Group1.CoinShell.service.Feeder;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Group1.CoinShell.model.Feeder.Coin;
import com.Group1.CoinShell.model.Feeder.Watch;
import com.Group1.CoinShell.model.Feeder.WatchDao;

@Service
@Transactional
public class WatchService {
	
	@Autowired
	private WatchDao watchDao;
	
	public void save(Watch watch) {
		watchDao.save(watch);
	}
	public List<Coin> findByCoinName(String name) {
		return watchDao.findByName(name);
    }
	
	public int deleteByCoinId(Integer memId, Integer coinId) {
		return watchDao.deleteByCoinId(memId,coinId);
    }
	
	//單一參數用這個
//	public Long deleteByCoinId2(Integer coinId) {
//		return watchDao.deleteByCoinId(coinId);
//	}
	
	public List<Watch> findByMemberId(Integer memberId) {
		return watchDao.findByMemberId(memberId);
	}
}
