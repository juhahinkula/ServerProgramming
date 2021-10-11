package fi.haagahelia.course;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.Test;

import fi.haagahelia.course.domain.Department;
import fi.haagahelia.course.domain.Student;
import fi.haagahelia.course.domain.StudentRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository repository;

    @Test
    public void findByLastnameShouldReturnStudent() {
        List<Student> students = repository.findByLastName("Johnson");
        
        assertThat(students).hasSize(1);
        assertThat(students.get(0).getFirstName()).isEqualTo("John");
    }
    
    @Test
    public void createNewStudent() {
    	Student student = new Student("Mickey", "Mouse", "mm@mouse.com", new Department("BITE"));
    	repository.save(student);
    	assertThat(student.getId()).isNotNull();
    }    
    @Test
    public void deleteNewStudent() {
		List<Student> students = repository.findByLastName("Johnson");
		Student student = students.get(0);
		repository.delete(student);
		List<Student> newStudents = repository.findByLastName("Johnson");
		assertThat(newStudents).hasSize(0);
     }

}
