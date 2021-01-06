import java.util.Scanner;

/**
 * @author Nil
 */
public class Main {
	static Main m = new Main();
	public static void main(String[] args) {

		m.info();
	}

	public void info(){
		int year,month;
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入年份");
		year = sc.nextInt();
		System.out.println("请输入月份");
		month = sc.nextInt();

		while (year!=-1||month!=-1) {
			m.printCalendar(numberOfWeek(daysToNn(year, month)), year, month);
			System.out.println();
			System.out.println("请输入年份");
			year = sc.nextInt();
			System.out.println("请输入月份");
			month = sc.nextInt();
		}
		sc.close();
	}

	public boolean checkLeapYear(int year){
		if((year%4==0 && year%100!=0)||(year%400==0)) {
			return true;
		} else {
			return false;
		}
	}

	public int days(int year,int month){
		switch (month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				return 31;
			case 2:
				if(m.checkLeapYear(year)){
					return 29;
				}else {
					return 28;
				}
			case 4:
			case 6:
			case 9:
			case 11:
				return 30;

			default:
				return 0;
		}
	}

	public int daysToNn(int year,int month){
		int days=0;
		for(int i=1900;i<year;i++){
			if(m.checkLeapYear(i)){
				days+=366;
			}else {
				days+=365;
			}
		}
		for(int i=1;i<month;i++){
			days+=m.days(year,i);
		}
		return  days;
	}

	public int numberOfWeek(int days){
		return days%7;
	}

	public void printCalendar(int nw,int year,int month){
		String[] week = {"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};

		for(int i=0;i<7;i++){
			System.out.print(week[i]+"  ");
		}

		System.out.println();

		for(int i=0;i<=nw;i++){
			System.out.print("       ");
		}

		for (int i=1;i<=days(year,month);i++){
			if(i>=10){
				System.out.print(String.valueOf(i)+"     ");
			}else {
				System.out.print(String.valueOf(i)+"      ");
			}
			if((i+nw+1)%7==0){
				System.out.println();
			}
		}
	}
}
