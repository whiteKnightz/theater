package com.whiteKnightz.theater.repositories

import com.whiteKnightz.theater.domain.Seat
import org.springframework.data.jpa.repository.JpaRepository

interface SeatRepository: JpaRepository<Seat, Long>