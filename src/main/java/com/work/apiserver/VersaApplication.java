package com.work.apiserver;

import com.work.apiserver.service.DataCollector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class VersaApplication implements CommandLineRunner {
	@Autowired
	private DataCollector dataCollector;

	public static void main(String[] args) {
		SpringApplication.run(VersaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		dataCollector.collectAndSaveData();
	}

}
