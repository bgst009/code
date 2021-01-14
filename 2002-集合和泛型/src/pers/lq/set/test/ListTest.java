package pers.lq.set.test;

import pers.lq.set.proj.student.Student;
import pers.lq.set.proj.student.StudentComp;

import java.util.LinkedList;

public class ListTest {
	public static void main(String[] args) {
		LinkedList<Student> list = new LinkedList<>();
		list.add(new Student(3,"king"));
		list.add(new Student(1,"david"));
		list.add(new Student(2,"tom"));
		list.add(new Student(3,"king"));
		for (Student student : list) {
			System.out.println(student);
		}
		System.out.println("===================");
		list.sort(new StudentComp());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
