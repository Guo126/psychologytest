package com.glb.sz;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;


@SpringBootApplication
@Configurable
public class DztApplication {

	public static void main(String[] args) {
		SpringApplication.run(DztApplication.class, args);
	}
}
