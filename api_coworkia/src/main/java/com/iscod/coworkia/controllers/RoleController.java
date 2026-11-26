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
import com.iscod.coworkia.entities.Role;
import com.iscod.coworkia.services.RoleService;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	@GetMapping("")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Role> getAll(){
		return roleService.getList();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Role getById(@PathVariable("id") Long id){
		return roleService.getById(id);
	}
	
	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Long saveRole(@RequestBody Role role) {
		
		return roleService.save(role).getId();
	}
	
	@DeleteMapping("/{id}")
	public void deleteRole(@PathVariable("id") Long id) {
		
		roleService.getById(id);
		
		roleService.delete(id);
	}
}
