package pers.lq.set.proj.student;

import java.util.Objects;

/**
 * @author Nil
 */
public class Student{
	private int score;
	private String name;

	public Student() {
	}

	public Student(int score, String name) {
		this.score = score;
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Student)) {
			return false;
		}
		Student student = (Student) o;
		return getScore() == student.getScore() && getName().equals(student.getName());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getScore(), getName());
	}

	@Override
	public String toString() {
		return "Student{" +
				       "score=" + score +
				       ", name='" + name + '\'' +
				       '}';
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
