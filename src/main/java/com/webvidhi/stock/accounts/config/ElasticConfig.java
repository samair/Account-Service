package com.webvidhi.stock.accounts.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticConfig {
	
	@Value("${elastic.host}")
	private String elasticSearchHost;
	
	
	@Bean(destroyMethod = "close")
    public RestHighLevelClient client() {

        return new RestHighLevelClient(
                RestClient.builder(new HttpHost(elasticSearchHost,9200, "http")));

    }

}
