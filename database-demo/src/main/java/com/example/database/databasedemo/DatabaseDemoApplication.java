package com.example.database.databasedemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.function.Supplier;

@SpringBootApplication
public class DatabaseDemoApplication implements CommandLineRunner {
//run durring application context is loaded.
	private Logger logger= LoggerFactory.getLogger(this.getClass());
	@Autowired
	PersonJdbcDAO dao;
	public static void main(String[] args) {
		SpringApplication.run(DatabaseDemoApplication.class, args);

	}
	@Override
	public void run(String... args) throws Exception
	{
		logger.info("All users information-> {}", dao.findAll());
		logger.info("User 1001-> {}", dao.findById(1001));
		logger.info("Number of users deleted -> {}", dao.deleteById(1002));
		logger.info("Inserting new user 1005 -> {}", dao.insert(new Person(1005,"Tara","Berlin",new Date())));
		logger.info("Updating  user 1003 -> {}", dao.update(new Person(1003,"Manju","New York",new Date())));
		logger.info("Inserting new user 1006 -> {}", dao.insert(new Person(1006,"Anu","LA",new Date())));
		logger.info("Inserting new user 1007 -> {}", dao.insert(new Person(1007,"Sandhya","Denver",new Date())));
		logger.info("Current users information-> {}", dao.findAll());
	}
;
}
