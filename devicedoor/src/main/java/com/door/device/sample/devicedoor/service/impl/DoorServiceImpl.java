package com.door.device.sample.devicedoor.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.door.device.sample.devicedoor.Dto.DoorDto;
import com.door.device.sample.devicedoor.Dto.ResultDto;
import com.door.device.sample.devicedoor.converter.DoorConverter;
import com.door.device.sample.devicedoor.model.Door;
import com.door.device.sample.devicedoor.repository.DeviceRepository;
import com.door.device.sample.devicedoor.repository.DoorRepository;
import com.door.device.sample.devicedoor.service.DoorService;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Service
public class DoorServiceImpl implements DoorService {

	@Autowired
	DoorRepository doorRepository;

	@Autowired
	DoorConverter doorConverter;

	@JsonIgnore
	@Override
	public ResultDto getDoorAndDeviceDataByDoorId(int id) {

		Door door = doorRepository.getById(id);
		DoorDto doorDto = doorConverter.entityToDto(door);
		ResultDto resultDto = new ResultDto();
		resultDto.setMessage("Door and Device Data By Door Id");
		resultDto.setData(doorDto);

		return resultDto;
	}

}
