package com.Group1.CoinShell.model.Yiwen;

import java.util.Date;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MembersConfig {

    @Bean   // 啟動 Spring Boot 時，Hibernate 會執行 insert into SQL 
    CommandLineRunner commandLineRunnerAdmin(MembersDao memDao) {
        return args -> {
        	Members admin1 = new Members();
    		Date date = new Date();
        	admin1.setId(1);
        	admin1.setMyShell(1000);
        	admin1.setCoin(1000);
        	admin1.seteMail("youdo108@gmail.com");
        	admin1.setJoinTime(date);
        	admin1.setPassword("a1234567");
        	admin1.setCustomizedUserName("admin_Pieterzite");
        	admin1.setCustomizedUserAvatar(5);
        	Members admin2 = new Members();
        	admin2.setId(2);
        	admin2.setMyShell(1000);
        	admin2.setCoin(1000);
        	admin2.seteMail("za546321@gmail.com");
        	admin2.setJoinTime(date);
        	admin2.setPassword("a1234567");
        	admin2.setCustomizedUserName("admin_Hoxton");
        	admin2.setCustomizedUserAvatar(5);
        	Members admin3 = new Members();
        	admin3.setId(3);
        	admin3.setMyShell(1000);
        	admin3.setCoin(1000);
        	admin3.seteMail("nbhd0320@gmail.com");
        	admin3.setJoinTime(date);
        	admin3.setPassword("a1234567");
        	admin3.setCustomizedUserName("admin_Feeder");
        	admin3.setCustomizedUserAvatar(5);
        	Members admin4 = new Members();
        	admin4.setId(4);
        	admin4.setMyShell(1000);
        	admin4.setCoin(1000);
        	admin4.seteMail("habufly@gmail.com");
        	admin4.setJoinTime(date);
        	admin4.setPassword("a1234567");
        	admin4.setCustomizedUserName("admin_Bear");
        	admin4.setCustomizedUserAvatar(5);
        	Members admin5 = new Members();
        	admin5.setId(5);
        	admin5.setMyShell(1000);
        	admin5.setCoin(1000);
        	admin5.seteMail("yiwenhaha@gmail.com");
        	admin5.setJoinTime(date);
        	admin5.setPassword("a1234567");
        	admin5.setCustomizedUserName("admin_Yiwen");
        	admin5.setCustomizedUserAvatar(5);
        	memDao.saveAll(List.of(admin1, admin2, admin3, admin4, admin5));
        };
    }
}