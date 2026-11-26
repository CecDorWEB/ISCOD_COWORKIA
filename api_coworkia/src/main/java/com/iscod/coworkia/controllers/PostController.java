package com.iscod.coworkia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.iscod.coworkia.entities.Post;
import com.iscod.coworkia.entities.Zone;
import com.iscod.coworkia.services.PostService;
import com.iscod.coworkia.services.ZoneService;

@RestController
@RequestMapping("/api/posts")
public class PostController {

	@Autowired
	private PostService postService;
	
	@Autowired
	private ZoneService zoneService;
	
	@GetMapping("")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Post> getAll(){
		return postService.getList();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Post getById(@PathVariable("id") Long id){
		return postService.getById(id);
	}
	
	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Long savePost(@RequestBody Post post) {
		
		zoneService.getById(post.getZone().getId());
		
		return postService.save(post).getId();
	}
	
	@DeleteMapping("/{id}")
	public void deletePost(@PathVariable("id") Long id) {
		
		postService.getById(id);
		
		postService.delete(id);
	}
}
