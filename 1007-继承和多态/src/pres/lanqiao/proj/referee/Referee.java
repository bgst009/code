package pres.lanqiao.proj.referee;

import pres.lanqiao.proj.gamer.Gamer;
import pres.lanqiao.proj.gamer.PersonGamer;
import pres.lanqiao.proj.gamer.RobotGamer;

import java.util.Scanner;

/**
 * @author Nil
 */
public class Referee {
	//成员属性
	private Gamer gamer1;
	private Gamer gamer2;

	//构造方法
	public Referee() {
	}

	public Referee(Gamer gamer1, Gamer gamer2) {
		this.setGamer1(gamer1);
		this.setGamer2(gamer2);
	}

	/**
	 * 裁判宣布比赛开始
	 */
	private void sayRules() {
		System.out.println("============================");
		System.out.println("******* 猜拳游戏正式开始 ******");
		System.out.println("输入 1-> 剪刀：2-> 石头: 3-->布");
		System.out.println("=============================");
	}

	/**
	 * 裁判获取两个玩家的姓名
	 */
	private void gamerName() {

		if (gamer1 instanceof PersonGamer) {
			System.out.println("玩家一请输入昵称");
			String name = new Scanner(System.in).next();
			gamer1.setName(name);
		}

		if (gamer2 instanceof PersonGamer) {
			System.out.println("玩家一请输入昵称");
			String name = new Scanner(System.in).next();
			gamer2.setName(name);
		}

		System.out.println("我宣布 " + gamer1.getName() + " VS " + gamer2.getName() + "的比赛现在开始");
		System.out.println("=================================");
	}

	/**
	 * 裁判开始猜拳游戏
	 */
	private void playGame() {
		int gamerPunch1, gamerPunch2;
		for (int i = 0; i < 5; i++) {
			if (gamer1 instanceof PersonGamer) {
				System.out.println(gamer1.getName() + "请出拳");
			}
			gamerPunch1 = gamer1.punch();

			if (gamer2 instanceof PersonGamer) {
				System.out.println(gamer2.getName() + "请出拳");
			}
			gamerPunch2 = gamer2.punch();


			System.out.print(gamer1.getName() + " " + humanReadable(gamerPunch1) + "|||");
			System.out.println(gamer2.getName() + " " + humanReadable(gamerPunch2));

			switch (gamerPunch2 - gamerPunch1) {
				case 1:
				case -2:
					gamer2.setWinTimes(gamer2.getWinTimes() + 1);
					System.out.println(gamer2.getName() + " win");
					break;
				case 2:
				case -1:
					gamer1.setWinTimes(gamer1.getWinTimes() + 1);
					System.out.println(gamer1.getName() + " win");
					break;
				default:
					break;
			}

		}
	}

	/**
	 * 裁判判定赢家
	 *
	 * @return 赢家
	 */
	private Gamer whoWin() {
		return gamer1.getWinTimes() > gamer2.getWinTimes() ? gamer1 : gamer2;
	}

	/**
	 * 将输入的整形与对应的字符串匹配返回
	 *
	 * @param i 猜拳游戏中剪刀石头布所对应的整形数据
	 *
	 * @return 整形数据 i 与之匹配的字符串
	 */
	private String humanReadable(int i) {
		switch (i) {
			case 1:
				return "剪刀";
			case 2:
				return "石头";
			case 3:
				return "布";
			default:
				return "error";
		}
	}

	public void letsGame() {
//		Gamer player1 = new PersonGamer(0);
		Gamer player1 = new RobotGamer(0);
		Gamer player2 = new RobotGamer(0);
		Referee referee = new Referee(player1, player2);
		referee.sayRules();
		referee.gamerName();
		referee.playGame();
		System.out.println("======================");
		System.out.println("Winner is " + referee.whoWin().getName());
	}

	public Gamer getGamer1() {
		return gamer1;
	}

	public void setGamer1(Gamer gamer1) {
		if (gamer1 == null) {
			this.gamer1 = new PersonGamer(0);
		} else {
			this.gamer1 = gamer1;
			gamer1.setWinTimes(0);
		}
	}

	public Gamer getGamer2() {
		return gamer2;
	}

	public void setGamer2(Gamer gamer2) {
		if (gamer2 == null) {
			this.gamer2 = new RobotGamer(0);
		} else {
			this.gamer2 = gamer2;
			gamer2.setWinTimes(0);
		}
	}

}
