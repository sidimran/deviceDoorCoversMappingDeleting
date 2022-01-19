package com.door.device.sample.devicedoor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.door.device.sample.devicedoor.model.Device;

@SpringBootApplication
public class DevicedoorApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevicedoorApplication.class, args);

//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.door.device.sample.devicedoor");
//
//		EntityManager em = emf.createEntityManager();
//		
//		em.getTransaction().begin();
//		
//		Device d = em.find(Device.class, 37);
		
		
		

	}

}
