package com.sindhu.flightReservation.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sindhu.flightReservation.Repos.ReservationRepository;
import com.sindhu.flightReservation.dto.ReservationUpdateRequest;
import com.sindhu.flightReservation.entities.Reservation;

@RestController
public class ReservationRestController {
	
	@Autowired
	ReservationRepository reservationRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationRestController.class);
	
	@RequestMapping("/reservations/{id}")
	public Reservation findReservation(@PathVariable("id") Long id) {
		LOGGER.info("Inside findReservation() with Id: "+id);
		Reservation reservation = reservationRepository.findById(id).get();
		return reservation;
	}
	
	@RequestMapping("/reservations")
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest updateRequest) {
		LOGGER.info("Inside updateReservation() for "+updateRequest);
		  Reservation reservation = reservationRepository.findById(updateRequest.getId()).get();
		  reservation.setCheckedIn(updateRequest.getCheckedIn());
		  reservation.setNumberOfBags(updateRequest.getNumberOfBags());
		  LOGGER.info("Saving the Reservation");
		  Reservation updatedReservation = reservationRepository.save(reservation);
		return updatedReservation;
		
	}
}
