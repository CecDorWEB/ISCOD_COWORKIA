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
import com.iscod.coworkia.entities.Reservation;
import com.iscod.coworkia.services.ReservationService;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

	@Autowired
	private ReservationService reservationService;
	
	@GetMapping("")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Reservation> getAll(){
		return reservationService.getList();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Reservation getById(@PathVariable("id") Long id){
		return reservationService.getById(id);
	}
	
	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Long saveReservation(@RequestBody Reservation reservation) {
		
		//Ajouter vérification salle déjà réservée sur la période
		
		return reservationService.save(reservation).getId();
	}
	
	@DeleteMapping("/{id}")
	public void deleteReservation(@PathVariable("id") Long id) {
		
		reservationService.getById(id);
		
		reservationService.delete(id);
	}
}
