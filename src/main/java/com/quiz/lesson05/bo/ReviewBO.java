package com.quiz.lesson05.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson05.domain.Review;
import com.quiz.lesson05.mapper.ReviewMapper;

@Service
public class ReviewBO {

	@Autowired
	private ReviewMapper reviewMapper;
	
	public List<Review> getReviewList(int storeId) {
		return reviewMapper.selectReviewList(storeId);
	}
}
