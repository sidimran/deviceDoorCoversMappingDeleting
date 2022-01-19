package com.door.device.sample.devicedoor.Dto;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.door.device.sample.devicedoor.model.Door;

import lombok.Data;

@Data
public class DeviceDto {

	private Integer deviceId;

	@NotNull(message = "enter the Device IP Address")
	
	private String deviceIp;

	@NotNull(message = "enter the Device Serial Number")
	private String serialNumber;

	@NotNull(message = "enter the Device Name")
	private String deviceName;

	@NotNull(message = "enter the Door Count")
	private Integer doorCount;
	
	private List<Door> door;
	


}
