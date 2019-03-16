package com.sindhu.flightReservation.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sindhu.flightReservation.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
