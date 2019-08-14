package com.kings.expensetracker;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages="com.kings.expensetracker")
public class ExpenseTracker {
	public static void main(String[] args){
		
		SpringApplication.run(ExpenseTracker.class, args);
	}
}
