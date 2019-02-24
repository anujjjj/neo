package com.javatechie.spring.neo4j.api.repository;

import com.javatechie.spring.neo4j.api.node.Entrepreneur;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface EntrepreneurRepository extends Neo4jRepository<Entrepreneur, String> {
	Entrepreneur findByName(String name);
	Entrepreneur findByid(String id);

//	@Query("MATCH (m:Entrepreneur) RETURN m ")
	@Query("MATCH (a:En {name: {id}})-[:connect]-(:En) " +
			"-[:connect]-(b:En) " +
			"WHERE NOT (a)-[:connect]-(b) AND a <> b "+
			"RETURN DISTINCT b.name as name,count(b) as count "+
			" ORDER BY count DESC " +
			" LIMIT 5 ")
	List<ResponseRecommendations> mutualFriends(@Param("id") String id);

	@Query("MATCH (a:En {name: 'anuj'})-[:partof]-(:grp) " +
			"-[:partof]-(b:En) " +
			"WHERE NOT (a)-[:connect]-(b) AND a <> b "+
			"RETURN DISTINCT b.name as name,count(b) as count "+
			" ORDER BY count DESC " +
			" LIMIT 5 ")
	List<ResponseRecommendations> mutualGroups(@Param("id") String id);


	@Query("MATCH (p:En) " +
			" OPTIONAL MATCH (p:En{name:{id}})-[likes:have]->(c) " +
			" WITH {item:p.name, weights: collect(Id(c))} as dt1 " +
			" with distinct dt1 as dt1 " +
			" where dt1.item='anuj'" +
			" with dt1.weights as dt1 " +
			" MATCH (p1:En) " +
			" where not (p1)-[:connect]-(:En{name:{id}}) and p1.name<>{id} " +
			" optional match (p1:En)-[likes1:have]->(c1:Tag) " +
			" with dt1 as dt1,{item:p1.name, weights: collect(Id(c1))} as dt2 " +
			" with collect( dt2) as dt2,dt1 as dt1 " +
			" unwind dt2 as i" +
			" optional match (a:En{name:{id}}),(b:En{name : i.item}) " +
			" merge (a)-[r:similar]-(b) " +
			" set r.value=algo.similarity.jaccard(dt1,i.weights) " +
			" return b.name as name,r.value as count " +
			" order by r.value descending " +
			" limit 5")
	List<ResponseRecommendations> mutualHaves(@Param("id") String id);

	@Query("Match (u1:En {name : 'anuj'}) " +
			"Match (u2:En {name : 'sagar'} ) "   +
			"Merge (u1)-[r:Follows]-(u2) " +
			"return u2.name ")
	String addFollower();
}
