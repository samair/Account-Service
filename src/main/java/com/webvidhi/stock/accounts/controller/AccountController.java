package com.webvidhi.stock.accounts.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webvidhi.stock.accounts.model.Account;
import com.webvidhi.stock.accounts.service.AccountService;

@RestController
public class AccountController {

  @Autowired
  private AccountService service;
  
  @PostMapping("/create/")
  public String createAccount(@RequestBody Account account) throws IOException {
	  
	  
	  return service.createAccount(account);
  }

}
