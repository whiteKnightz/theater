package com.whiteKnightz.theater.services

import com.whiteKnightz.theater.domain.Seat
import org.springframework.stereotype.Service

@Service
class BookingService {
    fun isSeatFree(seat: Seat?): Boolean{
        return true
    }
}