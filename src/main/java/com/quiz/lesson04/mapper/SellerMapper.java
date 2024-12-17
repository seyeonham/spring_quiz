package com.quiz.lesson04.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SellerMapper {

	public void insertSeller(String nickname, String profileImageUrl, Double temperature);
}
