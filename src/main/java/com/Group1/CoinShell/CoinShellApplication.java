package com.Group1.CoinShell;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class CoinShellApplication {
	
 
	public static void main(String[] args) {
		SpringApplication.run(CoinShellApplication.class, args);

		Logger log = LogManager.getLogger(CoinShellApplication.class);
        log.debug("Here is DEBUG");
        log.info("Here is INFO");
        log.warn("Here is WARN");
        log.error("Here is ERROR");
        log.fatal("Here is FATAL");
	}
	

}
