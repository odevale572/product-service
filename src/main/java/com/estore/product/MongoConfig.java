package com.estore.product;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
public class MongoConfig {

	@Value("${spring.data.mongodb.uri}")
	private String uri;
	
	@Bean
	public MongoTemplate mongoTemplate() {
		return new MongoTemplate(getMongoDbFactory());
	}

	private MongoDatabaseFactory getMongoDbFactory() {
		return new SimpleMongoClientDatabaseFactory(MongoClients.create(uri), "estore");
	}
	
}
