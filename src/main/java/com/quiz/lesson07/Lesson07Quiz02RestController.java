package com.quiz.lesson07;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson07.entity.RecruitmentEntity;
import com.quiz.lesson07.repository.RecruitmentRepository;

@RequestMapping("/lesson07/quiz02")
@RestController
public class Lesson07Quiz02RestController {

	@Autowired
	private RecruitmentRepository recruitmentRepository;
	
	// 1) id로 조회
	@GetMapping("/1")
	public RecruitmentEntity select1() {
		return recruitmentRepository.findById(8).orElse(null);
	}
	
	// 2) parameter 조건 조회
	@GetMapping("/2")
	public List<RecruitmentEntity> select2(
			@RequestParam("companyId") int companyId) {
		return recruitmentRepository.findByCompanyId(companyId);
	}
	
	// 3) 복합 조건 조회 AND
	@GetMapping("/3")
	public List<RecruitmentEntity> select3() {
		return recruitmentRepository.findByPositionAndType("웹 back-end 개발자", "정규직");
	}
	
	// 4) 복합 조건 조회 OR
	@GetMapping("/4")
	public List<RecruitmentEntity> select4() {
		return recruitmentRepository.findByTypeOrSalaryGreaterThanEqual("정규직", 9000);
	}
	
	// 5) 정렬 제한 조건
	@GetMapping("/5")
	public List<RecruitmentEntity> select5() {
		return recruitmentRepository.findTop3ByTypeOrderBySalaryDesc("계약직");
	}
	
	// 6) 범위 조회
	@GetMapping("/6")
	public List<RecruitmentEntity> select6() {
		return recruitmentRepository.findByRegionAndSalaryBetween("성남시 분당구", 7000, 8500);
	}
	
	// 7) solution1 - JPQL
//	@GetMapping("/7")
//	public List<RecruitmentEntity> select7() {
//		return recruitmentRepository
//				.findByTypeAndDeadlineAfterAndSalaryGreaterThanEqualOrderBySalaryDesc("정규직", "2026-04-10", 8100);
//	}
	
	// 7) solution2 - Native Query
	@GetMapping("/7")
	public List<RecruitmentEntity> select7() {
		return recruitmentRepository.findByDeadlineAndType("정규직", "2026-04-10", 8100);
	}
}
