package com.example.demo;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.system.ApplicationHome;

@SpringBootApplication
public class BackendGenericoJava14Application {
	
	private static File home;

	public static void main(String[] args) {
		SpringApplication.run(BackendGenericoJava14Application.class, args);
	}

	public static File getHome() {
		ApplicationHome home = new ApplicationHome(BackendGenericoJava14Application.class);
		return home.getSource();
	}
}
