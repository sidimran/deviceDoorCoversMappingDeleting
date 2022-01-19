package com.door.device.sample.devicedoor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.door.device.sample.devicedoor.Dto.DeviceDto;
import com.door.device.sample.devicedoor.Dto.ResultDto;
import com.door.device.sample.devicedoor.converter.DeviceConverter;
import com.door.device.sample.devicedoor.converter.DoorConverter;
import com.door.device.sample.devicedoor.model.Device;
import com.door.device.sample.devicedoor.repository.DeviceRepository;
import com.door.device.sample.devicedoor.repository.DoorRepository;
import com.door.device.sample.devicedoor.service.DeviceService;

@Service
public class DeviceServiceImpl implements DeviceService {

	@Autowired
	DeviceRepository deviceRepository;

	@Autowired
	DeviceConverter deviceConverter;

	@Autowired
	DoorRepository doorRepository;

	@Autowired
	DoorConverter doorConverter;

	@Override
	public ResultDto saveDeviceData(DeviceDto deviceDto) {

		ResultDto resultDto = new ResultDto();
		Device device;

		device = deviceRepository.getByDeviceIp(deviceDto.getDeviceIp(), deviceDto.getSerialNumber(),
				deviceDto.getDeviceName());

		if (device == null) {
			device = deviceConverter.dtoToEntity(deviceDto);

			device = deviceRepository.save(device);
			DeviceDto passdeviceDto = deviceConverter.entityToDto(device);

			resultDto.setMessage("Device data saved Successfully");
			resultDto.setData(passdeviceDto);

		}

		if (!(device.getDeviceIp() == deviceDto.getDeviceIp() && device.getSerialNumber() == deviceDto.getSerialNumber()
				&& device.getDeviceName() == deviceDto.getDeviceName())) {
			resultDto.setMessage("deviceIp or serialNumber or DeviceName already exist");

		}
		return resultDto;

	}

	@Override
	public ResultDto getDevicDoorDataByDeviceId(int id) {

		Device device = deviceRepository.getById(id);
		DeviceDto deviceDto = deviceConverter.entityToDto(device);
		ResultDto resultDto = new ResultDto();
		resultDto.setMessage("Device and Door Data By Device Id");
		resultDto.setData(deviceDto);

		return resultDto;
	}

	@Override
	public void deleteDeviceDoorDataByDeviceId(int id) {

		deviceRepository.deleteByDeviceId(id);

	}

}
