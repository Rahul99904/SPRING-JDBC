package com.springjdbc.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.springjdbc.entities.Student;

public class studentdaoimpli implements studentdao{

	private JdbcTemplate jdt;
	public JdbcTemplate getJdt() {
		return jdt;
	}
	public void setJdt(JdbcTemplate jdt) {
		this.jdt = jdt;
	}
	@Override
	public int insert(Student stud) {
		Scanner sc=new Scanner(System.in);
		 
   	 	System.out.println("Enter id");
        stud.setId(sc.nextInt());
        System.out.println("Enter Name");
        stud.setName(sc.next());
        System.out.println("Enter City");
        stud.setCity(sc.next());
        
		 String query="insert into student(id,name,city) values(?,?,?)";
		int result= jdt.update(query,stud.getId(),stud.getName(),stud.getCity());
		return result;
	}
	@Override
	public int update(Student stud) {
		String dec="";
		int res=0;
	
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the data that u want to update 1]id 2]name 3]city");
		int op_d=sc.nextInt();
	
		System.out.println("Enter id");
        int setid=sc.nextInt();
        
        if(op_d==1) {
        	System.out.println("Enter upd_id");
            stud.setId(sc.nextInt());
            
    		String query_up="update student set id=? where id=?";
    		res=jdt.update(query_up,stud.getId(), setid);
        }
        if(op_d==2) {
        	System.out.println("Enter upd_name" );
            stud.setName(sc.next());
            
    		String query_up="update student set name=? where id=?";
    		 res=jdt.update(query_up,stud.getName(), setid);
        }
        if(op_d==3) {
        	System.out.println("Enter upd_city" );
            stud.setCity(sc.next());
            
    		String query_up="update student set city=? where id=?";
    		 res=jdt.update(query_up,stud.getCity(), setid);
        }
       
		return res;
	}
	@Override
	public int delete(Student stud) {
		int res=0;
	
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the data by which u want to delete the row 1]id 2]name 3]city");
		int op_d=sc.nextInt();
    
        if(op_d==1) {
        	System.out.println("Enter id");
            stud.setId(sc.nextInt());
            
    		String query_del="delete from student where id=?";
    		res=jdt.update(query_del, stud.getId());
        }
        if(op_d==2) {
        	System.out.println("Enter name" );
            stud.setName(sc.next());
            
            String query_del="delete from student where name=?";
    		res=jdt.update(query_del, stud.getName());
        }
        if(op_d==3) {
        	System.out.println("Enter city");
            stud.setCity(sc.next());
            
            String query_del="delete from student where city=?";
    		res=jdt.update(query_del, stud.getCity());
        }
       
		return res;
	}
	@Override
	public Student getdata(int id) {
		String query="select * from student where id=?";
		RowMapper<Student> rowmapper=new Rowmapper();
	Student std=jdt.queryForObject(query, rowmapper, id);
		return std;
	}
	@Override
	public void getdata_m() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the id");
		int idd=sc.nextInt();
		String query_sm="select * from student where id=?";
		RowMapper<Student> rowmapper_sm=new Rowmapper();
	Student stud=jdt.queryForObject(query_sm, rowmapper_sm, idd);
	System.out.println("ID "+stud.getId());
	System.out.println("Name "+stud.getName());
	System.out.println("City "+stud.getCity());
		
	}
	@Override
	public List<Student> getdata_list() {
		String query_l="select * from student";
	List<Student> stud_l=jdt.query(query_l,new Rowmapper());
		return stud_l;
	}
	@Override
	public void getdata_sl() {
		String qu="select * from student";
		List<Student> ll=jdt.query(qu, new Rowmapper());
		Iterator<Student> it=ll.iterator();
		
		while(it.hasNext()) {
			Student Stu_itr=it.next();
			System.out.println("Id "+Stu_itr.getId());
			System.out.println("Name "+Stu_itr.getName());
			System.out.println("City "+Stu_itr.getCity());
			System.out.println("-------------------");
		}
	}
	

}
