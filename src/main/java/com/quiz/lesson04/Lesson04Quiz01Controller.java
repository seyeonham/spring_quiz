package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson04.BO.SellerBO;
import com.quiz.lesson04.domain.Seller;

@RequestMapping("/lesson04/quiz01")
@Controller
public class Lesson04Quiz01Controller {

	@Autowired
	private SellerBO sellerBO;
	
	// seller 추가 화면
	// http://localhost:8080/lesson04/quiz01/add-seller-view
	@RequestMapping(path = "/add-seller-view", method = RequestMethod.GET)
	public String addSellerView() {
		return "lesson04/addSeller";
	}
	
	// seller 추가 API
	// http://localhost:8080/lesson04/quiz01/add-seller
	@PostMapping("/add-seller")
	public String addSeller(
			@RequestParam("nickname") String nickname,
			@RequestParam(value = "profileImageUrl", required = false) String profileImageUrl,
			@RequestParam(value = "temperature", required = false) Double temperature) {
		
		// DB insert
		sellerBO.insertSeller(nickname, profileImageUrl, temperature);
		// response 화면
		return "lesson04/afterAddSeller";
	}
	
	// 최근 추가된 seller 화면
	// http://localhost:8080/lesson04/quiz01/seller-info-view
	@GetMapping("/seller-info-view")
	public String sellerInfoView(Model model) {
		// DB select
		Seller seller = sellerBO.getLatestSeller();
		
		// model에 데이터 담기
		model.addAttribute("result", seller);
		model.addAttribute("title", "최근 추가된 seller");
		
		return "lesson04/latestSeller";
	}
	
}
