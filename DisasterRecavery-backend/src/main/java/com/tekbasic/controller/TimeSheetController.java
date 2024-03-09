package com.tekbasic.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tekbasic.entity.Status;
import com.tekbasic.entity.TimeSheet;
import com.tekbasic.entity.User;
import com.tekbasic.model.TimeSheetModel;
import com.tekbasic.service.TimeSheetService;

@RestController
@RequestMapping("/timesheet")
@CrossOrigin("http//:localhost:4210")
public class TimeSheetController {

	@Autowired
	private TimeSheetService timeSheetService;
	@PostMapping("/add")
	public void addTimesheet(@RequestBody TimeSheetModel timeSheetModel){
		System.out.println(timeSheetModel.toString());
		timeSheetService.addTimeSheet(timeSheetModel);
	}
	@GetMapping("/view")
	public List<TimeSheet> getallTimeSheet(){
		return timeSheetService.getAllTimeSheet();
	}
	@GetMapping("/view/{id}")
	public Optional<TimeSheet> getTimeSheetsById(@PathVariable("id")int id){
		return timeSheetService.getTimeSheetByID(id);
	}
	@PostMapping("/user")
	public List<TimeSheet> getTimeSheetByUser(@RequestBody User user){
		return timeSheetService.getTimeSheetByUser(user);
	}
	@PutMapping("/status/{id}")
	public void updateStatus(@RequestBody TimeSheetModel timeSheetModel,@PathVariable("id")int id) {
		timeSheetService.updateStatus(timeSheetModel, id);
	}
	@PostMapping("/status")
	public List<TimeSheet> getTimeSheetByStatus(@RequestBody Status status){
		return timeSheetService.getTimeSheetByStatus(status);
	}
	@DeleteMapping("/delete/{id}")
	public void deleteTimeSheet(@PathVariable("id")int id) {
		timeSheetService.deleteTimeSheet(id);
	}
	@PutMapping("/update/{id}")
	public void updateTimeSheet(@RequestBody TimeSheetModel timeSheetModel,@PathVariable("id")int id) {
		timeSheetService.updateTimeSheet(timeSheetModel,id);
	}
}
