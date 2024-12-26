package com.quiz.lesson05;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson02.bo.StoreBO;
import com.quiz.lesson02.domain.Store;
import com.quiz.lesson05.bo.ReviewBO;
import com.quiz.lesson05.domain.Review;

@RequestMapping("/lesson05/quiz05")
@Controller
public class Lesson05Quiz05Controller {

	@Autowired
	private StoreBO storeBO;
	
	@Autowired
	private ReviewBO reviewBO;
	
	@GetMapping("/stores-view")
	public String stores(Model model) {
		
		List<Store> storeList = storeBO.getStoreList();
		model.addAttribute("storeList", storeList);
		
		return "lesson05/quiz05_stores";
	}
	
	@GetMapping("/reviews-view")
	public String reviews(Model model,
			@RequestParam("storeId") int storeId,
			@RequestParam("storeName") String storeName) {
		
		List<Review> reviewList = reviewBO.getReviewList(storeId);
		model.addAttribute("reviewList", reviewList);
		model.addAttribute("storeId", storeId);
		model.addAttribute("storeName", storeName);
		
		return "lesson05/quiz05_reviews";
	}
}
