import java.util.Scanner;

public class assignment{
    public static void main(String[] args) {
    Scanner s1 = new Scanner(System.in);
    Scanner s2 = new Scanner(System.in);
    double args1=s1.nextDouble();
    double args2=s2.nextDouble();

    double sum=0;
    sum=args1+args2;
    System.out.println(sum);
    sum=args1-args2;
    System.out.println(sum);
    sum=args1*args2;
    System.out.println(sum);
    sum=args1/args2;
    System.out.println(sum);

    }
}