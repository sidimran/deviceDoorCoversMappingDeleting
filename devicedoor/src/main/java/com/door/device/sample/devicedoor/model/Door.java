package com.door.device.sample.devicedoor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Entity
@Data
public class Door {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Door_Id")
	private Integer id;
	@Column(name = "Door_Name")
	private String doorName;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	
	@JoinColumn(name = "Device_Id")
	private Device device;

}