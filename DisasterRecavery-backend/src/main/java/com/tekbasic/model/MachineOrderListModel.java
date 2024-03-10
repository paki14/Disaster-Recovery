package com.tekbasic.model;

import com.tekbasic.entity.Machine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MachineOrderListModel {

	private int id;
	private Machine machine;
	private double workHours;
	private double totalPay;
}
