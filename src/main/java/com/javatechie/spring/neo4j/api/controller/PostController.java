package com.javatechie.spring.neo4j.api.controller;

import com.javatechie.spring.neo4j.api.node.Post;
import com.javatechie.spring.neo4j.api.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

	@Autowired
	private PostRepository repository;

	@PostMapping("/addpost")
	public String addPost(@RequestBody Post Post) {
		repository.save(Post);
		return "Post Added";
	}

	@GetMapping("/getposts")
	public List<Post> getPosts() {
		return (List<Post>) repository.findAll();
	}

//	@GetMapping("/getpost/{name}")
//	public Post getPost(@PathVariable String name) {
//		return repository.findByName(name);
//	}

	@DeleteMapping("/deletepost/{id}")
	public String deletePost(@PathVariable String id) {
		repository.deleteById(id);
		return "Post deleted with id : " + id;
	}

}
