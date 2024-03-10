package com.tekbasic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekbasic.entity.Machine;
import com.tekbasic.repo.JobRepo;
import com.tekbasic.repo.MachineRepo;

@Service
public class MachhineServiceIMPL implements MachineService{
	
	@Autowired
	private MachineRepo machineRepo;

	@Override
	public void addMachine(Machine machine) {
		machineRepo.save(machine);
	}

	@Override
	public List<Machine> findAllMachine() {
		return machineRepo.findAll();
	}

	@Override
	public Optional<Machine> findMachineById(int id) {
		return machineRepo.findById(id);
	}

	@Override
	public void deleteMachine(int id) {
		machineRepo.deleteById(id);
	}

	@Override
	public void updateMachine(Machine machine, int id) {
		machineRepo.updateJob(machine.getMachineCode(), machine.getDescription(), machine.getHourlyRate(),
				machine.getMaxHours(), id);		
	}

}
