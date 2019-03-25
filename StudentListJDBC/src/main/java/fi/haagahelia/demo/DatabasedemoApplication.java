package fi.haagahelia.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.demo.domain.Student;
import fi.haagahelia.demo.domain.StudentDAOImpl;

@SpringBootApplication
public class DatabasedemoApplication {
	private static final Logger log = LoggerFactory.getLogger(DatabasedemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DatabasedemoApplication.class, args);
	}
	   
	@Bean
	public CommandLineRunner demo(StudentDAOImpl studentDAO) {
		return (args) -> {
			// Database is created by using resources/schema.sql
			
			// Insert some demo data
	        studentDAO.save(new Student("John", "West"));
	        studentDAO.save(new Student("Mike", "Mars"));
	        studentDAO.save(new Student("Kate", "Johnson"));
	       
		};
	}	
}
