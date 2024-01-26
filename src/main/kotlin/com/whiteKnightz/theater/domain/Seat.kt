package com.whiteKnightz.theater.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.math.BigDecimal

@Entity
data class Seat(
    @Id @org.springframework.data.annotation.Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Long,
    val rowVal: Char,
    val num: Int,
    val price: BigDecimal,
    val description: String
) {
    override fun toString(): String = "Seat $rowVal-$num $$price ($description)"
}