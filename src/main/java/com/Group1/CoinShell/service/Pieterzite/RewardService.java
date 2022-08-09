package com.Group1.CoinShell.service.Pieterzite;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Group1.CoinShell.model.Pieterzite.RewardList;
import com.Group1.CoinShell.model.Pieterzite.RewardListDao;

@Service
@Transactional
public class RewardService {

	@Autowired
	private RewardListDao rewardListDao;
	
	// 找到days 取得對應獎勵
	public Integer getReward(Integer days) {
		Optional<RewardList> option = rewardListDao.findById(days);
		if (option.isPresent()) {
			return option.get().getReward();
		}
		return 0;
	}
}
