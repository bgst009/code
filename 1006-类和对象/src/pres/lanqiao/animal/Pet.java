package pres.lanqiao.animal;

/**
 * @author Nil
 */
public class Pet {
	private String name;
	private int age;
	private String sex;
	private String kind;

	//初始化块
	{
		this.name = "未知";
	}

	//构造方法（方法重载）
	public Pet(String kind) {
		this.kind = kind;
	}

	public Pet(int age, String kind) {
		this.age = age;
		this.kind = kind;
	}

	public Pet(int age, String sex, String kind) {
		this.age = age;
		this.sex = sex;
		this.kind = kind;
	}

	public Pet(String name, String kind) {
		this.name = name;
		this.kind = kind;
	}

	//成员方法
	public void eat(String food){
		System.out.println(name + "在吃" + food);
	}

	public void sleep(){
		System.out.println(name + "在睡觉");
	}

	public String bark(){
		return getName()+"在叫 ";
	}



	//getter&setter方法
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if(age >= 20 || age < 0){
			System.out.println("数据错误！");
		}else{
			this.age = age;
		}
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getKind() {
		return kind;
	}
}

