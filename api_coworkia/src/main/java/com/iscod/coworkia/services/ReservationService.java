package com.iscod.coworkia.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.iscod.coworkia.entities.Reservation;

@Service
public class ReservationService extends BaseService<Reservation, Long> {

	protected ReservationService(JpaRepository<Reservation, Long> repository) {
		super(repository);
	}

}
