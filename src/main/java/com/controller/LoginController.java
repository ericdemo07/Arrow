package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pojo.LoginData;

@RestController
public class LoginController {
	final static Logger log = LoggerFactory.getLogger(LoginController.class);

	@RequestMapping(value = "/arrow/login", method = RequestMethod.POST)
	public @ResponseBody Object login(@RequestBody LoginData loginData) {
		List<String> brandName = new ArrayList<String>();
		log.info("\tProductImage1Uploaded" + loginData.toString());
		System.out.println(loginData.getPassword() + "  " + loginData.getUserId());
		return brandName.toArray();
	}
}
