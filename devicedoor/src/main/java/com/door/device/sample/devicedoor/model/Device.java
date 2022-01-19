package com.door.device.sample.devicedoor.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Device implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Device_Id")
	private Integer deviceId;

	@Column(name = "Device_IP", unique = true)
	private String deviceIp;

	@Column(name = "Serial_Number", unique = true)
	private String serialNumber;

	@Column(name = "Device_Name")
	private String deviceName;

	@Column(name = "Door_Count")
	private Integer doorCount;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name="Device_Id")
	private List<Door> listDoor;

}
