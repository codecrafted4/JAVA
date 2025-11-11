package com.driver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


public class Application {

	public static void main(String[] args) {

		F1 mercedes = new F1("mercedes", false);
		mercedes.move(0, 0);
		mercedes.accelerate(0);
		mercedes.accelerate(40);
		mercedes.accelerate(-100);
	}

}
