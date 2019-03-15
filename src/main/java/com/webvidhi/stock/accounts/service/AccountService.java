package com.webvidhi.stock.accounts.service;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.webvidhi.stock.accounts.model.Account;

@Service
public class AccountService {
	

	private RestHighLevelClient client;
	
	private ObjectMapper objectMapper;
	

	@Autowired
	public AccountService(RestHighLevelClient client, ObjectMapper objectMapper) {
		super();
		this.client = client;
		this.objectMapper = objectMapper;
	}
	
	public String createAccount(Account account) throws IOException {
		/*
		 * RestHighLevelClient client = new RestHighLevelClient( RestClient.builder( new
		 * HttpHost("35.200.206.250", 9200, "http") ));
		 */
		
		
		UUID uuid = UUID.randomUUID();
		
		account.setUserId(uuid.toString());
		System.out.println("ID: "+account.getUserId());
		IndexRequest indexReq = new IndexRequest("stock","account",account.getUserId()).source(convAccountoMap(account));
		IndexResponse indexResponse = client.index(indexReq, RequestOptions.DEFAULT);
        return indexResponse.getResult().name();
		
		
	}
	
	private Map<String,Object> convAccountoMap(Account account){
		return objectMapper.convertValue(account, Map.class);
	}

}
