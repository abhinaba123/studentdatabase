package com.cognizant.service;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.cognizant.configuration.ApplicationConfig;
import com.cognizant.dao.StudentDao;
import com.cognizant.dao.StudentDaoImpl;
import com.cognizant.model.Student;

public class AppMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		StudentDao sd = (StudentDao) context.getBean("studao");
		Student s = (Student) context.getBean("student");
		s.setId(1);
		s.setName("Abhinaba");
		s.setMarks(90);

		sd.insert(s);

		s.setId(2);
		s.setName("Ayan");
		s.setMarks(85);

		sd.insert(s);
		
		s.setId(3);
		s.setName("Jyoti");
		s.setMarks(87);

		sd.insert(s);

		List<Student> list = sd.getAll();

		for (Student s1 : list) {
			System.out.println(s1);
		}
	}
}
