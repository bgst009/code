package pres.lanqiao.animal;

/**
 * @author Nil
 */
public class Cat extends Pet {
	public Cat(String kind) {
		super(kind);
	}

	@Override
	public String bark() {
		return super.bark() + "喵喵~~~";
	}
	public void catchMouse(){
		System.out.println(getName() + "在捉老鼠");
	}

}
