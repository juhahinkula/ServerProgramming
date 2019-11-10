package fi.haagahelia.course.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;

import fi.haagahelia.course.domain.Department;
import fi.haagahelia.course.domain.DepartmentRepository;
import fi.haagahelia.course.domain.Student;
import fi.haagahelia.course.domain.StudentRepository;

@Component
public class Mutation implements GraphQLMutationResolver {

 @Autowired
 private DepartmentRepository drepository;

 @Autowired
 private StudentRepository srepository;
 
 public Department createDepartment(String name) {
	 return drepository.save(new Department(name));
 }
 
 public Student createStudent(String firstname, String lastname, String email) {
	 return srepository.save(new Student(firstname, lastname, email));
 }
 
}
