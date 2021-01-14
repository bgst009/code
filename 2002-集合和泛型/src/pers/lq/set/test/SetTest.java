package pers.lq.set.test;

import pers.lq.set.proj.student.Student;
import pers.lq.set.proj.student.StudentComp;

import java.util.Set;
import java.util.TreeSet;

public class SetTest {
/*	public static void main(String[] args) {
		Set set = new TreeSet();
		set.add(6);
		set.add(3);
		set.add(5);
		set.add(7);
		set.add(2);
		set.add(9);
		for (Object obj : set) {
			System.out.println((int)obj);
		}
	}*/

	public static void main(String[] args) {
		//声明集合时需要定义比较器
		Set set = new TreeSet(new StudentComp());
		set.add(new Student(3,"david"));
		set.add(new Student(1,"tom"));
		set.add(new Student(2,"king"));
		for (Object obj : set) {
			System.out.println((Student)obj);
		}
	}
}
