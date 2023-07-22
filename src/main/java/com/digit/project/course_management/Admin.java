package com.digit.project.course_management;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Admin {
	Scanner sc = new Scanner(System.in);

	static ArrayList<Course> courses = new ArrayList<>();
	static ArrayList<Professor> professors = new ArrayList<Professor>();
	static ArrayList<Student> students = new ArrayList<Student>();
	static HashMap<Integer, Course> mappingCoursesId = new HashMap<>();
	static HashMap<Integer, Professor> mappingProfessor = new HashMap<>();
	static HashMap<String, String> mappingStudentsLog = new HashMap<>();

	static String user_name = "dibya34";
	static String password = "dibya@2023";

	// register admin
	public boolean admin(String user_name, String pass) {
		if (user_name.equals(this.user_name) && pass.equals(password)) {

			return true;
		} else {
			return false;
		}

	}

	// adding the courses
	public void addCourse() {
		System.out.println("How Many Number of course You want to Introduce ??");
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			sc.nextLine();
			System.out.println("Course No - " + (i + 1));
			System.out.println("Enter the Course Name : ");
			String name = sc.nextLine();
			System.out.println("Enter the course ID : ");
			int id = sc.nextInt();
			System.out.println("Enter the course Duration : ");
			float duration = sc.nextFloat();
			// creating a course
			Course c = new Course(name, id, duration);

			// adding course in course list
			courses.add(c);

			// mapping each course with there id
			mappingCoursesId.put(id, c);
			System.out.println("\nAdded...\n");
		}
	}

	// adding professors
	public void addProfessor() {
		System.out.println("Hire " + courses.size() + " Professors for " + courses.size() + " Courses. ");
		ArrayList<Course> arr = new ArrayList<Course>(courses);
		System.out.println("--------------------------------------");

		sc.nextLine();
		for (int i = 0; i < courses.size(); i++) {
			System.out.println("Hiring  Professor No - " + (i + 1) + "\n");
			System.out.println("Enter The Professor Name : ");
			String name = sc.nextLine();

			System.out.println("\nAvialable courses : \n");
			System.out.println("ID-->Name");
			System.out.println("----------");
			for (int j = 0; j < arr.size(); j++) {

				System.out.println(arr.get(j).course_id + "-->" + arr.get(j).name);
			}

			System.out.println("Enter the Course Id which the Professor will teach : ");
			int num = sc.nextInt();

			// removing the course which is allocated to professor .
			for (int j = 0; j < arr.size(); j++) {
				if (arr.get(j).course_id == num) {

					arr.remove(j);

				}

			}

			Professor p = new Professor(name, num);
			professors.add(p);

			mappingProfessor.put(num, p);

			System.out.println("\nAdded...\n");
			sc.nextLine();

		}

	}

	// adding the students
	public void addStudent() {
		System.out.println("Enter how many Students are there for Admission : ");
		int num = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < num; i++) {
			System.out.println("\nStudent No - " + (i + 1));
			System.out.println("Enter The User_Name of the Student : ");
			String name = sc.nextLine();
			System.out.println("Enter the password for the Student :");
			String pass = sc.next();

			// storing the students id and password
			mappingStudentsLog.put(name, pass);

			System.out.println("\nWhich course The Student will enroll into : ");
			System.out.println("Avialable Courses : ");
			System.out.println("ID-->Name");
			System.out.println("----------");
			for (int j = 0; j < courses.size(); j++) {

				System.out.println(courses.get(j).course_id + "-->" + courses.get(j).name);
			}
			System.out.println("\nEnter The Course Id : ");
			int id = sc.nextInt();

			Student s = new Student(name, pass, id);
			// adding each student in student list
			students.add(s);
			sc.nextLine();
		}

	}

	// professor will grade the students
	public void grade() {
		for (int i = 0; i < students.size(); i++) {
			System.out.println("Now Grading for student No - " + (i + 1));
			Professor p = mappingProfessor.get(students.get(i).course_id);

			System.out.println("Enter the Assignment Mark :");
			int assign = sc.nextInt();

			System.out.println("Enter the Quizze Mark :");
			int quizz = sc.nextInt();

			System.out.println("Enter the Project Mark :");
			int proj = sc.nextInt();

			System.out.println("Enter the Mid_Term Exam Mark :");
			int mid = sc.nextInt();

			System.out.println("Enter the Final_Exam Mark :");
			int finl = sc.nextInt();

			System.out.println("\nProfessor- '" + p.name + "' is Now Grading the student- '" + students.get(i).user_name
					+ "' From The '" + mappingCoursesId.get(students.get(i).course_id).name + "' Batch. \n");

			Main.sleep(3000);

			students.get(i).Assignments = assign;
			students.get(i).Quizzes = quizz;
			students.get(i).Projects = proj;
			students.get(i).Midterm_Exam = mid;
			students.get(i).Final_Exam = finl;

			// Calculating Grade
			if (students.get(i).Final_Exam >= 85) {
				students.get(i).grade = "O";
			} else if (students.get(i).Final_Exam >= 75) {
				students.get(i).grade = "E";
			} else if (students.get(i).Final_Exam >= 65) {
				students.get(i).grade = "A";
			} else if (students.get(i).Final_Exam >= 55) {
				students.get(i).grade = "B";
			} else if (students.get(i).Final_Exam >= 45) {
				students.get(i).grade = "C";
			} else if (students.get(i).Final_Exam >= 35) {
				students.get(i).grade = "D";
			} else {
				students.get(i).grade = "F";
			}

			System.out.println("Mark added for : " + students.get(i).user_name + "\n");
		}
	}

	// checking the mark by providing the user name and password of the student
	public void checkMark(String user_name, String pass) {

		Main.sleep(3000);
		;

		for (int i = 0; i < students.size(); i++) {

			if (user_name.equals(students.get(i).user_name) && pass.equals(students.get(i).password)) {
				System.out.println(
						"Overall Grade of '" + students.get(i).user_name + "' is : '" + students.get(i).grade + "'");

				System.out.println("\nWant to see Full MarkSheets (Y/N) ");
				String ans = sc.next();
				if (ans.toLowerCase().equals("y")) {
					System.out.println("------------------------------------------------------\r\n"
							+ "|                    MARK SHEET                       |\r\n"
							+ "|                                                    |\r\n" + "| Student Name: "
							+ students.get(i).user_name + "                          |\r\n" + "| Student ID: "
							+ students.get(i).course_id + "                              |\r\n" + "| Course: "
							+ mappingCoursesId.get(students.get(i).course_id).name + "                           |\r\n"
							+ "| Academic Period: January 2023 - June 2023         |\r\n"
							+ "|                                                    |\r\n"
							+ "|----------------------------------------------------|\r\n"
							+ "| Grading Components         |    Scores             |\r\n"
							+ "|----------------------------|-----------------------|\r\n"
							+ "| Assignments                |        " + students.get(i).Assignments
							+ "/100         |\r\n" + "| Quizzes                    |        " + students.get(i).Quizzes
							+ "/100         |\r\n" + "| Projects                   |        " + students.get(i).Projects
							+ "/100         |\r\n" + "| Midterm Exam               |        "
							+ students.get(i).Midterm_Exam + "/100         |\r\n"
							+ "| Final Exam                 |        " + students.get(i).Final_Exam
							+ "/100         |\r\n" + "|----------------------------|-----------------------|\r\n"
							+ "| Overall Grade: " + students.get(i).grade + "                                  |\r\n"
							+ "|                                                    |\r\n"

							+ "|                                                    |\r\n"
							+ "| Signature: _______                   |\r\n"
							+ "|                                                    |\r\n"
							+ "| Seal: [Institute's Official Seal]                  |\r\n"
							+ "|                                                    |\r\n"
							+ "------------------------------------------------------");
				}

				return;

			}
		}

		System.err.println("\nInvalid....");
	}

	// all the passwords and user_name of students
	public void allPasswords(String u_name, String pass) {
		sc.nextLine();

		if (u_name.equals(user_name) && pass.equals(password)) {
			System.out.println(" \n- All the Students userName and password -  ");
			for (int i = 0; i < students.size(); i++) {
				Main.sleep(2000);
				System.out.println("\nName     : " + students.get(i).user_name);
				System.out.println("user_name : " + students.get(i).user_name);
				System.out.println("password  : " + students.get(i).password);
				System.out.println("\n");
			}

			System.out.println("\n\n\tPress any Key... ");
			String str = sc.nextLine();
			if (!str.isEmpty() || str.isBlank()) {
				return;
			}

		} else {
			System.err.println("Invalid...");
		}

	}

}
