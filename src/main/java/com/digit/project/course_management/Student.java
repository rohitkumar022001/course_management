package com.digit.project.course_management;

public class Student {
	String user_name;
	String password;
	int course_id;
	String grade;
	int Assignments;
	int Quizzes;
	int Projects;
	int Midterm_Exam;
	int Final_Exam;

	public Student(String user_name, String password, int course_id) {
		this.user_name = user_name;
		this.password = password;
		this.course_id = course_id;
	}
}
