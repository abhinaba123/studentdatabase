package com.cognizant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cognizant.configuration.ApplicationConfig;
import com.cognizant.dao.StudentDao;
import com.cognizant.model.Student;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	private static AnnotationConfigApplicationContext cntx;
	private static StudentDao st;
	private static Student s;
	@BeforeClass
	public static void setup()
	{
		cntx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		st = (StudentDao) cntx.getBean("studdao");
		s = (Student) cntx.getBean("student");
	}
	
	@Test
	public void testInsert() {
		assertEquals("Sucess",st.insert(s));
	}
	
	@Test
	public void testGetAll() {
		List<Student> list = st.getAll();
		assertEquals(3,list.size());
	}
}
