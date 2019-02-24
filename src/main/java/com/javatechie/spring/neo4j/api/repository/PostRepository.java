package com.javatechie.spring.neo4j.api.repository;

import com.javatechie.spring.neo4j.api.node.Post;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface PostRepository extends Neo4jRepository<Post, String> {
}


