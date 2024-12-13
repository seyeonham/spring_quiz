package com.quiz.lesson03.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.quiz.lesson03.domain.RealEstate;

@Mapper
public interface RealEstateMapper {

	// input: id
	// output: realEstate
	public RealEstate selectRealEstateById(int id);
	
	// input: rentPrice
	// output: List<RentPrice>
	public List<RealEstate> selectRealEstateByRentPrice(int rentPrice);
	
	// input: area, price
	// output: List<RentPrice>
	public List<RealEstate> selectRealEstateByAreaAndPrice(
			@Param("area") int area,
			@Param("price") int price);
}
