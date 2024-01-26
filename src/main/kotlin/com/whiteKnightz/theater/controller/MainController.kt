package com.whiteKnightz.theater.controller

import com.whiteKnightz.theater.repositories.SeatRepository
import com.whiteKnightz.theater.services.BookingService
import com.whiteKnightz.theater.services.TheaterService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpMethod.GET
import org.springframework.http.HttpMethod.POST
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.servlet.ModelAndView

@Controller
class MainController {
    @Autowired
    lateinit var theaterService: TheaterService

    @Autowired
    lateinit var bookingService: BookingService

    @Autowired
    lateinit var seatRepository: SeatRepository

    @RequestMapping("")
    fun homePage(): ModelAndView = ModelAndView("seatBooking", "bean", CheckAvailabilityBackingBean())

    @RequestMapping(value = arrayOf("checkAvailability"), method = arrayOf(RequestMethod.POST))
    fun checkAvailability(bean: CheckAvailabilityBackingBean): ModelAndView {
        val selectedSeat = theaterService.find(bean.selectedSeatNo, bean.selectedSeatRow)
        val seatFree = bookingService.isSeatFree(selectedSeat)
        bean.result = "Seat $selectedSeat is " + if (seatFree) "Available" else "Booked"
        return ModelAndView("seatBooking", "bean", bean)
    }

//    @RequestMapping(value = arrayOf("bootstrap"))
//    fun createInitialData(): ModelAndView {
//        val seats = theaterService.seats
//        seatRepository.saveAll(seats)
//        return homePage()
//    }
}