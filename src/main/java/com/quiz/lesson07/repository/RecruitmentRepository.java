package com.quiz.lesson07.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.quiz.lesson07.entity.RecruitmentEntity;

public interface RecruitmentRepository extends JpaRepository<RecruitmentEntity, Integer> {
	// JPQL => Entity에 조회하는 개념
	
	// public List<RecruitmentEntity> findById(int id); - 이미 가지고 있음.
	public List<RecruitmentEntity> findByCompanyId(int companyId);
	public List<RecruitmentEntity> findByPositionAndType(String position, String type);
	public List<RecruitmentEntity> findByTypeOrSalaryGreaterThanEqual(String type, int salary);
	public List<RecruitmentEntity> findTop3ByTypeOrderBySalaryDesc(String type);
	public List<RecruitmentEntity> findByRegionAndSalaryBetween(String region, int startSalary, int endSalary);
	public List<RecruitmentEntity> findByTypeAndDeadlineGreaterThanEqualAndSalaryGreaterThanEqualOrderBySalaryDesc(String type, LocalDate deadline, int salary);
	
	// native query
	@Query(value = "select * from `recruitment` where `type` = :type and `deadline` >= :deadline and `salary` >= :salary order by salary desc", nativeQuery = true)
	public List<RecruitmentEntity> findByDeadlineAndType(
			@Param("type") String type,
			@Param("deadline") String deadline,
			@Param("salary") int salary);
}
