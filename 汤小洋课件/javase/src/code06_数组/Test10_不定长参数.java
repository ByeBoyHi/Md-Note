package code06_数组;

public class Test10_不定长参数 {

	// 使用数组作为参数
	public static void m1(int n, String[] args) {
		System.out.println("m1");
	}
	
	//使用不定长参数
	public static void m2(int n,String... args){
		System.out.println("m2，个数："+args.length);
		System.out.println(args[0]);
	}

	public static void main(String[] args) {
		// String[] names=new String[]{"tom","jack"};
		m1(6, new String[] { "tom", "jack" }); //参数个数固定
		
		m2(6,"tom","jack","alice"); //传递的参数个数任意
		m2(6,"jack","alice");
		m2(6,"tom");
		m2(6); //也可以不传
		
		m2(6,new String[] { "tom", "jack" }); //本质上就是数组
		
	}
}
