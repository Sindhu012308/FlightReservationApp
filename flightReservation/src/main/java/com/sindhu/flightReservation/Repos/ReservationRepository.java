package com.sindhu.flightReservation.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sindhu.flightReservation.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
