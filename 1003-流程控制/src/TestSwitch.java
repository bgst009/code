public class TestSwitch {
    public static void main(String[] args) {
        int num = 1;
        switch (num) {
        case 1:
        case 2:
            System.out.println("恭喜你，获得了三亚七日游");
            break;
        case 3:
        case 4:
            System.out.println("恭喜你，获得了一辆奔驰");
            break;
        default:
            System.out.println("很遗憾，下次再来");
        }
    }
}