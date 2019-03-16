package com.sindhu.flightCheckIn.Integration;

import com.sindhu.flightCheckIn.dto.Reservation;
import com.sindhu.flightCheckIn.dto.ReservationUpdateRequest;

public interface ReservationRestClient {

	public Reservation findReservation(Long id );
	
	public Reservation updateReservation(ReservationUpdateRequest request);
}
