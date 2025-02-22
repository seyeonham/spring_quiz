package com.quiz.lesson04.BO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson04.domain.Seller;
import com.quiz.lesson04.mapper.SellerMapper;

@Service
public class SellerBO {
	
	@Autowired
	private SellerMapper sellerMapper;
	
	public void insertSeller(String nickname, String profileImageUrl, Double temperature) {
		sellerMapper.insertSeller(nickname, profileImageUrl, temperature);
	}
	
//	public Seller getLatestSeller() {
//		return sellerMapper.selectLatestSeller();
//	}
//	
//	public Seller getSellerById(int id) {
//		return sellerMapper.selectSellerById(id);
//	}
	
	public Seller getSeller(Integer id) {
		if (id == null) {
			return sellerMapper.selectLatestSeller();
		} else {
			return sellerMapper.selectSellerById(id);
		}
	}
}
