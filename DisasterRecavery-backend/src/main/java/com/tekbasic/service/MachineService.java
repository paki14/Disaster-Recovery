package com.tekbasic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tekbasic.entity.Machine;

@Service
public interface MachineService {

	public void addMachine(Machine machine);
	public List<Machine>findAllMachine();
	public Optional<Machine> findMachineById(int id);
	public void deleteMachine(int id);
	public void updateMachine(Machine machine,int id);
}
