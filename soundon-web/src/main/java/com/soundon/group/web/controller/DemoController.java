package com.soundon.group.web.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@Autowired
	private OAuth2RestTemplate resourceServerProxy;

	@RequestMapping(value = "/api/message", method = RequestMethod.GET)
	public Map<String, String> getMessage() {
		return resourceServerProxy.getForObject("http://localhost:9090", Map.class);
	}

	@RequestMapping(value = "/api/message", method = RequestMethod.POST)
	public void saveMessage(@RequestBody String newMessage) {
		resourceServerProxy.postForLocation("http://localhost:9090", newMessage);
	}

}
