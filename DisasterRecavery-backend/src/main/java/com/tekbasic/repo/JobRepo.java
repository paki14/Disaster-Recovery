package com.tekbasic.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tekbasic.entity.Job;

@Repository
public interface JobRepo extends JpaRepository<Job, Integer>{
	
	
	@Modifying
	@Transactional
	@Query("update Job j set j.jobCode = :jobCode, j.description = :description, j.hourlyRate = :hourlyRate, j.maxHours = :maxHours where j.id = :id")
	void updateJob(@Param("jobCode") String jobCode, @Param("description") String discription,
	               @Param("hourlyRate") double hourlyRate, @Param("maxHours") double maxHours,
	               @Param("id") int id);

}
