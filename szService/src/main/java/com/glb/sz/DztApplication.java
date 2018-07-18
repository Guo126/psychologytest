package com.glb.sz;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@Configurable
public class DztApplication {

	public static void main(String[] args) {
		SpringApplication.run(DztApplication.class, args);
	}
}
