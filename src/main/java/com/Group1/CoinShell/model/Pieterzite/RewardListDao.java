package com.Group1.CoinShell.model.Pieterzite;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RewardListDao extends JpaRepository<RewardList, Integer> {
	
}
