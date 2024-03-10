package com.tekbasic.model;

import java.time.LocalDate;
import java.util.List;

import com.tekbasic.entity.MachineOrderList;
import com.tekbasic.entity.Site;
import com.tekbasic.entity.Status;
import com.tekbasic.entity.User;

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
public class TimeSheetModel {

	private int id;
	private Site site;
	private User user;
	private LocalDate date;
	private Status status;
	private List<WorkOrderListsModel> workOrderList;
	private List<MachineOrderListModel> machineOrderList;
	@Override
	public String toString() {
		return "TimeSheetModel [id=" + id + ", site=" + site + ", user=" + user + ", date=" + date + ", workOrderList="
				+ workOrderList + "]";
	}
	
	
}
