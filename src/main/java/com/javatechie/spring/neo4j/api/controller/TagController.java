package com.javatechie.spring.neo4j.api.controller;

import com.javatechie.spring.neo4j.api.node.Tag;
import com.javatechie.spring.neo4j.api.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TagController {

	@Autowired
	private TagRepository repository;

	@PostMapping("/addTag")
	public String addTag(@RequestBody Tag tag) {
		repository.save(tag);
		return "Tag Added";
	}

	@GetMapping("/getTags")
	public List<Tag> getTags() {
		return (List<Tag>) repository.findAll();
	}

	@GetMapping("/getTag/{name}")
	public Tag getTag(@PathVariable String name) {
		return repository.findByName(name);
	}

	@DeleteMapping("/deleteTag/{id}")
	public String deleteTag(@PathVariable String id) {
		repository.deleteById(id);
		return "Tag deleted with id : " + id;
	}

}
