package com.soundon.group.rs.service;

import java.security.Principal;
import java.util.Collections;
import java.util.Map;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
//开启方法级别的保护
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class DemoService {

	private String message = "Hello Soundon!";

	//在进入方法前进行权限认证
	@PreAuthorize("#oauth2.hasScope('resource-server-read')")
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Map<String, String> home() {
		return Collections.singletonMap("message", message);
	}

	@PreAuthorize("#oauth2.hasScope('resource-server-write')")
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public void updateMessage(@RequestBody String message) {
		this.message = message;
	}

	@PreAuthorize("#oauth2.hasScope('resource-server-read')")
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public Map<String, String> user(Principal user) {
		return Collections.singletonMap("message", "user is: " + user.toString());
	}

}
