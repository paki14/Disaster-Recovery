package com.tekbasic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekbasic.entity.Job;
import com.tekbasic.repo.JobRepo;
@Service
public class JobServiceIMPL implements JobService {

	@Autowired
	private JobRepo jobRepo;
	@Override
	public void addJob(Job job) {
		jobRepo.save(job);
	}

	@Override
	public List<Job> findAllJob() {
		return jobRepo.findAll();
	}

	@Override
	public Optional<Job> findJobById(int id) {
		return jobRepo.findById(id);
	}

	@Override
	public void deleteJob(int id) {
		jobRepo.deleteById(id);
	}

	@Override
	public void updateJob(Job job, int id) {
		jobRepo.updateJob(job.getJobCode(), job.getDescription(), job.getHourlyRate(), job.getMaxHours(), id);
	}

}
