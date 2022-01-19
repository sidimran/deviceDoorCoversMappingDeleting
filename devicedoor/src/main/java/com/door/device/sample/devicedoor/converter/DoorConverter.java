package com.door.device.sample.devicedoor.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.door.device.sample.devicedoor.Dto.DeviceDto;
import com.door.device.sample.devicedoor.Dto.DoorDto;
import com.door.device.sample.devicedoor.model.Door;

@Component
public class DoorConverter {

	public Door dtoToEntity(DoorDto doorDto) {

		Door door = new Door();
		door.setId(doorDto.getId());
		door.setDoorName(doorDto.getName());
		door.setDevice(doorDto.getDevice());

		return door;
	}

	public List<Door> dtoToEntity(List<DoorDto> doorDto) {

		return doorDto.stream().map(this::dtoToEntity).collect(Collectors.toList());

	}

	public DoorDto entityToDto(Door door) {

		DoorDto doorDto = new DoorDto();
		doorDto.setId(door.getId());
		doorDto.setName(door.getDoorName());
		doorDto.setDevice(door.getDevice());

		return doorDto;

	}

	public List<DoorDto> entityToDto(List<Door> door) {

		return door.stream().map(this::entityToDto).collect(Collectors.toList());
	}
}
