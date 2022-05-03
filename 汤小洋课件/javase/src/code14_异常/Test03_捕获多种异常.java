package code14_异常;

import java.text.ParseException;

public class Test03_捕获多种异常 {
	public static void main(String[] args) {
		int[] nums = { 12, 4, 23 };

		try {
			System.out.println(nums[1]);
			System.out.println(5 / 2);

			 String name = null;
			 System.out.println(name.equals("tom"));
			
			Object obj=new Object();
			String str=(String) obj;
			
			int a = Integer.parseInt("abc");
			
			/*
			 * 捕获多种异常时
			 * 1.应将范围小的异常放到前面
			 * 2.当匹配到一个catch时，将不再向下继续查找其他catch
			 */
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("数组下标越界异常。。。。" + e.getMessage());
		} catch (ArithmeticException e) {
			System.out.println("算术异常。。。。" + e.getMessage());
		} catch (NullPointerException e) {
			System.out.println("空指针异常。。。。" + e.getMessage());
		} catch(ClassCastException | NumberFormatException e){ // 如果异常处理是相同的，可以将多个异常合并到一个catch中，multi-catch
			System.out.println("出现异常。。。。"+e.getMessage());
		}catch(Exception e){
			System.out.println("未知异常。。。。"+e.getMessage());
		}

		System.out.println("异常之后的代码。。。。。。");
	}
}
