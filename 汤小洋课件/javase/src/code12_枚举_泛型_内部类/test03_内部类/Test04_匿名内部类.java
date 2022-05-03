package code12_枚举_泛型_内部类.test03_内部类;

public class Test04_匿名内部类 {
	public static void main(String[] args) {
		//MyInterface m = new MyInterfaceImpl();
		//m.show();

		
		// 创建一个实现MyInterface接口的匿名内部类，并创建了一个对象
		MyInterface m = new MyInterface() {
			
			@Override
			public void show() {
				System.out.println("实现接口中的show方法");
				
			}
		};
		m.show();
		
		Pet pet=new Pet() {
			
			@Override
			public void play() {
				System.out.println("实现Pet类中的play方法");
			}

			@Override
			public void show() {
				super.show();
			}
			
			
		};
		pet.play();
		pet.show();
	}
}

interface MyInterface {
	public void show();
}

//class MyInterfaceImpl implements MyInterface {
//
//	@Override
//	public void show() {
//		System.out.println("MyInterfaceImpl.show()");
//	}
//
//}

abstract class Pet{
	public void show(){
		System.out.println("这是一只宠物");
	}
	
	public abstract void play();
}
