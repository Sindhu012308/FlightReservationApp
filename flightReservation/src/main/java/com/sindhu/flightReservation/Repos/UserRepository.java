package com.sindhu.flightReservation.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sindhu.flightReservation.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
}
