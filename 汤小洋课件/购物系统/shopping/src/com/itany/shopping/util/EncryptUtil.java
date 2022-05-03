package com.itany.shopping.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Calendar;

/*
 * 加密工具类
 * 
 * MD5是一种单向加密算法，不可逆的
 * Message-Digest Algorithm 5 消息摘要算法第五版
 */
public class EncryptUtil {

	public static String md5(String inputText) {
		String encryptText = null;
		try {
			// 创建一个MessageDigest对象，指定使用md5算法
			MessageDigest md = MessageDigest.getInstance("md5");
			// 加密，即进行摘要更新和计算
			byte[] bytes = md.digest(inputText.getBytes());
			// 使用BASE64编码处理，即将字节数组转换为字符串
			encryptText = Base64.getEncoder().encodeToString(bytes);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return encryptText;
	}

	public static void main(String[] args) {
		System.out.println(EncryptUtil.md5("111"));
	}
}
