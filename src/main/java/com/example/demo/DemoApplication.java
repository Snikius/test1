package com.example.demo;

import com.example.demo.services.OperationsService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(OperationsService operationsService) {
		return (args) -> {
			System.out.println("Enter command: ADD, LIST USERS, LIST DOCS, DELETE, EXIT");
			Scanner scanner = new Scanner(System.in);
			while (true) {
				var command = scanner.nextLine();
				System.out.println(": " + command);
				switch (command) {
					case "EXIT":
						System.out.println(": BYE!");
						return;
					case "ADD":
						operationsService.addUsers();
						break;
					case "LIST USERS":
						operationsService.listUsers();
						break;
					case "LIST DOCS":
						operationsService.listDocuments();
						break;
					case "DELETE":
						operationsService.deleteUsers();
						break;
					default:
						System.out.println(": UNKNOWN COMMAND");
						break;
				}
			}
		};
	}
}
