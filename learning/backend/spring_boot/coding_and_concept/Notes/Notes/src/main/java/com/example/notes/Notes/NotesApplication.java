package com.example.notes.Notes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NotesApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotesApplication.class, args);

		String a = "MESSAGE", b = "OFFLINE";
		System.out.println(a.compareTo(b));	

	}

}
