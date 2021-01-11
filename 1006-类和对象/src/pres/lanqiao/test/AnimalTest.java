package pres.lanqiao.test;

import pres.lanqiao.animal.Cat;
import pres.lanqiao.animal.Dog;

public class AnimalTest {
	public static void main(String[] args) {
		Dog dog = new Dog("阿拉斯加");
		dog.setName("狗");
		dog.lookDoor();
		System.out.println(dog.bark());

		Cat cat = new Cat("短毛猫");
		cat.setName("猫");
		cat.catchMouse();
		System.out.println(cat.bark());
	}
}
