package code11_常用类.test02_String;

/*
 * JDK8新增方法，静态方法 
 */
public class Test03_新增方法 {
	public static void main(String[] args) {
		String s = String.join("-", "aa", "bb", "cc", "dd");
		System.out.println(s);
		
		String[] arr={"aaa","bbb","ccc"};
		String str = String.join("_", arr); //和split的作用相反
		System.out.println(str);
	}
}
