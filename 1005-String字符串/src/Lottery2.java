import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

/** @author Nil */
public class Lottery2 {
  static String[][] userInfoArray = new String[10][3];

  static int loginId;
  static int chance = 3;
  static int baseId = 0;
  static boolean logged = false;

  public static void main(String[] args) {
    menu();
  }

  public static void menu() {
    String flag;
    do {
      System.out.println("*****欢迎进入奖客富翁系统*****");
      System.out.println("\t 1.注册");
      System.out.println("\t 2.登录");
      System.out.println("\t 3.抽奖");
      System.out.println("\t 4.退出");
      System.out.print(" 请选择菜单：");
      int n = new Scanner(System.in).nextInt();

      switch (n) {
        case 1:
          System.out.println("奖客富翁系统> " + "注册");
          register();
          break;
        case 2:
          System.out.println("奖客富翁系统> " + "登录");
          login();
          break;
        case 3:
          System.out.println("奖客富翁系统> " + "抽奖");
          lottery();
          break;
        case 4:
          System.out.println("奖客富翁系统> " + "退出");
          System.exit(0);
          break;
        default:
          break;
      }

      System.out.println("继续吗？(Y/n)");
      flag = new Scanner(System.in).next();

    } while ("Y".equals(flag) || "y".equals(flag));
  }

  public static void register() {
    String password;
    String username;
    String vipId;
    boolean isEmail=false;

    System.out.println("请填写个人注册信息");


    do{
      System.out.print("输入用户名(邮箱)：");
      username = new Scanner(System.in).next();
      if(Pattern.matches("^(\\w+([-.][A-Za-z0-9]+)*){3,18}@\\w+([-.][A-Za-z0-9]+)*\\.\\w+([-.][A-Za-z0-9]+)*$", username)){
        isEmail=true;
      }

    }while (!isEmail);

    System.out.print("输入密码：");
    password = new Scanner(System.in).next();
    System.out.println("注册成功，请记好你的会员卡号");
    vipId = (baseId) + "";
    userInfoArray[baseId][0] = username;
    userInfoArray[baseId][1] = password;
    userInfoArray[baseId][2] = vipId;
    System.out.println("用户名  密码  会员卡号");
    System.out.println(
        userInfoArray[baseId][0]
            + "\t"
            + userInfoArray[baseId][1]
            + "\t"
            + userInfoArray[baseId][2]);
    baseId++;
  }

  public static void login() {
    String tempUser, tempPassword;
    System.out.print("请输入用户名：");
    tempUser = new Scanner(System.in).next();
    System.out.print("请输入密码：");
    tempPassword = new Scanner(System.in).next();

    int i;
    for (i = 0; i < userInfoArray.length; i++) {
      if (userInfoArray[i][0] != null) {
        if (userInfoArray[i][0].equals(tempUser) && userInfoArray[i][1].equals(tempPassword)) {
          logged = true;
          break;
        }
      }
    }

    if (logged) {
      System.out.println("登录成功");
      chance = 3;
      loginId = i;
    } else {
      System.out.println("用户名或密码不正确");
      chance--;
      if (chance == 0) {
        System.exit(0);
      } else {
        System.out.println("还有 " + chance + " 次机会");
      }
    }
  }

  public static void lottery() {
    boolean win = false;

    if (logged) {
      System.out.println("会员码为：" + loginId);

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
        if (integer == loginId) {
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
