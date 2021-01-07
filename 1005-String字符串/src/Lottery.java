import java.util.Random;
import java.util.Scanner;

/**
 * @author Nil
 */
public class Lottery {
	static Lottery lottery = new Lottery();
	String password, username, vipId;
	boolean loginFlag = false;
	int chance=3;

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
			if(chance==0){
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
		vipId = "1";
		System.out.println("用户名  密码  会员卡号");
		System.out.println(username + " " + password + " " + vipId);
	}

	public void login() {


		String tempUser, tempPassword;
		System.out.print("请输入用户名：");
		tempUser = new Scanner(System.in).next();
		System.out.print("请输入密码：");
		tempPassword = new Scanner(System.in).next();

		if (tempUser.equals(username) && tempPassword.equals(password)) {
			System.out.println("登录成功");
			loginFlag = true;
		} else {
			loginFlag = false;
			System.out.println("用户名或密码不正确");
			chance--;
			System.out.println("还有 "+chance+" 次机会");
		}

	}

	public void beginLottery() {
		int[] randomArray = new int[5];


		if (loginFlag) {
			System.out.print("本日幸运数字为：");
			for (int i = 0; i < randomArray.length; i++) {
				randomArray[i] = new Random().nextInt(10);
				System.out.print(randomArray[i] + " ");
			}
			System.out.println();

			for (int i = 0; i < randomArray.length; i++) {
				if (Integer.parseInt(vipId) == randomArray[i]) {
					System.out.println("恭喜你为本日的幸运用户");
					break;
				}
				if (i == randomArray.length - 1) {
					System.out.println("抱歉！ 您不是本日的幸运用户");
					break;
				}
			}

		} else {
			System.out.println("请先登录");
			return;
		}
	}
}
