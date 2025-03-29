package coddy.testjava;
interface Animals {
	void makeSound(); // Abstract method
}
class Dog implements Animals {
	public void makeSound() {
		System.out.println("Dog barks");
	}
}
public class Animal {

	public static void main(String[] args) {
		Animals obj = new Dog(); // ✅ Allowed (using implementing class)
		obj.makeSound();
	}
}
