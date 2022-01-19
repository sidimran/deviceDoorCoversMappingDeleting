package com.door.device.sample.devicedoor.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.door.device.sample.devicedoor.Dto.DeviceDto;
import com.door.device.sample.devicedoor.Dto.DoorDto;
import com.door.device.sample.devicedoor.model.Device;
import com.door.device.sample.devicedoor.model.Door;

@Component
public class DeviceConverter {

	public Device dtoToEntity(DeviceDto deviceDto) {

		Device device = new Device();
		device.setDeviceId(deviceDto.getDeviceId());
		device.setDeviceIp(deviceDto.getDeviceIp());
		device.setSerialNumber(deviceDto.getSerialNumber());
		device.setDeviceName(deviceDto.getDeviceName());
		device.setListDoor(deviceDto.getDoor());
		device.setDoorCount(deviceDto.getDoorCount());

		List<Door> doorList = new ArrayList<Door>();

		Integer doorCount = deviceDto.getDoorCount();

		for (int i = 1; i <= doorCount; i++) {
			Door door = new Door();

			door.setDoorName(deviceDto.getDoorCount() + "-" + i);

			doorList.add(door);
		}

		device.setListDoor(doorList);
		return device;

	}

	public List<Device> dtoToEntity(List<DeviceDto> deviceDto) {

		return deviceDto.stream().map(this::dtoToEntity).collect(Collectors.toList());

	}

	public DeviceDto entityToDto(Device device) {

		DeviceDto deviceDto = new DeviceDto();

		deviceDto.setDeviceId(device.getDeviceId());
		deviceDto.setDeviceIp(device.getDeviceIp());
		deviceDto.setSerialNumber(device.getSerialNumber());
		deviceDto.setDeviceName(device.getDeviceName());
		deviceDto.setDoorCount(device.getDoorCount());
		deviceDto.setDoor(device.getListDoor());

		return deviceDto;

	}

	public List<DeviceDto> entityToDto(List<Device> device) {

		return device.stream().map(this::entityToDto).collect(Collectors.toList());
	}

}
