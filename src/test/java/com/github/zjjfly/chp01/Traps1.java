package com.github.zjjfly.chp01;

import org.junit.Test;

import java.math.BigDecimal;

public class Traps1 {
	@Test
	// 陷阱1 奇数判断
	public void isOdd() {
		int i = 3;// 可以赋任意值
		System.out.println((i & 1) != 0);
	}

	@Test
	// 陷阱2 浮点计算
	public void Change() {
		// 这种方式有误差
		// System.out.println(2.0-1.1);
		// System.out.printf("%.2f%n",2.0-1.1);
		// 无误差的方式
		System.out.println(new BigDecimal("2.0")
				.subtract(new BigDecimal("1.1")));
		// 错误的bigdecimal用法
		// System.out.println(new BigDecimal(2.0-1.1));
	}

	@Test
	// 陷阱3 长整除
	public void LongDivision() {
		// 错误的赋值方式
		// final long DAY_MICROS=24*60*60*1000*1000;
		// final long DAY_MILLIS=24*60*60*1000;
		final long DAY_MICROS = 24l * 60 * 60 * 1000 * 1000;
		final long DAY_MILLIS = 24l * 60 * 60 * 1000;
		System.out.println(DAY_MICROS / DAY_MILLIS);
	}

	@Test
	// 陷阱4 注意数字1和小写字母l，它们真他妈的像！
	public void Iand1() {
		System.out.println(12345 + 5432l);
	}

	@Test
	// 陷阱5 混合类型计算问题，最好避免混合类型计算！
	public void JoyofHex() {
		System.out.println(Long.toHexString(0x100000000L + 0xcafebabe));
	}

	@Test
	// 陷阱6 多重转型
	// byte（八位）有符号，是用二进制补码的形式表示，11111111,转成无符号的char（16位），变为1111111111111111，转成十进制就是65535
	public void MultiCast() {
		System.out.println((int) (char) (byte) -1);
	}

	@Test
	// 陷阱7 在单个表达式中不要对一个变量赋值两次！
	public void CleverSwap() {
		int x = 3;
		int y = 2;
		x ^= y ^= x ^= y;
		System.out.println("x=" + x + ",y=" + y);

	}

	@Test
	// 陷阱8 最好在条件表达式中使用相同类型的第二个和第三个操作数
	public void DoSequis() {
		char x = 'X';
		int i = 0;
		System.out.println(true ? x : 0);
		System.out.println(false ? i : x);
	}

	@Test
	// 陷阱9 不要将复合赋值表达式作用于byte，short，char类型的变量，当结果类型宽于变量的类型是，会产生一个窄化转型
	public void Half() {
		short x = 1;
		int i = 123546;
		x += i;
		System.out.println(x);
	}

}
