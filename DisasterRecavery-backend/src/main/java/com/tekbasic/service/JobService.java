package com.tekbasic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tekbasic.entity.Job;

@Service
public interface JobService {

	public void addJob(Job job);
	public List<Job>findAllJob();
	public Optional<Job> findJobById(int id);
	public void deleteJob(int id);
	public void updateJob(Job job,int id);
}
