package com.door.device.sample.devicedoor.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.door.device.sample.devicedoor.model.Device;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Integer> {

	@Query("select dev from Device dev where dev.deviceIp=:deviceIp or dev.serialNumber=:serialNumber or dev.deviceName=:deviceName")
	Device getByDeviceIp(@Param("deviceIp") String deviceIp, @Param("serialNumber") String serialNumber,
			@Param("deviceName") String deviceName);

	@Modifying
	@Transactional
	@Query("delete from Device dev where dev.deviceId=:deviceId")
	void deleteByDeviceId(@Param("deviceId") int id);

}
