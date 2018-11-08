package fi.haagahelia.demo.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @RequestMapping(value="/studentlist")
    public String studentList(Model model) {	
        // Fetch all students
        List<Map<String, Object>> students = jdbcTemplate.queryForList("select first_name, last_name from student");
        
        // Add studentlist to model and return to view
        model.addAttribute("students", students);
        return "studentlist";
    }	
	
}
