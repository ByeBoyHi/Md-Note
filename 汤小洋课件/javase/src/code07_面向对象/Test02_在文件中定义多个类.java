package code07_面向对象;
/*
 * 实际开发中都是一个类对应一个文件，不允许在一个文件中定义多个类
 */
public class Test02_在文件中定义多个类 {
	public static void main(String[] args) {
		Pet pet = new Pet();// 创建类的对象（实例）

		// 为属性赋值
		pet.name = "佩琪";
		pet.age = 4;
		pet.sex = "女";

		// 输出信息
		System.out.println("姓名：" + pet.name);
		System.out.println("年龄：" + pet.age);
		System.out.println("性别：" + pet.sex);
		
		System.out.println(pet); //直接输出pet时显示的是对象在内存中的地址
	}
}

/*
 * 宠物类(型)
 */
class Pet {
	String name;
	int age;
	String sex;
}