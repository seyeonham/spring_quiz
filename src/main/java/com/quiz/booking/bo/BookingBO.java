package com.quiz.booking.bo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.booking.domain.Booking;
import com.quiz.booking.mapper.BookingMapper;

@Service
public class BookingBO {

	@Autowired
	private BookingMapper bookingMapper;
	
	public List<Booking> getBookingList() {
		return bookingMapper.selectBookingList();
	}
	
	public int deleteBookingById(int id) {
		return bookingMapper.deleteBookingById(id);
	}
	
	public int addBooking(String name, LocalDate date, int day,
			int headcount, String phoneNumber) {
		return bookingMapper.insertBooking(name, date, day, headcount, phoneNumber);
	}
	
	// input: name, phoneNumber
	// output: Booking(단건 최신) or null
	public Booking getLatestBookingByNamePhoneNumber(String name, String phoneNumber) {
		List<Booking> bookingList =  bookingMapper.selectBookingByNamePhoneNumber(name, phoneNumber);
		// [] or [Booking] or [Booking, Booking, ...]
//		if (bookingList.isEmpty()) {
//			return null;
//		}
//		
//		return bookingList.get(bookingList.size() - 1);
		
		return bookingList.isEmpty() ? null : bookingList.get(bookingList.size() - 1);
	}
}