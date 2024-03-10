package com.tekbasic.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tekbasic.entity.Job;
import com.tekbasic.entity.Machine;
import com.tekbasic.service.JobService;
import com.tekbasic.service.MachineService;

@RestController
@RequestMapping("/machine")
@CrossOrigin("http//:localhost:4210")
public class MachineController {

	@Autowired
	private MachineService machineService;
	
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public void addMachine(@RequestBody Machine machine) {
		machineService.addMachine(machine);
	}
	@GetMapping("/viewAll")
	public List<Machine> getAllMachine(){
		return machineService.findAllMachine();
	}
	@GetMapping("/view/{id}")
	public Optional<Machine> getJobByID(@PathVariable("id")int id){
		return machineService.findMachineById(id);
	}
	@PutMapping("/edit/{id}")
	public void editMachine(@RequestBody Machine machine,@PathVariable("id")int id) {
		machineService.updateMachine(machine, id);
	}
	@DeleteMapping("/delete/{id}")
	public void deleteMachine(@PathVariable("id")int id) {
		machineService.deleteMachine(id);
	}
}
