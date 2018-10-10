package com.soundon.group.as;

import java.security.Principal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
//开启资源服务器的功能
@EnableResourceServer
public class SoundonAsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoundonAsApplication.class, args);
	}

	private static final Log logger = LogFactory.getLog(SoundonAsApplication.class);

	@RequestMapping("/user")
	public Principal user(Principal user) {
		logger.info("AS /user has been called");
		logger.debug("user info: " + user.toString());
		return user;
	}
}
