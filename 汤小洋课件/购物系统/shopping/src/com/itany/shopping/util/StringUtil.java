package com.itany.shopping.util;

import java.util.Date;
import java.util.Random;

public class StringUtil {
	
	public static String generateNo(){
		Random random = new Random();
		return new Date().getTime()+""+random.nextInt(100);
	}
	
	public static void main(String[] args) {
		System.out.println(StringUtil.generateNo());
	}
}
