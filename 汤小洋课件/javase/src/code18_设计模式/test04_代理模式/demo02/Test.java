package code18_设计模式.test04_代理模式.demo02;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Date;

public class Test {
	public static void main(String[] args) {
		UserService userService=(UserService) Proxy.newProxyInstance(
				UserServiceImpl.class.getClassLoader(),  // 目标类的类加载器
				new Class[]{UserService.class}, // 目标类的接口列表
				new InvocationHandler() { // 代理要执行的操作
					// 参数的含义：生成的代理对象、目标方法、方法参数
					@Override
					public Object invoke(Object proxy, Method method, Object[] args)
							throws Throwable {
						 System.out.println(method.getName()+"start:"+new Date().getTime()+"，参数："+Arrays.toString(args));
						 Object returnValue = method.invoke(new UserServiceImpl(), args);
						 return returnValue;
					}
				}); 
		
		userService.login("admin", "123");
		
		System.out.println("---------------------------------");
		
		System.out.println(userService.logout());
		
		//  代理类的类型 class com.sun.proxy.$Proxy0
		System.out.println(userService.getClass());
	}
}
