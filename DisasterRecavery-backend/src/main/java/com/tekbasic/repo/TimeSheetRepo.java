package com.tekbasic.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tekbasic.entity.Status;
import com.tekbasic.entity.TimeSheet;
import com.tekbasic.entity.User;
import com.tekbasic.model.TimeSheetModel;
@Repository
@Transactional
public interface TimeSheetRepo extends JpaRepository<TimeSheet, Integer> {

	@Query("from TimeSheet t where t.user=:user")
	public List<TimeSheet> findByUser(@Param("user")User user);
	@Modifying
	@Query("update TimeSheet t set t.status=:status where t.id=:id")
	public void updateStatus(@Param("status")Status status,@Param("id")int id );
	@Query("from TimeSheet t where t.status=:status")
	public List<TimeSheet>findByStatus(@Param("status")Status status);
	
	public void updateTimeSheet(TimeSheetModel timeSheetModel, int id);
}
