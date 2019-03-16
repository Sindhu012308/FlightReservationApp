package com.sindhu.flightReservation.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sindhu.flightReservation.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
