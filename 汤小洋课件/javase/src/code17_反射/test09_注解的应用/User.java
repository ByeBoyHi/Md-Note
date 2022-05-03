package code17_反射.test09_注解的应用;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Properties;

public class User {
	@Value("${user.username}")
	private String username;
	
	@Value("${user.pwd}")
	private String password;
	
	@Value("${user.email}")
	private String email;
	
	private String address;
	
	public String getUsername() {
		return username;
	}

	public User(){
		init();
	}
	
	// 初始化
	private void init() {
		/*
		 * 加载属性文件
		 */
		Properties p = new Properties();
		try {
			p.load(User.class.getClassLoader().getResourceAsStream("info.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/*
		 * 获取类中所有属性上的@Value注解，并解析处理
		 */
		// 获取所有属性
		Class<? extends User> cls = this.getClass();
		Field[] fields = cls.getDeclaredFields();
		// 循环获取每个属性上的@Value注解
		for (Field field : fields) {
			Value annotation = field.getAnnotation(Value.class);
			// 判断是否有该注解
			if(annotation!=null){
				// 获取注解上的值，并对值进行判断处理
				String value = annotation.value();
				if(value.startsWith("${")&&value.endsWith("}")){
					String key = value.substring(2, value.length()-1);
					value = p.getProperty(key);
				}
				// 为类中的属性赋值
				try {
					field.setAccessible(true);
					field.set(this, value);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password
				+ ", email=" + email + "]";
	}

}
