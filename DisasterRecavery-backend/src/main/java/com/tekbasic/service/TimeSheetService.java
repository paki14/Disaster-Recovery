package com.tekbasic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tekbasic.entity.Status;
import com.tekbasic.entity.TimeSheet;
import com.tekbasic.entity.User;
import com.tekbasic.model.TimeSheetModel;

@Service
public interface TimeSheetService {

	public TimeSheet addTimeSheet(TimeSheetModel timesheetModel);
	public List<TimeSheet> getAllTimeSheet();
	public Optional<TimeSheet> getTimeSheetByID(int id);
	public List<TimeSheet> getTimeSheetByUser(User user);
	public List<TimeSheet> getTimeSheetByStatus(Status status);
	public void updateStatus(TimeSheetModel timeSheetModel,int id);
	public void deleteTimeSheet(int id);
	public void updateTimeSheet(TimeSheetModel timeSheetModel, int id);
}
