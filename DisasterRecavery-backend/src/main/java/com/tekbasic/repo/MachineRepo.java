package com.tekbasic.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tekbasic.entity.Machine;
@Repository
public interface MachineRepo extends JpaRepository<Machine, Integer> {

	@Modifying
	@Transactional
	@Query("update Machine m set m.machineCode = :machineCode, m.description = :description, m.hourlyRate = :hourlyRate, m.maxHours = :maxHours where m.id = :id")
	void updateJob(@Param("machineCode") String machineCode, @Param("description") String discription,
	               @Param("hourlyRate") double hourlyRate, @Param("maxHours") double maxHours,
	               @Param("id") int id);
}
