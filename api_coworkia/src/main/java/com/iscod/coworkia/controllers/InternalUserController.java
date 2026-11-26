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

import com.iscod.coworkia.entities.InternalUser;
import com.iscod.coworkia.services.InternalUserService;

@RestController
@RequestMapping("/api/users")
public class InternalUserController {
	@Autowired
	private InternalUserService userService;

	@GetMapping("")
	@ResponseStatus(code = HttpStatus.OK)
	public List<InternalUser> getAll(){
		return userService.getList();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public InternalUser getById(@PathVariable("id") Long id){
		return userService.getById(id);
	}
	
	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Long saveUser(@RequestBody InternalUser internalUser) {
		
		return userService.save(internalUser).getId();
	}
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable("id") Long id) {
		
		userService.getById(id);
		
		userService.delete(id);
	}
}
