package pres.lanqiao.proj.gamer;

import java.util.Scanner;

/**
 * @author Nil
 */
public class PersonGamer extends Gamer {

	//构造函数
	public PersonGamer() {
	}

	public PersonGamer(int winTime) {
		super(winTime);
	}

	public PersonGamer(String name, int winTime) {
		super(name, winTime);
	}
	//方法
	@Override
	public int punch() {
		boolean flag = false;
		int i;
		do {
			i = new Scanner(System.in).nextInt();
			if (i >= 1 && i <= 3) {
				flag = true;
			} else {
				System.out.println("error!!!");
				System.out.println("re-input");
			}
		} while (!flag);
		return i;
	}


}
