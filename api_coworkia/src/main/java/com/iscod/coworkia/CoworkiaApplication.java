package com.iscod.coworkia;

import com.iscod.coworkia.controllers.ZoneController;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.iscod.coworkia.controllers.PostController;
import com.iscod.coworkia.entities.Post;
import com.iscod.coworkia.entities.Zone;

@SpringBootApplication
public class CoworkiaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(CoworkiaApplication.class, args);

	}
}
