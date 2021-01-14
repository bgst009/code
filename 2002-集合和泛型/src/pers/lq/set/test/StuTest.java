package pers.lq.set.test;


import pers.lq.set.assignment.Student;

import java.util.ArrayList;
import java.util.Collections;

public class StuTest {
	public static void main(String[] args) {
		ArrayList<Student> studentsArray = new ArrayList<>();
		studentsArray.add(new Student(1, "a"));
		studentsArray.add(new Student(2, "b"));
		studentsArray.add(new Student(3, "c"));
		studentsArray.add(new Student(4, "d"));
		studentsArray.add(new Student(2, "e"));

		for (int i = 0; i < studentsArray.size(); i++) {
			System.out.println(studentsArray.get(i));
		}
		System.out.println("======================");
		Collections.sort(studentsArray);
		for (int i = 0; i < studentsArray.size(); i++) {
			System.out.println(studentsArray.get(i));
		}
	}
}