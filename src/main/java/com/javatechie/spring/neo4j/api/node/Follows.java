package com.javatechie.spring.neo4j.api.node;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

@RelationshipEntity(type = "Follows")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Follows {

	@Id
	private String id;
	private String name;
	@StartNode
	private Entrepreneur en1;

	@EndNode
	private Entrepreneur en2;
}
