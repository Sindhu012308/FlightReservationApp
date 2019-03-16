package com.sindhu.flightReservation.Services;

import com.sindhu.flightReservation.dto.ReservationRequest;
import com.sindhu.flightReservation.entities.Reservation;

public interface ReservationService {
	public Reservation bookFlight(ReservationRequest reservationRequest);
	
}
