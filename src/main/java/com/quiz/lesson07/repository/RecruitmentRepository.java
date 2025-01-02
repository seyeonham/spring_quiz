package com.quiz.lesson07.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.lesson07.entity.RecruitmentEntity;

public interface RecruitmentRepository extends JpaRepository<RecruitmentEntity, Integer> {
	public List<RecruitmentEntity> findById(int id);
	public List<RecruitmentEntity> findByCompanyId(int companyId);
	public List<RecruitmentEntity> findByPositionAndType(String position, String type);
	public List<RecruitmentEntity> findByTypeOrSalaryGreaterThanEqual(String type, int salary);
	public List<RecruitmentEntity> findTop3ByTypeOrderBySalaryDesc(String type);
	public List<RecruitmentEntity> findByRegionAndSalaryBetween(String region, int startSalart, int endSalary);
}
