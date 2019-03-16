package com.sindhu.flightCheckIn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sindhu.flightCheckIn.Integration.ReservationRestClient;
import com.sindhu.flightCheckIn.dto.Reservation;
import com.sindhu.flightCheckIn.dto.ReservationUpdateRequest;

@Controller
public class CheckInController {
	
	@Autowired
	ReservationRestClient restClient;
	
	@RequestMapping("/showStartCheckIn")
	public String showStartCheckIn() {
		return "startCheckIn";
	}
	
	@RequestMapping(value="/startCheckIn",method=RequestMethod.POST)
	public String startCheckIn(@RequestParam("reservationId") Long reservationId, ModelMap modelMap) {
		Reservation reservation = restClient.findReservation(reservationId);
		modelMap.addAttribute("reservation",reservation);
		return "displayReservationDetails";	
	}
	
	@RequestMapping(value="/completeCheckin", method=RequestMethod.POST)
	public String completeCheckin(@RequestParam("reservationId") Long reservationId,@RequestParam("numberOfBags") int numberOfBags) {
		ReservationUpdateRequest updateRequest = new ReservationUpdateRequest();
		updateRequest.setCheckedIn(true);
		updateRequest.setNumberOfBags(numberOfBags);
		updateRequest.setId(reservationId);
		restClient.updateReservation(updateRequest);
		return "checkInConfirmation";
		
	}

}
