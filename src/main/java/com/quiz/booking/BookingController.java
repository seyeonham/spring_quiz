package com.quiz.booking;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.booking.bo.BookingBO;
import com.quiz.booking.domain.Booking;

@RequestMapping("/booking")
@Controller
public class BookingController {

	@Autowired
	private BookingBO bookingBO;
	
	@GetMapping("/booking-list-view")
	public String bookingListView(Model model) {
		// db select
		List<Booking> bookingList = bookingBO.getBookingList();
		
		// model
		model.addAttribute("bookingList", bookingList);
		
		return "booking/bookingList";
	}
	
	// AJAX 요청
	// 삭제
	@ResponseBody
	@DeleteMapping("/delete-booking")
	public Map<String, Object> deleteBooking(
			@RequestParam("id") int id) {
		
		// db delete
		int rowCount = bookingBO.deleteBookingById(id);
		
		// 응답값
		Map<String, Object> result = new HashMap<>();
		if (rowCount == 1) {
			// 삭제 성공
			result.put("code", 200);
			result.put("result", "성공");
		} else {
			// 삭제 실패
			result.put("code", 300);
			result.put("error_message", "삭제할 데이터가 없습니다.");
		}
		
		return result;
	}
	
	// 예약하기 화면
	@GetMapping("/make-booking-view")
	public String makeBookingView() {
		return "booking/makeBooking";
	}
	
	// AJAX 요청
	// 예약 추가
	@ResponseBody
	@PostMapping("/make-booking")
	public Map<String, Object> makeBooking(
			@RequestParam("name") String name,
			@RequestParam("date") LocalDate date,
			@RequestParam("day") int day,
			@RequestParam("headcount") int headcount,
			@RequestParam("phoneNumber") String phoneNumber) {
		
		// db insert
		int rowCount = bookingBO.addBooking(name, date, day, headcount, phoneNumber);
		
		
		// 응답값
		Map<String, Object> result = new HashMap<>();
		if (rowCount > 0) {
			result.put("code", 200);
			result.put("result", "성공");			
		} else {
			result.put("code", 300);
			result.put("error_message", "예약하는데 실패했습니다. 관리자한테 문의해주세요.");
		}
		return result; // JSON String
	}
	
	// 예약 확인 화면
	@GetMapping("/check-booking-view")
	public String checkBookingView() {
		return "booking/checkBooking";
	}
	
	// AJAX 요청
	// 예약 확인
	@ResponseBody // 이것을 사용하면 model 사용할 수 없다.
	@PostMapping("/check-booking")
	public Map<String, Object> checkBooking(
			@RequestParam("name") String name,
			@RequestParam("phoneNumber") String phoneNumber) {
		
		// db select
		Booking booking = bookingBO.getLatestBookingByNamePhoneNumber(name, phoneNumber);
		
		// JSON 응답값
		Map<String, Object> result = new HashMap<>();
		if (booking != null) {
			result.put("code", 200);
			result.put("booking", booking);
		} else if (booking == null) {
			result.put("code", 300);
			result.put("error_message", "예약 내역이 없습니다.");
		}
		return result;
	}
}
