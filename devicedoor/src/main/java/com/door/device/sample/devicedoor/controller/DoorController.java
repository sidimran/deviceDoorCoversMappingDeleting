package com.door.device.sample.devicedoor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.door.device.sample.devicedoor.Dto.ResultDto;
import com.door.device.sample.devicedoor.service.DoorService;

@RestController
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
public class DoorController {

	@Autowired
	DoorService doorService;

	@GetMapping("/getByDoorID/{id}")
	public ResultDto getDoorDataById(@PathVariable Integer id) {
		return doorService.getDoorAndDeviceDataByDoorId(id);
	}
}
