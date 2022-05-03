package code17_反射;

public class Test02_获取Class对象 {
	public static void main(String[] args) throws ClassNotFoundException {

		// 调用对象的getClass()方法
		Person p = new Person();
		Class cls = p.getClass();
		System.out.println(cls);

		// 调用类的class属性
		Class cls2=Person.class;
		
		// 调用Class类的forName()静态方法
		Class cls3=Class.forName("code17_反射.Person");
		
		System.out.println(cls==cls2);
		System.out.println(cls==cls3);
	}
}
