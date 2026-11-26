package com.iscod.coworkia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;

import com.iscod.coworkia.entities.Zone;
import com.iscod.coworkia.services.SiteService;
import com.iscod.coworkia.services.ZoneService;

@RestController
@RequestMapping("/api/zones")
public class ZoneController {
	@Autowired
	private ZoneService zoneService;
	
	@Autowired
	private SiteService siteService;
	
	@GetMapping("")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Zone> getAll(){
		return zoneService.getList();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Zone getById(@PathVariable("id") Long id){
		return zoneService.getById(id);
	}
	
	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Long saveZone(@RequestBody Zone zone) {
		
		siteService.getById(zone.getSite().getId());
		
		return zoneService.save(zone).getId();
	}
	
	@DeleteMapping("/{id}")
	public void deleteZone(@PathVariable("id") Long id) {
		
		zoneService.getById(id);
		
		zoneService.delete(id);
	}

}
