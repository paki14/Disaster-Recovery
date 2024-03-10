package com.tekbasic.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
@Entity
@Table(name="timesheet",schema="disaster")
public class TimeSheet {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name = "site_id" , referencedColumnName = "id")
	private Site site;
	@ManyToOne
	@JoinColumn(name = "user_id" , referencedColumnName = "id")
	private User user;
	private LocalDate date;
	@OneToMany(cascade = CascadeType.ALL)
	private List<WorkOrderLists> workOrderList;
	@OneToMany(cascade = CascadeType.ALL)
	private List<MachineOrderList> machineOrderList;
	@Enumerated(EnumType.STRING)
	private Status status;
	private double totalHours;
	private double totalAmount;
	
}
