package com.madhu.ProjectManagerServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ProjectManagerServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectManagerServerApplication.class, args);
	}

}
