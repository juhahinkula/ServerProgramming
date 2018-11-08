package fi.haagahelia.demo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class DatabasedemoApplication {
	private static final Logger log = LoggerFactory.getLogger(DatabasedemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DatabasedemoApplication.class, args);
	}
	   
	@Bean
	public CommandLineRunner demo(JdbcTemplate jdbcTemplate) {
		return (args) -> {
			// Database is created by using resources/schema.sql
			
			// Insert some demo data
	        jdbcTemplate.update("insert into student(first_name, last_name) values (?, ?)", "John", "West");
	        jdbcTemplate.update("insert into student(first_name, last_name) values (?, ?)", "Mike", "Mars");
	        jdbcTemplate.update("insert into student(first_name, last_name) values (?, ?)", "Kate", "Johnson");
		};
	}	
}
