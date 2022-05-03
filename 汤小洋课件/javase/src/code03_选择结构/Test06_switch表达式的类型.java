package code03_选择结构;

public class Test06_switch表达式的类型 {
	public static void main(String[] args) {
		/*
		 * 表达式为字符
		 */
		char sex='男';
		switch(sex){
			case '男':
				System.out.println("爷们");
				break;
			case '女':
				System.out.println("娘们");
				break;
			default:
				System.out.println("人妖");
				break;
		}
		
		/*
		 * 表达式为字符串
		 */
		String gender="female";
		switch(gender){
			case "male":
				System.out.println("帅哥");
				break;
			case "female":
				System.out.println("美女");
				break;
		}
		
	}
}
