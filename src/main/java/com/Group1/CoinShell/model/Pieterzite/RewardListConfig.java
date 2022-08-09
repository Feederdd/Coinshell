package com.Group1.CoinShell.model.Pieterzite;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RewardListConfig {

    @Bean   // 啟動 Spring Boot 時，Hibernate 會執行 insert into SQL 
    CommandLineRunner commandLineRunner(RewardListDao rewDao) {
        return args -> {
        	RewardList one = new RewardList(1,10);
        	RewardList two = new RewardList(2,10);
        	RewardList three = new RewardList(3,20);
        	RewardList four = new RewardList(4,20);
        	RewardList five = new RewardList(5,30);
        	RewardList six = new RewardList(6,40);
        	RewardList seven = new RewardList(7,50);
        	rewDao.saveAll(List.of(one, two, three, four, five, six, seven));
        };
    }
}
