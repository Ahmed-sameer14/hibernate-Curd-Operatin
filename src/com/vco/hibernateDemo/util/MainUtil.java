package com.vco.hibernateDemo.util;

import java.util.Scanner;

import com.vco.hibernateDemo.dao.StudentDAO;
import com.vco.hibernateDemo.dto.StudentDTO;

public class MainUtil {

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		StudentDAO dao = new StudentDAO();
		
		System.out.println("welcome to hibernate mainApp");
		System.out.println("-----------------------------------");
		
		while(true)
		{
			System.out.println("Operations available are");
			System.out.println("-------------------------------");
			System.out.println("1.Insert\n2.Read By ID\n3.Update\n4.Delete By ID\n5.Exit");
			System.out.println("Enter Your Choice");
			int choice = sc.nextInt();
			
			switch(choice)
			{
				case 1 : System.out.println("Enter student Id");
			             int studentId = sc.nextInt();
			             System.out.println("Enter student name");
			             String studentname = sc.next();
			             System.out.println("Enter student branch");
			             String studentbranch = sc.next();
			             System.out.println("Enter student marks");
			             double studentmarks= sc.nextDouble();
			             System.out.println("Enter student PhoneNumber");
			             String studentphoneNumber = sc.next();
			             System.out.println("Enter student Addresss");
			             String studentAddress = sc.next();
			             StudentDTO student=new StudentDTO(studentId, studentname, studentbranch, studentmarks, studentphoneNumber, studentAddress);
			             dao.insert(student);
			             break;
			             
				case 2 : System.out.println("Enter the stdent ID to be searched");
				         studentId=sc.nextInt();
				         student=dao.readByStudentId(studentId);
				         System.out.println("Student Info --> "+student);
				         break;
				         
				case 3 : System.out.println("Enter the stuent ID to be updated");
				         studentId=sc.nextInt();
				         student=dao.readByStudentId(studentId);
				         dao.updateById(studentId);
				         break;
				         
				case 4 : System.out.println("Enter the student ID to be Deleted");
				         studentId=sc.nextInt();
				         dao.deleteById(studentId);
				         break;
				         
				case 5 : System.out.println("Thank you........See you Again.......");
				         System.exit(0);
				         
			   default : System.out.println("Wrong input.............Try again.........");
			}
		}


	}

}
