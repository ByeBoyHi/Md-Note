package code17_反射;

import java.util.List;

@Deprecated
public class Test07_JDK自带注解 {
	@Deprecated
	int age;
	
	@Override
	public String toString() {
		return super.toString();
	}
	
	@Deprecated
	public static void show(){
		System.out.println("Test07_JDK自带注解.show()");
		
		@SuppressWarnings("unused")
		String name="tom";
		
		@SuppressWarnings({ "rawtypes", "unused" })
		List list;
		
	}
	
	public static void main(String[] args) {
		show();
	}
}
