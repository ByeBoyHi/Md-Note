package code11_常用类.test02_String;

/*
 * 将字符串str每4个字符后添加一个短横线-，并将所有大写字母变成小写字母，小写变成大写字母
 */
public class 练习2 {
	public static void main(String[] args) {
		String str = "aSdf23sA89DSl23py89U";

		// AsDF-23Sa-89ds-L23P-Y

		String result = "";
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c >= 'a' && c <= 'z') {
				result += (c + "").toUpperCase();
			} else if (c >= 'A' && c <= 'Z') {
				result += (c + "").toLowerCase();
			} else {
				result += c;
			}
			if ((i + 1) % 4 == 0 && i != str.length() - 1) { // 3 7 11
				result += "-";
			}
		}
		System.out.println(result);

	}
}
