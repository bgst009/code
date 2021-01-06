public class ArithmeticOpr {
    public static void main(String[] args) {
        int i1 = 10, i2 = 20;
        int i = (i2++); // ++在i2后，故先运算（赋值）再自增
        System.out.print("i=" + i);
        System.out.println(" i2=" + i2);
        i = (++i2); // ++在i2前，故先自增再运算（赋值）
        System.out.print("i=" + i);
        System.out.println(" i2=" + i2);
        i = (--i1); // --在i1前，故先自减再运算（赋值）
        System.out.print("i=" + i);
        System.out.println(" i1=" + i1);
        i = (i1--); // --在i1后，故先运算（赋值）再自减
        System.out.print("i=" + i);
        System.out.println(" i1=" + i1);
    }
}