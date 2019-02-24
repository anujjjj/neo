package com.javatechie.spring.neo4j.api.repository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.annotation.QueryResult;

@AllArgsConstructor
@NoArgsConstructor

@QueryResult
public class ResponseRecommendations {
    private String name;
    private String id;
    private String message;
    private double count;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public double getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
