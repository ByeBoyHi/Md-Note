package code03_选择结构;

public class Test04_嵌套if结构 {
	public static void main(String[] args) {
		int today=7;
		String weather="晴天";
		if(today>=6){ //外层if
			if(weather=="晴天"){ //内层if，只有当外层if条件成立时才会执行
				System.out.println("今天休息，去户外浪里个浪");
			}else{
				System.out.println("今天休息，去室内游乐场玩");
			}
		}else{
			System.out.println("今天上课，心情很沉重");
		}
	}
}
