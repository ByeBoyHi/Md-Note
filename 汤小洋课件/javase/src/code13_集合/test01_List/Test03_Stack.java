package code13_集合.test01_List;

import java.util.Stack;

public class Test03_Stack {
	public static void main(String[] args) {
		// 创建一个空栈
		Stack<String> stack = new Stack<String>();

		// push() 入栈
		stack.push("a");
		stack.push("b");
		stack.push("c");

		// pop() 出栈，即取出栈顶的元素
		// System.out.println(stack.pop());
		
		// peek() 查看栈顶的元素
		System.out.println(stack.peek());
		
		System.out.println(stack);
	}
}
