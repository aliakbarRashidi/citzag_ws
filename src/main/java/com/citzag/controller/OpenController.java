package com.citzag.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.citzag.daos.CzUsers;
import com.citzag.utils.JSONizer;

/**
 * @author Jonas Canyellas, jonas.canyellas@gmail.com 
 * Copyright 2015, all rights reserved, this code can not be redistributed. 
 *
 */

@RequestMapping("/users")
@Controller
public class OpenController   {
	
	
	@RequestMapping(value = "/fetch", method = RequestMethod.GET,produces = "application/json; charset=utf-8")    
	@ResponseBody
	  public ResponseEntity<String> fetch(HttpServletRequest  request) {        
        HttpHeaders headers = new HttpHeaders();        
        List<CzUsers> users = CzUsers.findAllCzUserses();
        return new ResponseEntity<String>(JSONizer.toJson(users), headers, HttpStatus.OK);
	}

	
}
