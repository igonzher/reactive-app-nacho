package com.nacho.app.config;


import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.ReactiveMongoClientFactoryBean;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

@Configuration
public class AppConfig {

    public @Bean
    MongoClient mongoClient() {
        return MongoClients.create("mongodb://localhost:27017");
    }

    public @Bean ReactiveMongoTemplate reactiveMongoTemplate() {
        return new ReactiveMongoTemplate(mongoClient(),"PersonService");
    }

    public @Bean ReactiveMongoClientFactoryBean mongo() {
        ReactiveMongoClientFactoryBean mongo = new ReactiveMongoClientFactoryBean();
        mongo.setHost("localhost");
        return mongo;
    }
}
