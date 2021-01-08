import java.util.*;

/**
 * @author Nil
 */
public class Lottery {
	static Lottery lottery = new Lottery();

	String[][] usrInfoDate = new String[10][3];

	String password;
	String username;
	String vipId;
	int baseId = 0;
	boolean loginFlag = false;
	int chance = 3;

	public static void main(String[] args) {
		String[] menu = {"*****欢迎进入奖客富翁系统*****", "注册", "登录", "抽奖"};
		lottery.info(menu);
	}

	public void info(String[] menu) {
		String flag;
		do {
			System.out.println(menu[0]);
			for (int i = 1; i < menu.length; i++) {
				System.out.println("     " + i + ":" + menu[i]);
			}
			System.out.println("***************************");
			System.out.print(" 请选择菜单：");
			int n = new Scanner(System.in).nextInt();
			System.out.println("奖客富翁系统> " + menu[n]);

			switch (n) {
				case 1:
					lottery.register();
					break;
				case 2:
					lottery.login();
					break;
				case 3:
					lottery.beginLottery();
					break;
				default:
					break;
			}
			if (chance == 0) {
				System.out.println("退出");
				return;
			}
			System.out.println("继续吗？（y/n）");
			flag = new Scanner(System.in).next();
		} while ("Y".equals(flag) || "y".equals(flag));
	}

	public void register() {
		System.out.println("请填写个人注册信息");
		System.out.print("输入用户名：");
		username = new Scanner(System.in).next();
		System.out.print("输入密码：");
		password = new Scanner(System.in).next();
		System.out.println("注册成功，请记好你的会员卡号");
		vipId = (baseId) + "";
		usrInfoDate[baseId][0] = username;
		usrInfoDate[baseId][1] = password;
		usrInfoDate[baseId][2] = vipId;
		System.out.println("用户名  密码  会员卡号");
		System.out.println(usrInfoDate[baseId][0] + "       " + usrInfoDate[baseId][1] + "         " + usrInfoDate[baseId][2]);
		baseId++;
	}

	public void login() {

		boolean logged = false;

		String tempUser, tempPassword;
		System.out.print("请输入用户名：");
		tempUser = new Scanner(System.in).next();
		System.out.print("请输入密码：");
		tempPassword = new Scanner(System.in).next();


		for (String[] strings : usrInfoDate) {
			if (strings[0] != null) {
				if (strings[0].equals(tempUser) && strings[1].equals(tempPassword)) {
					logged = true;
				}
			}
		}

		if (logged) {
			System.out.println("登录成功");
			loginFlag = true;
			chance=3;
		} else {
			loginFlag = false;
			System.out.println("用户名或密码不正确");
			chance--;
			System.out.println("还有 " + chance + " 次机会");
		}

	}

	public void beginLottery() {
		boolean win = false;
		if (loginFlag) {
			System.out.println("会员码为：" + vipId);

			System.out.print("本日幸运数字为：");

			Set<Integer> numsSet = new HashSet<>();
			int num = 5;
			int range = 10;

			while (numsSet.size() < num) {
				int tmp = new Random().nextInt(range);
				numsSet.add(tmp);
			}


			for (Integer integer : numsSet) {
				System.out.print(integer + " ");
				if (integer == Integer.parseInt(vipId)) {
					win = true;
				}
			}
			System.out.println();

			if (win) {
				System.out.println("恭喜你为本日的幸运用户");
			} else {
				System.out.println("抱歉！ 您不是本日的幸运用户");
			}

		} else {
			System.out.println("请先登录");
		}
	}
}