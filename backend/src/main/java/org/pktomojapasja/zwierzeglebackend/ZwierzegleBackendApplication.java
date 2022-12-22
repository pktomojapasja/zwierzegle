package org.pktomojapasja.zwierzeglebackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class ZwierzegleBackendApplication {

	public static void main(String[] args) {

		System.out.println("test123");
		SpringApplication.run(ZwierzegleBackendApplication.class, args);

	}

}
