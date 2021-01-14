package pers.lq.set.assignment;

/**
 * @author Nil
 */
public class Student implements Comparable<Student> {
	private int Score;
	private String stuName;

	public Student(final int score, final String stuName) {
		this.Score = score;
		this.stuName = stuName;
	}

	@Override
	public int compareTo(Student student) {
		if(this.getScore()==student.getScore()){
			return student.getStuName().compareTo(this.getStuName());
		}
		return this.getScore() - student.getScore();
	}

	@Override
	public String toString() {
		return "Student [stuName=" + stuName + ", stuNo=" + Score + "]";
	}

	public int getScore() {
		return Score;
	}

	public void setScore(int score) {
		this.Score = score;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

}