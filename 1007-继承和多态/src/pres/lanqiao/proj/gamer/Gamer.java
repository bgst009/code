package pres.lanqiao.proj.gamer;

import java.util.Random;

/**
 * @author Nil
 */
public class Gamer {
	//属性
	private String name;
	private int winTimes;

	//构造函数
	public Gamer() {
	}

	public Gamer(int winTimes) {
		this.winTimes = winTimes;
	}

	public Gamer(String name, int winTimes) {
		this.name = name;
		this.winTimes = winTimes;
	}

	//方法
	public int punch() {
		int min = 1;
		int max = 3;
		return min + (int) (Math.random() * (max - min));
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWinTimes() {
		return winTimes;
	}

	public void setWinTimes(int winTimes) {
		this.winTimes = winTimes;
	}
}
