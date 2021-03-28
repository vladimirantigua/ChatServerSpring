package com.example.chatServerSpring;

import  org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChatServerSpringApplication {
//server file
	public static void main(String[] args) {
		new	 RoomInfo();

		SpringApplication.run(ChatServerSpringApplication.class, args);
	}

}
