package com.nacho.app.config;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

import static java.util.Collections.singletonList;

public class ApplicationContextEventAppConfig extends AbstractMongoClientConfiguration {
    @Override
    protected String getDatabaseName() {
        return "PersonService";
    }

    @Override
    protected void configureClientSettings(MongoClientSettings.Builder builder) {

        builder
                .credential(MongoCredential.createCredential("root", "PersonService", "pwd".toCharArray()))
                .applyToClusterSettings(settings  -> {
                    settings.hosts(singletonList(new ServerAddress("127.0.0.1", 27017)));
                });
    }



}
