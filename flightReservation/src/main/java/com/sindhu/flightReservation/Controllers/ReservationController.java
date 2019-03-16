package com.sindhu.flightReservation.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sindhu.flightReservation.Repos.FlightRepository;
import com.sindhu.flightReservation.Services.ReservationService;
import com.sindhu.flightReservation.dto.ReservationRequest;
import com.sindhu.flightReservation.entities.Flight;
import com.sindhu.flightReservation.entities.Reservation;
@Controller
public class ReservationController {
	
	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	ReservationService reservationService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationController.class);
	
	@RequestMapping("/showCompleteReservation")
	private String showCompleteReservation(@RequestParam("flightId") Long flightId, ModelMap modelMap) {
		LOGGER.info("Inside showCompleteReservation() with flightId: "+flightId);
		
		Flight flight = flightRepository.findById(flightId).get();
		LOGGER.info("Inside showCompleteReservation() and flight is: "+flight);
		modelMap.addAttribute("flight", flight);
		return "completeReservation";
	}
	
	@RequestMapping(value="/completeReservation", method=RequestMethod.POST)
	private String completeReservation(ReservationRequest reservationRequest, ModelMap modelMap) {
		
		LOGGER.info("Inside completeReservation() with Reservation Request: "+reservationRequest);
		Reservation reservation = reservationService.bookFlight(reservationRequest);
		modelMap.addAttribute("msg", "Reservation created Successfully and the Id is: " + reservation.getId() );
		return "reservationConfirmation";
	}
	
}
