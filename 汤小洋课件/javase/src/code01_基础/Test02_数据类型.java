package code01_基础;

public class Test02_数据类型 {
	public static void main(String[] args) {
		/*
		 * 常用类型
		 */
		byte num1 = 5;
		short num2 = 26;
		int num3 = 12;
		long num4 = 666l; //需要以l或L结尾
		System.out.println(num4);
		
		float weight=180.5f; //需要以f或F结尾
		double height=176.8;
		System.out.println("体重："+weight);
		System.out.println("身高："+height);
		
		char sex='男'; //需要使用单引号引起来
		System.out.println("性别："+sex);
		
		boolean isOK=false; //取值只能为true或false
		System.out.println("可以吗："+isOK);
		
		String name="唐伯虎";
		System.out.println("姓名："+name);
		
		
	}
}
