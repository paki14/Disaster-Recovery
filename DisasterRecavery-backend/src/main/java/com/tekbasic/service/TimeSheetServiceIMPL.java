package com.tekbasic.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekbasic.entity.Status;
import com.tekbasic.entity.TimeSheet;
import com.tekbasic.entity.User;
import com.tekbasic.entity.WorkOrderLists;
import com.tekbasic.model.TimeSheetModel;
import com.tekbasic.model.WorkOrderListsModel;
import com.tekbasic.repo.TimeSheetRepo;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class TimeSheetServiceIMPL implements TimeSheetService {
	@Autowired
	private TimeSheetRepo timeSheetRepo;

	@Override
	public TimeSheet addTimeSheet(TimeSheetModel timesheetModel) {
		TimeSheet ts = new TimeSheet();
		ts.setSite(timesheetModel.getSite());
		ts.setUser(timesheetModel.getUser());
		ts.setDate(timesheetModel.getDate());
		List<WorkOrderLists> workList=timesheetModel.getWorkOrderList()
				.stream().map(this::maptoOrderList).collect(Collectors.toList());
		ts.setWorkOrderList(workList);
		double workHrs=0,amount=0;
		for (WorkOrderLists workOrderLists : workList) {
			workHrs=workHrs+workOrderLists.getWorkHours();
			amount=amount+workOrderLists.getTotalPay();
		}
		ts.setStatus(Status.OPEN);
		ts.setTotalAmount(amount);
		ts.setTotalHours(workHrs);
		System.out.println(ts.toString());
		return timeSheetRepo.save(ts);
	}
	private WorkOrderLists maptoOrderList(WorkOrderListsModel workOrderListsModel) {
		WorkOrderLists workOrderLists =new WorkOrderLists();
		workOrderLists.setJob(workOrderListsModel.getJob());
		workOrderLists.setWorkHours(workOrderListsModel.getWorkHours());
		workOrderLists.setTotalPay(workOrderListsModel.getTotalPay());
		return workOrderLists;
	}

	@Override
	public List<TimeSheet> getAllTimeSheet() {
		return timeSheetRepo.findAll();
	}

	@Override
	public Optional<TimeSheet> getTimeSheetByID(int id) {
		return timeSheetRepo.findById(id);
	}

	@Override
	public List<TimeSheet> getTimeSheetByUser(User user) {
		return timeSheetRepo.findByUser(user);
	}
	@Override
	public List<TimeSheet> getTimeSheetByStatus(Status status) {
		return timeSheetRepo.findByStatus(status);
	}
	@Override
	public void updateStatus(TimeSheetModel timeSheetModel, int id) {
		timeSheetRepo.updateStatus(timeSheetModel.getStatus(), id);
		
	}
	@Override
	public void deleteTimeSheet(int id) {
		timeSheetRepo.deleteById(id);
	}
	@Override
	public void updateTimeSheet(TimeSheetModel timeSheetModel, int id) {
		timeSheetRepo.updateTimeSheet(timeSheetModel.getDate() , id);
	}

}
