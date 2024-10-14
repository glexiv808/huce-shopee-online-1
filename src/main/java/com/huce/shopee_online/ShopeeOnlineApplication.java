package com.huce.shopee_online;

import com.huce.shopee_online.entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@ComponentScan(basePackages = "com.huce.shopee_online")
//@EnableJpaRepositories(basePackages = "com.huce.shopee_online.repositories")
public class ShopeeOnlineApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopeeOnlineApplication.class, args);
	}

}
