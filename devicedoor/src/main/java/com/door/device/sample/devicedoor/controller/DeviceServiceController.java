package com.door.device.sample.devicedoor.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.door.device.sample.devicedoor.Dto.DeviceDto;
import com.door.device.sample.devicedoor.Dto.ResultDto;
import com.door.device.sample.devicedoor.service.DeviceService;

@RestController
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
public class DeviceServiceController {

	@Autowired
	DeviceService deviceService;

	@PostMapping("/saveDeviceData")
	public ResultDto saveDeviceData(@Valid @RequestBody DeviceDto deviceDto) {
		return deviceService.saveDeviceData(deviceDto);
	}

	@GetMapping("/getDevicDoorDataByDeviceID/{id}")
	public ResultDto getDevicDoorDataByDeviceID(@PathVariable(value = "id") Integer id) {
		return deviceService.getDevicDoorDataByDeviceId(id);

	}

	@DeleteMapping("/deleteDeviceDoorDataByDeviceId/{id}")
	public void deleteDeviceDoorDataByDeviceId(@PathVariable int id) {
		deviceService.deleteDeviceDoorDataByDeviceId(id);
	}

}
