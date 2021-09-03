package com.vco.hibernateDemo.dao;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.vco.hibernate.singletonfactory.classes.SingletonFactory;
import com.vco.hibernateDemo.dto.StudentDTO;

public class StudentDAO 
{
	public void insert(StudentDTO student)
	{
		//hibernate logic to inset 
//		Configuration config = new Configuration();
//		config.configure().addAnnotatedClass(StudentDTO.class);
		
//		SessionFactory factory = config.buildSessionFactory();
		
		SessionFactory factory = SingletonFactory.getFactory();
		
		Session session = factory.openSession();
		
		org.hibernate.Transaction tx = session.beginTransaction();
		
		session.save(student);
		
		tx.commit();
		session.close();
	}
	
	public StudentDTO readByStudentId(int studentId)
	{
		// hibernate logic read
//		Configuration config =  new Configuration();
//		config.configure();
		
//		SessionFactory factory = config.buildSessionFactory();
		
		SessionFactory factory = SingletonFactory.getFactory();
		Session session = factory.openSession();
		
		StudentDTO student  = session.get(StudentDTO.class, studentId);
		
		session.close();
		
		System.out.println("student info for student Id" + studentId + "------>"+student);
		return student;
	}
	
	public void updateById(int studentId)
	{
		Scanner sc = new Scanner(System.in);
		
		StudentDTO student = readByStudentId(studentId);
		System.out.println("student info before update --> "+student);
		
		if(student!=null)
		{
			//hibernate logic for update
			
			System.out.println("choice for update are");
			System.out.println("--------------------------");
			System.out.println("1.Name\n2.Branch\n3.Marks\n4.PhoneNumber\n5.Address");
			System.out.println("enter your choice = ");
			int choice = sc.nextInt();
			
			if(choice == 1)
			{
				System.out.println("Enter the new name = ");
				student.setStud_name(sc.next());
			}
			else if(choice == 2)
			{
				System.out.println("Enter the branch name = ");
				student.setStud_branch(sc.next());
			}
			else if(choice == 3)
			{
				System.out.println("enter the new marks = ");
				student.setStud_marks(sc.nextDouble());
			}
			else if(choice == 4)
			{
				System.out.println("enter the new phoneNumber");
				student.setStud_phoneNumber(sc.next());
			}
			else if(choice == 5)
			{
				System.out.println("enter the new address = ");
				student.setStud_address(sc.next());
			}
			else
			{
				System.out.println("choice is invalid.......update failed");
				return;
			}
			System.out.println("student info after update --> "+student);
			
			SessionFactory factory = SingletonFactory.getFactory();
			Session session = factory.openSession();
			
			session.update(student);
			
			org.hibernate.Transaction tx = session.beginTransaction();
			
			tx.commit();
			session.close();
			
		}
		else
		{
			System.out.println("Student with the given id is not present");
		}
	}
	
	public void deleteById(int studentId)
	{
		StudentDTO student = readByStudentId(studentId);
		
		if(student == null)
		{
			System.out.println("student with the given Id is not present");
			return;
		}

		SessionFactory factory = SingletonFactory.getFactory();
		Session session = factory.openSession();
		
		session.delete(student);
		
		org.hibernate.Transaction tx = session.beginTransaction();
		
		tx.commit();
		session.close();
	}

}

