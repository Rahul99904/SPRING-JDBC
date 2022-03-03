package com.springjdbc;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springjdbc.dao.studentdao;
import com.springjdbc.dao.studentdaoimpli;
import com.springjdbc.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext cont=new ClassPathXmlApplicationContext("com/springjdbc/config.xml");
        studentdao stdao=(studentdaoimpli)cont.getBean("studentdaoimp");
        Scanner sc=new Scanner(System.in);
        Student  stdd=new Student();
        System.out.println("Select ops to be performed 1]insert 2]update_name 3]delete 4]select_sing_object 5]select_sing_object_(void ret) 6]select_all 7]selectall_met(void ret)" );
        int opt=sc.nextInt();
        if(opt==1) {   
          System.out.println("Insert vales are....." +stdao.insert(stdd));
        }
        
        if(opt==2) {
            System.out.println("Update vales are....." +stdao.update(stdd));
        }
        if(opt==3) {
            System.out.println("Delete vales are....." +stdao.delete(stdd));
        }
        if(opt==4) {
            System.out.println("select vales are....." +stdao.getdata(2201));
        	
        }
        if(opt==5) {
            stdao.getdata_m();
        }
        if(opt==6) {
           System.out.println("Data is " +stdao.getdata_list()); 
        }
        if(opt==7) {
            stdao.getdata_sl();
         }
       
       
    }
}
