package com.street.light;

import com.street.light.dto.MessageDto;
import com.street.light.dto.UserDto;
import org.apache.tomcat.jni.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LightApplication {

	public static void main(String[] args) {
		SpringApplication.run(LightApplication.class, args);
	}

}
