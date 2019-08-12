package com.pradeep;

public class test {

	static int i = 1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Hello,\nworld!");
		
		int i = 0;
		i = i++ + i;
		System.out.println("I = "+i);
		
		
		System.out.println(i+",");
		m(i);
		System.out.println(i);
		}
		public static void m(int i)
		{
		i += 2;
		}
		
	}


