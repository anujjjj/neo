package com.javatechie.spring.neo4j.api.node;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

@RelationshipEntity(type = "Posted")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Posted {

	@Id
	private String id;
	private String name;
	@StartNode
	private Entrepreneur sn;
	@EndNode
	private Post en2;
}
