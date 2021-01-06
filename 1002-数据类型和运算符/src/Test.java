public class Test {
    public static void main(String[] args) {
        int a = 1;
        System.out.println(false & a++ == 1);
        // 即使前面为false，右边的表达式还是会继续执行，即num++
        System.out.println(a);// 2

        int b = 1;
        System.out.println(false && b++ == 1);
        // 左边的表达式为false，右边的表达式将不会执行，即num不会自增
        System.out.println(b);// 1
    }
}