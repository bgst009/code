package pres.lanqiao.proj.gamer;

import java.util.Random;

/**
 * @author Nil
 */
public class RobotGamer extends Gamer {

	public RobotGamer() {
	}

	public RobotGamer(int winTimes) {
		super(winTimes);
		this.setName(getRandomName());
	}

	private String getRandomName() {
		String[] nameArray = new String[]{"Nil", "Zs", "Aim"};
		int randomNumber = new Random().nextInt(2);
		return nameArray[randomNumber];
	}
}
