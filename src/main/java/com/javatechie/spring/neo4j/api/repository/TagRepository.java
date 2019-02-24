package com.javatechie.spring.neo4j.api.repository;

import com.javatechie.spring.neo4j.api.node.Tag;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface TagRepository extends Neo4jRepository<Tag, String> {
	Tag findByName(String name);
}


