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

import com.iscod.coworkia.entities.Site;
import com.iscod.coworkia.services.SiteService;

@RestController
@RequestMapping("/api/sites")
public class SiteController {

	@Autowired
	private SiteService siteService;
	
	@GetMapping("")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Site> getAll(){
		return siteService.getList();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Site getById(@PathVariable("id") Long id){
		return siteService.getById(id);
	}
	
	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Long saveSite(@RequestBody Site site) {
		return siteService.save(site).getId();
	}
	
	@DeleteMapping("/{id}")
	public void deleteSite(@PathVariable("id") Long id) {
		
		siteService.getById(id);
		
		siteService.delete(id);
	}
	
}
