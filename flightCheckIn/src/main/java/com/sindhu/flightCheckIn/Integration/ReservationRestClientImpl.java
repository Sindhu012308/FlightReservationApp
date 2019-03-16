package com.sindhu.flightCheckIn.Integration;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.sindhu.flightCheckIn.dto.Reservation;
import com.sindhu.flightCheckIn.dto.ReservationUpdateRequest;

@Component
public class ReservationRestClientImpl implements ReservationRestClient {

	private static final String Reservation_Rest_URL = "http://localhost:8080/flightReservation/reservations/";

	@Override
	public Reservation findReservation(Long id) {
		RestTemplate restTemplate = new RestTemplate();
		Reservation reservation = restTemplate.getForObject(Reservation_Rest_URL+id, Reservation.class);
		return reservation;
	}

	@Override
	public Reservation updateReservation(ReservationUpdateRequest request) {
		RestTemplate restTemplate = new RestTemplate();
		Reservation updatedReservation = restTemplate.postForObject(Reservation_Rest_URL, request, Reservation.class);
		return updatedReservation;
	}

}
