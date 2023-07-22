package com.digit.project.course_management;

import java.util.Scanner;

public class Main {

	// waiting time
	public static void sleep(int val) {
		try {
			System.out.println("Please Wait....\n");
			Thread.sleep(val);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void adminDuty() {
		Admin ad = new Admin();
		System.out.println("\n\t\tAdd Courses\n");
		System.out.println("****************************************\n");
		ad.addCourse();
		System.out.println("\n\t\tCourse Added...");
		System.out.println("\n****************************************\n");

		System.out.println("\n\t\tAdd Professors\n");
		System.out.println("****************************************\n");
		ad.addProfessor();
		System.out.println("\n\t\tProfessors Added...");
		System.out.println("\n****************************************\n");

		System.out.println("\n\t\tAdd Students\n");
		System.out.println("****************************************\n");
		ad.addStudent();
		System.out.println("\n\t\tStudents Added...");
		System.out.println("\n***********************************************\n");

		System.out.println("\n*********************ALL SET*******************\n");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n********************************\n");
		System.out.println("\nWELCOME TO OUR ORGANISATION\n");
		System.out.println("\n********************************\n");

		// Setting up the admin window
		Admin ad = new Admin();
		System.out.println("You Need Login To Admin Page .\n");
		while (true) {
			System.out.println("Enter UserName: ");
			String user = sc.next();
			System.out.println("Enter Password: ");
			String pass = sc.next();

			sleep(3000);

			if ((ad.admin(user, pass))) {
				System.out.println("Login Successful...\n");
				System.out.println("------------------------------------");
				adminDuty();
				break;
			} else {
				System.err.println("\nInvalid...");
			}

		}

		System.out.println("\n-Grade The Students-(Done by Professors)\n");
		ad.grade();
		System.out.println("\nGrading Finished...");
		System.out.println("**********************************");

		while (true) {
			System.out.println("\nOperations Avialble - \n");
			System.out.println(
					"1. Check Marks Of students \n" + "2. Manage Passwords of Students (Only By Admin)" + "\n3. Exit");
			System.out.println("\nEnter Your Option - ");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Enter User_name of the Student : ");
				String us = sc.next();
				System.out.println("Enter password of the Student : ");
				String pass = sc.next();
				ad.checkMark(us, pass);
				break;
			case 2:
				System.out.println("Enter User_name of the Admin : ");
				String uss = sc.next();
				System.out.println("Enter password of the Admin : ");
				String passs = sc.next();
				ad.allPasswords(uss, passs);
				break;
			case 3:
				System.exit(0);
				break;
			default:
				System.out.println("\t\tThank You....");
				break;
			}
		}

	}

}
