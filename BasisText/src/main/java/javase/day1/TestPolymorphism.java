package javase.day1;

public class TestPolymorphism {

	public static void main(String[] args) {
		Dog dog = new Dog();
		Cat cat = new Cat();
		Bird bird = new Bird();
		animalSaySoming(dog);
		animalSaySoming(cat);
		animalSaySoming(bird);
	}

	public static void animalSaySoming(Animal animal) {
		animal.saySomething();
	}
}
//�ü̳���д
class Animal{
	public void saySomething(){};
}
class Dog extends Animal{
	public void saySomething(){
		System.out.println("�ų����������......");
	}	
}

class Cat extends Animal{
	public void saySomething(){
		System.out.println("�ų����������......");
	}	
}

class Bird extends Animal{
	public void saySomething(){
		System.out.println("�ų��ߴߴ������......");
	}	
}