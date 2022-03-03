package com.springjdbc.dao;

import java.util.List;

import com.springjdbc.entities.Student;

public interface studentdao {
	
		public int insert(Student stud);
		public int update(Student stud);
		public int delete(Student stud);
		public Student getdata(int id);
		public void getdata_m();
		public List<Student> getdata_list();
		public void getdata_sl();
	
}
