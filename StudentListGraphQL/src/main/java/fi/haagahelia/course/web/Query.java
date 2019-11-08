package fi.haagahelia.course.web;

import java.util.ArrayList;
import java.util.List;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import fi.haagahelia.course.domain.*;

@Component
public class Query implements GraphQLQueryResolver {
	@Autowired
	private StudentRepository repository; 
	
    public List<Student> students() {
        List<Student> students = new ArrayList<>();
        students = (List<Student>) repository.findAll();
        return students;
    }
}