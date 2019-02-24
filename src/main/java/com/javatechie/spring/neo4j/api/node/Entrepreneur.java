package com.javatechie.spring.neo4j.api.node;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Entrepreneur {

	@Id
	private String id;
	private String name;
	private String author;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public List<Tag> getHaves() {
		return haves;
	}

	public void setHaves(List<Tag> haves) {
		this.haves = haves;
	}

	public List<Entrepreneur> getFollows() {
		return follows;
	}

	public void setFollows(List<Entrepreneur> follows) {
		this.follows = follows;
	}

	@JsonIgnoreProperties("entrepreneur")
	@Relationship(type = "Have", direction = Relationship.OUTGOING)
	private List<Tag> haves;

	@Relationship(type="Follows", direction = Relationship.OUTGOING)
	private List<Entrepreneur> follows;

	@Relationship(type="Posted", direction = Relationship.OUTGOING)
	private List<Post> posts;

}
