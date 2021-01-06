1. 在控制台输出你好某某，例如：“Hello David！”


```
public class hello{
    public static void main(String[] args){
        System.out.println("Hello David!");
    }
}
```


2. 思考如何从控制台输入用户名David，然后再输出“Hello David！”

> 提示：使用Scanner对象接受控制台数据


```
import java.util.Scanner;

public class hello{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        if(scan.hasNext()){
            String name=scan.next();
            System.out.println("Hello "+name+"!");
        }
        scan.close();
    }
}
```