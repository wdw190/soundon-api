package com.soundon.group.rs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
//开启资源服务器的功能
@EnableResourceServer
public class SoundonRsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoundonRsApplication.class, args);
	}
}
