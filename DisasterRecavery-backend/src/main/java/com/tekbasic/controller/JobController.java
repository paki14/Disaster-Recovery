package com.tekbasic.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tekbasic.entity.Job;
import com.tekbasic.service.JobService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/job")
@CrossOrigin("http//:localhost:4210")
public class JobController {
	
	@Autowired
	private JobService jobService;
	
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public void addJod(@RequestBody Job job) {
		jobService.addJob(job);
	}
	@GetMapping("/viewAll")
	public List<Job> getAllJob(){
		return jobService.findAllJob();
	}
	@GetMapping("/view/{id}")
	public Optional<Job> getJobByID(@PathVariable("id")int id){
		return jobService.findJobById(id);
	}
	@PutMapping("/edit/{id}")
	public void editJob(@RequestBody Job job,@PathVariable("id")int id) {
		jobService.updateJob(job, id);
	}
	@DeleteMapping("/delete/{id}")
	public void deleteJob(@PathVariable("id")int id) {
		jobService.deleteJob(id);
	}
}
