package com.javatechie.spring.neo4j.api.repository;

import com.javatechie.spring.neo4j.api.node.Post;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

public interface PostRepository extends Neo4jRepository<Post, String> {

    @Query("Match (a:Entrepreneur {id:{eid}}) " +
            " Match (p:Post {id : {pid}}) " +
            " Merge (a)-[r:Posted]->(p) " +
            " return p.id "
    )
    String addPostedReln(@Param("eid") String eid,@Param("pid") String pid);
}


