package pres.lanqiao.master;

import pres.lanqiao.animal.Cat;
import pres.lanqiao.animal.Dog;

public class Master {
	public static void main(String[] args) {
		Dog dog = new Dog("金毛");
		dog.setName("旺财");
		dog.eat("骨头");
		dog.lookDoor();
		System.out.println(dog.bark());

		Cat cat = new Cat("波斯");
		cat.setName("咪咪");
		cat.eat("鱼");
		cat.catchMouse();
		System.out.println(cat.bark());
	}
}
