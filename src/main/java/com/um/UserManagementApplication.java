package com.um;

import jakarta.annotation.Resource;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.util.Arrays;

@SpringBootApplication
public class UserManagementApplication implements ApplicationRunner {

	@Resource
	private Environment environment;

	public static void main(String[] args) {
		SpringApplication.run(UserManagementApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) {
		System.out.println("========================================================");
		System.out.println("active profile - " + Arrays.toString(environment.getActiveProfiles()));
		System.out.println("========================================================");
	}
}
