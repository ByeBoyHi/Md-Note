package code12_枚举_泛型_内部类.test02_泛型;

public class Test04_特性 {
	public static void main(String[] args) {
		Master<Double, Integer, String> m = new Master<>();

		m.a(12.5, 12, "tom");
	}
}

class Pet {

}

class Dog extends Pet {

}

class Pig extends Pet {

}

class Master<T, K, V> {

	public void a(T t, K k, V v) {
		System.out.println(t);
		System.out.println(k);
		System.out.println(v);
	}

	public Stu<? extends Pet> b() {
		// return new Stu<Pet>();
		// return new Stu<Dog>();
		return new Stu<Pig>();
	}

	public Stu<? super Dog> c() {
		// return new Stu<Dog>();
		return new Stu<Pet>();
		// return new Stu<Pig>(); //不行
	}

}
