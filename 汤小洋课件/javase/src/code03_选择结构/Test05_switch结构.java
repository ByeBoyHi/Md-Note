package code03_选择结构;

public class Test05_switch结构 {
	public static void main(String[] args) {
		int today=6;
		switch(today){
			case 1:
				System.out.println("今天吃包子");
				//break; //当省略break时一旦匹配，则一直往下执行，不再做匹配，直到遇到break为止
			case 2: //当匹配值2、3、4时执行相同的代码
			case 3:
			case 4:	
				System.out.println("今天吃面条");
				break;
			case 5:
				System.out.println("今天吃饺子");
				break;
			default:
				System.out.println("今天周末，早饭午饭一起吃");
		}
		System.out.println("switch之后的代码");
	}
}
