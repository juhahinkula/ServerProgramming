package fi.haagahelia.demo.domain;

import java.util.List;


public interface StudentDAO {
	public void save(Student student);

	public Student findOne(int id); 

	public List<Student> findAll();
}
