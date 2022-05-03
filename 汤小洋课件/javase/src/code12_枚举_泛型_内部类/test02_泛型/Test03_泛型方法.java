package code12_枚举_泛型_内部类.test02_泛型;

public class Test03_泛型方法 {
	public static void main(String[] args) {
		Stu<String> s1 = new Stu<String>();
		s1.field="tom";
		
		String property = Utils.getProperty(s1);
		System.out.println(property);
		
		Stu<Integer> s2 = new Stu<>();
		s2.field=18;
		
		Integer property2=Utils.getProperty(s2);
		
	}
}

class Utils{
	
//	public static Object getProperty(Stu stu){
//		Object field = stu.field;
//		return field;
//	}
	
	/*
	 * 泛型方法
	 */
	public static <E> E getProperty(Stu<E> stu){
		E e=stu.field;
		return e;
	}
	
}
