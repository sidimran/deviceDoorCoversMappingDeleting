package com.door.device.sample.devicedoor.service;

import com.door.device.sample.devicedoor.Dto.DeviceDto;
import com.door.device.sample.devicedoor.Dto.ResultDto;

public interface DeviceService {

	public ResultDto saveDeviceData(DeviceDto deviceDto);

	public ResultDto getDevicDoorDataByDeviceId(int id);
	
	public void deleteDeviceDoorDataByDeviceId(int id);
	

}
