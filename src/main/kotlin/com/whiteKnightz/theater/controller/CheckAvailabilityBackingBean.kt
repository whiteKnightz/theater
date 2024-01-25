package com.whiteKnightz.theater.controller

class CheckAvailabilityBackingBean {
    val seatNos = 1..36
    val seatRows = 'A'..'O'
    var selectedSeatNo: Int = 1
    var selectedSeatRow: Char = 'A'
    var result: String = ""
}