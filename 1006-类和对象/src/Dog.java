/** @author Nil */
class Dog {
  private String name;
  private int age;
  private String kind;
  private String sex;

  public Dog(String name, int age, String kind, String sex) {
    this.name = name;
    this.age = age;
    this.kind = kind;
    this.sex = sex;
  }

  void eat(String foodName) {
    System.out.println("eat " + foodName);
  }

  void sleep() {
    System.out.println("sleep");
  }

  void bark() {
    System.out.println("bark");
  }

  void ward() {
    System.out.println("ward");
  }

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
    this.age = age;
  }

  public String getKind() {
    return kind;
  }

  public void setKind(String kind) {
    this.kind = kind;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public static void main(String[] args) {
    Dog dog = new Dog("a", 10, "ni", "s");
    dog.bark();
    dog.eat("d");
  }
}
