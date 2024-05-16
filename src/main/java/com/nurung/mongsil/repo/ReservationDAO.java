package com.nurung.mongsil.repo;

import com.nurung.mongsil.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationDAO extends JpaRepository<Reservation,String> {
}
