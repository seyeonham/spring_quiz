package com.quiz.lesson05.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.quiz.lesson05.domain.Review;

@Mapper
public interface ReviewMapper {

	public List<Review> selectReviewList(int storeId);
}
