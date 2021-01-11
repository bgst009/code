package pres.lanqiao.animal;

public class Dog extends Pet {
	public Dog(String kind) {
		super(kind);
	}

	@Override
	public String bark() {
		return super.bark() + "汪汪~~~~";
	}

	public void lookDoor(){
		System.out.println(getName() + "在看门");
	}
}
