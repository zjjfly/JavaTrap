package chp02;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.regex.Pattern;



public class Traps2 {
	@Test
	// 陷阱1 字符相加输出
	public void LastLaugh() {
		System.out.println('h' + 'a');
		System.out.println("h"+"a");
		System.out.println("2+2="+2+2);
	}

	@Test
	// 陷阱2 char数组没有实现toString方法
	public void ABC() {
		String s = "This is ";
		char[] cs = new char[] { 'a', 'b', 'c' };
		System.out.println(s + cs);
		System.out.println(s + String.valueOf(cs));
	}

	@Test
	// 陷阱3 +好无论做运算符还是字符串连接符都比==的优先级高
	public void AnimalFarm() {
		String s = "my dog7";
		String p = "my dog" + s.length();
		System.out.println("This is " + s == p);
	}
	@Test
	//陷阱4 unicode转义字符会在编译时转换成它所表示的字符
	public void EscapeRout(){
		System.out.println("a\u0022.length()+\u0022b".length());
		//\u0022其实是一个双引号。
	}

	@Test
	//陷阱5 还是unicode转义符产生的问题
	public void LinePrinter(){
		//下面的这行注释如果没有第二个"//"会出问题
		// \u000A //是换行符的unicode转义符
		char c=0x000A;
		System.out.println(c);
		System.out.println("line");
	}
	@Test
	//陷阱6 把byte数组转成string时，都在使用一个字符集，不管是否显示的指定
	public void StringCheese() throws UnsupportedEncodingException {
		byte bytes[]=new byte[256];
		for(int i=0;i<256;i++){
			bytes[i]=(byte)i;
		}
		//不指定字符集会出问题
		//String str=new String(bytes,"ISO-8859-1");
		String str=new String(bytes);
		for(int i=0,n=str.length();i<n;i++){
			System.out.println((int)str.charAt(i)+" ");

		}
	}
//	@Test
	//陷阱7 注释掉一段代码最好不要用块注释，而是用单行注释
//	public void sum() {
//		/*
//		/* Add  the number from 1 to n*/
//		int sum=0;
//		for(int i=0;i<100;i++){
//			sum+=i;
//		}
//		System.out.println(sum);
//		*/
//	}
	@Test
	//陷阱8 正则表达式中一些符号要加转义字符
	public void WhatisMyClass(){
		//没有加转义字符
		System.out.println(Traps2.class.getName().replaceAll(".", "/"));
		//加了转移字符
		System.out.println(Traps2.class.getName().replaceAll("\\.", "/"));
		//jdk5提供的新方法
		System.out.println(Traps2.class.getName().replaceAll(Pattern.quote("."), "/"));
	}
}
