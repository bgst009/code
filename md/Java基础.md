[TOC]

# Java基础

## 初识Java

- Java发展史
  - 1995年诞生
  - Java1.2开始分三个平台JavaEE、JavaSE、JavaME
  - Java1.5开始了很多新特性，自动装箱、泛型、反射、增强for等。
  - Java1.7对switch支持字符串
  - Java1.8加入Lambda表达式（我们使用的版本）
- Java工作原理
  ![图片描述](https://gitee.com/bgst009/markdownPicUrl/raw/master/20210105191014.png)
- ![image-20210109152033214](C:/Users/Nil/AppData/Roaming/Typora/typora-user-images/image-20210109152033214.png)
- Java环境介绍
  - 可以分为开发环境JDK和运行环境JRE
  - JDK=JRE+API和开发工具
  - 开发使用JDK
  - JDK8下载地址**【注意系统版本】** [官网下载](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html) [本地下载](https://www.lanqiao.cn/courses/3376/learning/?id=73870)

![图片描述](https://gitee.com/bgst009/markdownPicUrl/raw/master/20210105191009.png)

- JDK环境配置

  | **变量名** | **说明**                                                     |
  | ---------- | ------------------------------------------------------------ |
  | JAVA_HOME  | JDK安装路径，如：C:\jdk1.8                                   |
  | PATH       | Windows系统执行命令要搜索的路径,如：%JAVA_HOME%\bin;（放在最前面） |
  | CLASSPATH  | 编译和运行要找的class路径,如：.;%JAVA_HOME%\lib（其中.代表当前路径） |

  **注意：Win10以前系统不要删除原有的path，而是在原有path值之前添加**。如下所示：

  ```
  %JAVA_HOME%\bin;\*************
  ```

  测试是否配置成功：win+R弹出运行窗口，输入cmd进入DOS命令，然后输入：

  ```
  java -version
  ```

  ![图片描述](https://gitee.com/bgst009/markdownPicUrl/raw/master/20210105191001.png)

- 第一个Java程序：Hello World！

## 数据类型和运算符

###  知识要点

本章开始学习Java的语法。首先学习最基础的变量、数据类型和表达式。主要包括以下知识点：

- 标识符和关键字
- 变量和常量
- Java数据类型
- 成员变量和局部变量
- Java运算符
- Java表达式



### 授课笔记

- 标识符和关键字

  - 标识符：在Java中需要用户自定义的符号称之为标识符。标识符由字母、数字、_、$组成，其中首字符不能是数字，不能为java关键字，标识符无长度限制，并且大小写敏感。
  - 标识符包括以下分类：
    - 变量和方法：第一个单词小写字母开头，后面单词首字母大写（骆驼命名）
    - 类名：第一个单词也大写，单词缩写需每个单词都大写
    - 包：都小写
    - 常量：都大写，且指出该常量完整的意义
  - 关键字：Java的保留字符，每个字符都有特定的含义，字母都小写。例如：public等

- 变量和常量

  - 变量：在程序运行时值可变的标识符。在内存中是一段有名字的连续存储空间 type varName[=value];
  - 常量：在程序运行时值不可以改变的标识符。使用final关键字，声明时必须初始化，不能重新赋值 final int STU_AGE=22;

- Java数据类型：

  - 基本数据类型

    - 数值型

      - 整数类型(byte,short,int,long）

      - 浮点类型(float,double)

        ```java
        long l = 9999999999999L; // 整形 int ， 浮点型 double
        long l1 = 999;
        float f = 3.14F;
        double d = 3.14;
        ```

    - 字符型(char) ：两个字节存储单个字符，\t \n(换行符) \r(回车符) \b

    - 布尔型(boolean)：值为true和false，不能是0和1。

  - 引用数据类型

    - 类(Class）
    - 接口(Interface）
    - 数组(Array）
    - 等...

- Java数据类型转换 ![图片描述](https://gitee.com/bgst009/markdownPicUrl/raw/master/20210106100656.png)

- 成员变量和局部变量

  - 成员变量：类中方法外的变量，也称全局变量。系统会赋默认值。
  - 局部变量：方法中的变量，声明时最好赋初始值否则开发时可能会出错误。

- Java运算符

  - 算术运算符：+， -，*， \，%， ++， --
  - 关系运算符：>，<，>=，<=，==，!=
  - 赋值运算符： =，+=，-=，*=，/=
  - 逻辑运算符：!，&&，||
  - 位运算符： ~ ，&，|，^，>>，<<，>>>

- Java表达式

  - 可以分为开发环境JDK和运行环境JRE
  - 表达式优先级

![图片描述](https://gitee.com/bgst009/markdownPicUrl/raw/master/20210106100639.png)



## String

### 知识要点

方法和数组作为Java学习过程中的第一个难点，需要大家细心并耐心的理解他们的使用场景和语法特点。

- String类
- String类的内存模型
- String类常用方法
- StringBuffer和StringBuilder
- Date对象和字符串

- String类

  - String 类代表字符串。
  - String 类不是基本数据类型，它是一个引用类型。默认值是null。特殊：不需要用new。

  ```java
  String str = new String("david");//引用类型 Scanner input = new Scanner(System.in);
  String str = "david";
  ```

  - String 字符串是常量，字符串的值在创建之后不能更改。**内存模型**

  ```java
  public static void main(String[] args) {
          String str = new String("david");
          str = "tom";
          System.out.println(str);
  }
  ```

![图片描述](https://gitee.com/bgst009/markdownPicUrl/raw/master/20210113082825.png)

- String 类是最终类，不能被继承。
- String类的内存模型
  - Java中，`==`比较的是栈里的值。equals()比较堆里的值。
  - `String str = “str”` 优化内存。**常量池**

![图片描述](https://gitee.com/bgst009/markdownPicUrl/raw/master/20210113082822.png)

- String类常用方法

  - charAt() 截取一个字符
  - length() 字符串的长度
  - getBytes() 将字符串变成一个byte数组
  - equals() 和 equalsIgnoreCase() 比较两个字符串是否相等，前者区分大小写，后者不区分
  - startsWith() 和 endsWith() 判断字符串是不是以特定的字符开头或结束
  - concat() 连接两个字符串 `+`
  - substring() 截取字符串【包前不包后】
  - indexOf() 和lastIndexOf() 前者是查找字符或字符串第一次出现的下标，后者是查找字符或字符串最后一次出现的地方
  - compareTo() 和compareToIgnoreCase() 按字典顺序比较两个字符串的大小，前者区分大小写，后者不区分
  - replace() 替换指定字符
  - split() 按指定字符切割

- StringBuffer和StringBuilder

  - 场景：因为String是常量，每次修改其值都需要重新在堆内存中开辟新空间。这样再频繁对变量进行赋值操作时就会导致内存浪费。所以再需要频繁对变量值进行修改的时候，可以使用StringBuffer和StringBuilder

  ![图片描述](https://gitee.com/bgst009/markdownPicUrl/raw/master/20210113082818.png)

  - 方法：
    - append() 在原字符串后拼接字符
    - insert() 在原字符串前拼接自发
    - toString() 转化成字符串
    - reverse() 反转字符
  - 区别：
    - StringBuffer线程安全
    - StringBuilder非线程安全

- Date类

  - Date类在java.util.Date中。是进行日期操作的类。[Date类API](https://www.runoob.com/java/java-date-time.html)

  ```java
  Date now = new Date();//获得当前时间
  Date now = new Date(long millisec)//参数是从1970年1月1日起的毫秒数
  ```

  - 使用SimpleDateFormat类对日期类型进行格式化，形成字符串。

  ```java
  public static void main(String[] args) {
     Date now = new Date(); // 创建一个Date对象，获取当前时间
     // 指定格式化格式
     SimpleDateFormat f = new SimpleDateFormat("yyyy年MM月dd日 HH点mm分ss秒");
     System.out.println(f.format(now)); // 将当前时间袼式化为指定的格式
  }
  ```

![image-20210107094324013](https://gitee.com/bgst009/markdownPicUrl/raw/master/20210107094324.png)

![image-20210107104613904](https://gitee.com/bgst009/markdownPicUrl/raw/master/20210107104614.png)

## 数组和方法

- 开关
  - for 中 有 if…else -> for 中用 Boolean

### 知识要点

方法和数组作为Java学习过程中的第一个难点，需要大家细心并耐心的理解他们的使用场景和语法特点。

- 方法的含义
- 方法三要素
- 值传递和引用传递
- 数组的含义
- 一维数组
- 二维数组



- 方法的含义

  - 方法是用来进行代码优化的一种方式。
  - 可以将一段由多个逻辑组成的复杂代码，拆分成具有单一多集的多个代码块。
  - 每个代码块就是一个方法，方法可以被多次调用。

- 方法三要素

  - 方法名：方法的名称，用来描述方法的功能。通常使用动词描述，见名知意。
  - 参数：方法被调用的先决条件，参数准备好后方法才能被调用。可以为空。
  - 返回值：方法被调用后返回给调用方的结果。使用return返回该结果。可以没有返回值，使用void声明。

  ```java
  //有参数和返回值的方法
  public int add(int num1,int num2){
    return num1 + num2;
  }
  //无参数和返回值的方法
  public void menu(){
      System.out.println("欢迎使用系统")；
      System.out.println("1、注册")；
      System.out.println("2、登录")；
      System.out.println("3、退出")；
  }
  ```

- 值传递和引用传递

  - 形参和实参
  - 基本类型时值传递
  - 引用类型时引用传递
  - **本质：内存栈中的值的拷贝**

  ```java
  import java.util.Scanner;
  
  public class Test {
      public static void main(String[] args) {
          int i = 10;
          change(i);
          System.out.println(i);
          String str = "a";
          change(str);
          System.out.println(str);
          StringBuffer sb = new StringBuffer("a");
          change(sb);
          System.out.println(sb);
          int[] nums = new int[5];
          change(nums);
          System.out.println(nums[0]);
  
      }
      public static void change(int i){
          i+=100;
      }
      public static void change(String str){
          str += "b";
      }
      public static void change(StringBuffer sb){
          sb.append("b");
      }
      public static void change(int[] nums){
          nums[0] = 10;
      }
  }
  ```

![图片描述](https://gitee.com/bgst009/markdownPicUrl/raw/master/20210113083032.png)

- 数组的含义

  - 使用数组可以使用一个变量存放大量相同的数据，这样可以节省变量的声明个数。
  - 数组在内存中开辟连续的空间来存放数据。
  - 数组使用下标来定位数据，例如：names[2] = "david"。

- 一维数组

  - 数组定义：

    - 数据类型 标识符[ ] = new 数据类型[大小]；

      ```java
      int[] nums = new int[5];
      ```

    - 数据类型 标识符 [ ] = {值 1，值 2，…值 N} ；

      ```java
      int[] nums = {1,2,3,4,5}
      ```

  - 数组的使用：

    - 声明数组
    - 分配空间
    - 元素赋值
    - 取值，处理数据

  - 数组的存储：

![图片描述](https://gitee.com/bgst009/markdownPicUrl/raw/master/20210113083038.png)

![图片描述](https://gitee.com/bgst009/markdownPicUrl/raw/master/20210113083042.png)

- 数组一般都是使用for来操作。
- 二维数组
  - 本质是一维数组中存入另一个一维数组。
  - int stuScore = new int[5][3]; -- 五个学生的三门课程。
  - 也可以这样声明：int stuScore = new int[5][]; --只声明一维。
  - 二维数组使用双重for循环操作。

## 类和对象

### 知识要点

- 面向过程和面向对象
- 类和对象的概念
- 方法和属性
- 封装
- 构造方法
- this关键字
- 初始化块
- 方法重载



### 授课笔记

- 面向过程和面向对象
  - 面向过程思想 **步骤** -> 流程图
  - 面向对象思想 **四个找** -> 类图
  - 面向对象三大特征/四大特征
    - 继承
    - 封装
    - 多态
    - 抽象
- 类和对象的概念
  - **万物皆对象** - Java
  - 对象都由**特征**和**行为**组成。
  - 具有相同特征和行为的对象**抽象**成**类**
  - 对象是真实存在的；类是概念，不真实存在。
  - 类由属性（特征）和方法（行为）组成
- 方法和属性
  - 方法描述类的行为，命名一般是动词，由方法三要素组成。
  - 属性是类的特征或者组成，特征一般是基本类型或者String，组成一般是另一个类。
  - 属性类里表现的全局变量。
- 类之间的关系
  - 关联：对于两个相对独立的对象，当一个对象的实例与另一个对象的一些特定实例存在固定的对应关系时，这两个对象之间为关联关系。
  - 依赖：对于两个相对独立的对象，当一个对象负责构造另一个对象的实例，或者依赖另一个对象的服务时，这两个对象之间主要体现为依赖关系
  - 聚合：表示一种弱的‘拥有’关系，即has-a的关系，体现的是A对象可以包含B对象，但B对象不是A对象的一部分。 **两个对象具有各自的生命周期**。
  - 组合：组合是一种强的‘拥有’关系，是一种contains-a的关系，体现了严格的部分和整体关系，**部分和整体的生命周期一样**。
  - 实现：实现接口。
  - 泛化：继承关系。

![图片描述](https://gitee.com/bgst009/markdownPicUrl/raw/master/20210111090205.png)

- 封装
  - 作用：提高程序的数据安全性。
  - 操作：属性私有化，提供公共的getter/setter方法访问私有属性。
  - 数据安全：数据校验、数据访问。
- 构造方法
  - 作用：完成属性数据初始化操作。
  - 时间：对象实例化的时候被调用。
  - 存在：若用户不定义，系统会自动生成一个无参的空的构造方法。
  - 特点：1、方法名和类名相同。2、没有返回值类型。
- this&super关键字
  - this 类本身。
  - super 父类。
- 初始化块
  - 作用：将构造方法中具有相同功能的代码抽象成的代码块。
  - 本质：编译后，初始化块中的代码会被copy到构造方法中。初始化块消失。
  - 优点：便于代码维护和扩展。
  - 时间：先于构造方法执行。
  - 属性值：默认值 -> 初始化块值 -> 构造方法值 -> setter方法
- 方法重载
  - 同一个类中，方法名相同，参数不同（个数不同|类型不同|顺序不同），返回类型和权限无关的方法。
- 类的组成
  - 属性（成员变量）
  - 初始化块
  - 构造方法
  - 成员方法
  - getter&setter方法



## 包和对象

#### 知识要点

- 包的概念
- 包的作用
- package和import
- 权限修饰符
- static
- 单例模式



- 包的概念

  - 包的本质就是一系列嵌套的文件夹。
  - 在程序中的体现：org.lanqiao.pet.entity （公司域名的反写+项目+功能，全部小写。）

- 包的作用

  - 整理代码
  - 区分同名类
  - 进行权限控制

- 常见用包

  - java.util 工具类 （java.util.Scanner）
  - java.io io操作
  - java.net 网络开发
  - java.lang **默认包** java.lang.String / java.lang.Math

- 包的关键字

  - package : 描述当前类所处的包的名称。
  - import ：引入其他包中的类。本包中的类不需要引用。

- 权限修饰符

  Java 中一共有四种访问权限控制，其权限控制的大小情况是这样的：public > protected > default(包访问权限) > private ,具体的权限控制看下面表格，列所指定的类是否有权限允许访问行的权限控制下的内容：

| 访问权限  | 同类 | 同包的类 | 子类 | 非子类的外包类 |
| --------- | ---- | -------- | ---- | -------------- |
| public    | 是   | 是       | 是   | 是             |
| protected | 是   | 是       | 是   | 否             |
| default   | 是   | 是       | 否   | 否             |
| private   | 是   | 否       | 否   | 否             |

- static静态
  - 属性 -> 类属性
  - 方法 -> 类方法
  - 块 -> 静态块：静态属性初始化操作。
  - 工具类 | 单例模式
  - 调用时机：类加载的时候，初始化类属性和类方法。

![图片描述](https://gitee.com/bgst009/markdownPicUrl/raw/master/20210113082056.png)

- 单例模式有以下特点：

  　1. 单例类只能有一个实例。 　2. 单例类必须自己创建自己的唯一实例。 　3. 单例类必须给所有其他对象提供这一实例。

  ```
   单例模式确保某个类只有一个实例，而且自行实例化并向整个系统提供这个实例。在计算机系统中，线程池、缓存、日志对象、对话框、打印机、显卡的驱动程序对象常被设计成单例。这些应用都或多或少具有资源管理器的功能。单例模式可以分为懒汉式和饿汉式等多种形式。
  ```

  - 饿汉式：不论是否需要都创建对象。

    - 饿汉式在类创建的同时就已经创建好一个静态的对象供系统使用，以后不再改变，所以天生是线程安全的。

      ```java
      //饿汉式单例类.在类初始化时，已经自行实例化 
      public class Singleton {
          private Singleton() {}
          private static Singleton single = new Singleton();
          //静态工厂方法 
          public static Singleton getInstance() {
              return single;
          }
      }
      ```

  - 懒汉式：需要时创建，不需要不创建。

    - 线程不安全

      ```java
      //懒汉式单例类.在第一次调用的时候实例化自己 
      public class Singleton {
          private Singleton() {}
          private static Singleton single = null;
          //静态工厂方法 
          public static Singleton getInstance() {
               if (single == null) {  
                   single = new Singleton();
               }  
              return single;
          }
      }
      ```

      

## 继承与多态

### 知识要点

- 抽象
- 封装回顾
- 继承
- 多态



- 封装回顾
  - 概念：属性私有化（private），提供公共（public）setter&getter方法访问私有属性。
  - 目的：提高数据的安全性。（额外进行控制）
- 抽象
  - 前提：具有相同属性和方法。
  - 场景：对象 -> 类 、类 -> 父类
- 继承
  - 父类：类抽象的到父类，必须满足is-a关系。

![图片描述](https://gitee.com/bgst009/markdownPicUrl/raw/master/20210113082422.png)

- 都是类（class），父类更抽象、子类更具体。
- 继承：将相同的属性和方法抽象到父类中，子类继承(extends)父类，子类就可以继承父类中public+protected类型的的属性和方法。
- 继承优点：提高维护性和扩展性。
- **子类会默认调用父类无参数的构造方法。**
- 重写：父子类中，方法名、参数、返回值都相同。权限不能缩小。



## 抽象类和接口

### 知识要点

- 抽象类
- 抽象方法
- 接口
- 面向接口编程
- final关键字



- 抽象类
  - why：为了解决父类不能实例化对象的问题。
  - how：**abstract** class
- 抽象方法
  - why：父类中的一些方法，无法写方法体。
  - how：**abstract** foo();
  - 特点：子类必须重写父类的抽象方法，除非子类也是一个抽象类。
- 接口
  - why：为了解决父类单根性。
  - 特点：一个类只能继承（extends）一个父类，但是可以实现（implement）多个接口。
  - 功能：1、体现类的能力。2、接口定义一种规范和标准。
  - 语法：接口中的属性都是静态常量；接口中的方法都是抽象方法。接口可以多继承。
- 面向接口编程
  1. 定义接口（定义规范和标准）
  2. 各自按照接口进行开发（面向对象的思想）
  3. 模块集成 - 项目
- final
  - 类：最终类，不能被继承。代表是String
  - 属性：常量，不能被修改。
  - 方法：最终方法，不能重写。

# Java高级

## 数据结构

- 数据逻辑结构

![图片描述](https://gitee.com/bgst009/markdownPicUrl/raw/master/lq_%E6%95%B0%E6%8D%AE%E9%80%BB%E8%BE%91%E7%BB%93%E6%9E%84)

- 数据物理结构

  - 顺序存储

    - 优点：循环遍历，节省空间
    - 缺点：增加删除

    ![图片描述](https://gitee.com/bgst009/markdownPicUrl/raw/master/lq_%E9%A1%BA%E5%BA%8F%E5%AD%98%E5%82%A8)

  - 链式存储


- 单向链

![图片描述](https://gitee.com/bgst009/markdownPicUrl/raw/master/lq_%E5%8D%95%E5%90%91%E9%93%BE)

- 双向链

![图片描述](https://gitee.com/bgst009/markdownPicUrl/raw/master/lq_%E5%8F%8C%E5%90%91%E9%93%BE)

- 循环链

![图片描述](https://gitee.com/bgst009/markdownPicUrl/raw/master/lq_%E5%BE%AA%E7%8E%AF%E9%93%BE)


- 散列

- 索引

- 队列和栈

  - 队列：先进先出
  - 栈：后进先出

  ![图片描述](https://gitee.com/bgst009/markdownPicUrl/raw/master/lq_%E9%98%9F%E5%88%97%E5%92%8C%E6%A0%88)

- 查找

  - 二分法查找
    - 条件：有序集合

  ![图片描述](https://gitee.com/bgst009/markdownPicUrl/raw/master/%E4%BA%8C%E5%88%86%E6%B3%95%E6%9F%A5%E6%89%BE)

- 排序

  - 冒泡排序

  ![图片描述](https://gitee.com/bgst009/markdownPicUrl/raw/master/%E5%86%92%E6%B3%A1%E6%8E%92%E5%BA%8F%E5%8A%A8%E7%94%BB)

  - 快速排序

  ![图片描述](https://gitee.com/bgst009/markdownPicUrl/raw/master/%E5%BF%AB%E9%80%9F%E6%8E%92%E5%BA%8F%E5%8A%A8%E7%94%BB)

  ![图片描述](https://gitee.com/bgst009/markdownPicUrl/raw/master/%E5%BF%AB%E9%80%9F%E6%8E%92%E5%BA%8F%E5%88%86%E6%AD%A5)

  - 插入排序

  ![图片描述](https://gitee.com/bgst009/markdownPicUrl/raw/master/%E6%8F%92%E5%85%A5%E6%8E%92%E5%BA%8F)

  - 选择排序

  ![图片描述](https://gitee.com/bgst009/markdownPicUrl/raw/master/%E9%80%89%E6%8B%A9%E6%8E%92%E5%BA%8F)

[十大经典排序](https://www.cnblogs.com/david1216/p/14268106.html)

## 集合与泛型

- 集合的分类

  - Collection

  ![image-20210113145231285](https://gitee.com/bgst009/markdownPicUrl/raw/master/Collection%E5%88%86%E7%B1%BB-image-20210113145231285.png)

  - Map

  ![图片描述](https://doc.shiyanlou.com/courses/uid1322138-20210112-1610449992931)

- - Set接口：无序不重复
  - HashSet：无序不重复
  - TreeSet：有序不重复
  - 如何去重？
    - 首先使用hashcode判定，如果值不等则肯定对象不等，如果值相等则要再使用equals进行比对。

- 迭代器

  ```java
  Iterator it =  hashSet.iterator();
  while(it.hasNext()){
      int i = (int)it.next();
  }
  ```

  一般不使用迭代器进行集合遍历，而使用增强for循环。

- 比较器

  - 当两个对象进行比较的时候，需要定义比较规则。这时候就需要使用比较器。
  - 比较器由两种：内部比较器和外部比较器。

- List接口：有序可重复

  - ArrayList：优点循环遍历，缺点增删。
  - LinkedList：优点增删，缺点循环遍历。
    - 增加了对队列和栈模型的操作优化，例如；addFirst(),addLast(),getFirst()等。

- Map接口

- 工具类

  - 集合
  - 数组

- 自动装箱与拆箱

  - 基本类型如何存入集合？
  - 8个基本类型都有与之对应的封装类。在基本类型存入集合的时候是这样的：

  ```
  int -> Integer -> Object
  ```

  - 在jdk1.5以后由`int -> Integer`的操作由JVM自动进行，就是自动装箱。反之`Integer -> int`拆箱。

- 泛型

  - why：集合对象中存储的都是Object类型的对象，存储时子类可以自动转换为Object。当需要读取数据时则需要强制将Object类型转换成子类，这是不安全的行为。使用泛型可以约束存入数据类型。提高数据安全性。

  - what：

    - 泛型：是一种约束，可以在代码编译阶段对存储于集合的数据进行类型控制。
    - 泛型擦除：泛型是提供给javac编译器使用的，它用于限定集合的输入类型，让编译器在源代码级别上。但编译器编译完带有泛形的java程序后，生成的class文件中将不再带有泛形信息，以此使程序运行效率不受到影响，这个过程称之为“擦除”。

  - where：使用集合时必须使用泛型做数据类型约束，使用泛型后的集合可以使用增强for循环迭代。

  - how：

    - 集合泛型

    ```java
    List<String> strList = new ArrayList<>();
    ```

    - 泛型类
    
      ```java
      /*
          1:把泛型定义在类上
          2:类型变量定义在类上,方法中也可以使用
       */
      public class ObjectTool<T> {
          private T obj;
      
          public T getObj() {
              return obj;
          }
      
          public void setObj(T obj) {
              this.obj = obj;
          }
      
      
      //定义泛型方法..
      public <T> void show(T t) {
        System.out.println(t);
      }
      ```
    
      
