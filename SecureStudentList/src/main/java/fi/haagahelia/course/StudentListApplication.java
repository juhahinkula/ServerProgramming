package fi.haagahelia.course;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.course.domain.Department;
import fi.haagahelia.course.domain.DepartmentRepository;
import fi.haagahelia.course.domain.Student;
import fi.haagahelia.course.domain.StudentRepository;

@SpringBootApplication
public class StudentListApplication {
	private static final Logger log = LoggerFactory.getLogger(StudentListApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(StudentListApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner studentDemo(StudentRepository srepository, DepartmentRepository drepository) {
		return (args) -> {
			log.info("save a couple of students");
			drepository.save(new Department("IT"));
			drepository.save(new Department("Business"));
			drepository.save(new Department("Law"));
			
			srepository.save(new Student("John", "Johnson", "john@john.com", drepository.findByName("IT").get(0)));
			srepository.save(new Student("Katy", "Kateson", "kate@kate.com", drepository.findByName("Business").get(0)));	
			
			log.info("fetch all students");
			for (Student student : srepository.findAll()) {
				log.info(student.toString());
			}

		};
	}
}
