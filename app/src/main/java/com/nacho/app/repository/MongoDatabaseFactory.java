package com.nacho.app.repository;

import com.mongodb.reactivestreams.client.MongoDatabase;
import org.springframework.dao.DataAccessException;

public interface MongoDatabaseFactory {
    MongoDatabase getDatabase() throws DataAccessException;

    MongoDatabase getDatabase(String dbName) throws DataAccessException;
}
