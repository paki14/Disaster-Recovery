package com.tekbasic.model;

import java.time.LocalDate;
import java.util.List;

import com.tekbasic.entity.Job;
import com.tekbasic.entity.Site;
import com.tekbasic.entity.TimeSheet;
import com.tekbasic.entity.User;
import com.tekbasic.entity.WorkOrderLists;

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
public class WorkOrderListsModel {

	private int id;
	private Job job;
	private double workHours;
	private double totalPay;
}
