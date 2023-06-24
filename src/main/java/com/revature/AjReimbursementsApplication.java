package com.revature;

import com.revature.models.Statuses;
import com.revature.services.StatusServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AjReimbursementsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AjReimbursementsApplication.class, args);

//		@Autowired
//		private StatusServices statusServices ;
//
//		@Override
//		public void run(String... args) throws Exception {
//			System.out.println(statusServices.getAllStatuses());
//
//
//		}
		

	}

}
