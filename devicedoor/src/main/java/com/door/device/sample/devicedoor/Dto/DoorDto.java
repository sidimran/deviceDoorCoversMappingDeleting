package com.door.device.sample.devicedoor.Dto;

import javax.validation.constraints.NotNull;

import com.door.device.sample.devicedoor.model.Device;

import lombok.Data;

@Data
public class DoorDto {

	private Integer id;

	@NotNull(message = "Enter Door Name")
	private String name;

	private Device device;

}
