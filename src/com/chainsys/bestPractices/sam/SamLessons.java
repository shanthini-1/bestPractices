package com.chainsys.bestPractices.sam;

import java.util.ArrayList;

// SAM - Single Abstract Method

interface IntegerFunction {
	Integer doOperations(int x, int y); // Abstract method
	boolean equals(Object obj);
	String toString();
}

interface StringFunction {
	String execute(String s);
}
interface NumberFunction{
	Integer doOperations(int x, int y,int z);
}
class ImplementerA implements IntegerFunction{

	@Override
	public Integer doOperations(int x, int y) {
		return x+y;
	}
	
}
public class SamLessons {
	public static void demoA() {
		IntegerFunction total = new ImplementerA(); 
		 
		IntegerFunction add = (x, y) -> {
			x +=100;
			return x + y;
			}; // Lambda expression - shortcut code
//	(x,y) this is parameters for the method 
//	->  x+y this is the implementation for the method
//		add is an implementation of doOperations method of interface IntegerFunction
		NumberFunction sum = (x, y, z) -> x + y+z;
		IntegerFunction multiply = (x, y) -> x * y;
		IntegerFunction divide = (x, y) -> x / y;
		int result = add.doOperations(2, 8);
//		using wrapper class to treat it as Object (Boxing)
		System.out.println("result : " + result);
		result = total.doOperations(5, 6);
		System.out.println("result : "+ result);
		result = multiply.doOperations(2, 7);
		
		System.out.println("result : " + result);
		result = divide.doOperations(12, 3);
		System.out.println("result : " + result);
//  
		System.out.println(add.getClass().getName());
	}

	public static void demoB() {
		StringFunction upper = (s) -> s.toUpperCase();
		StringFunction lower = (s) -> s.toLowerCase();
		String result = upper.execute("shanthini");
		System.out.println("result : " + result);
		result = lower.execute("SHANthinI");
		System.out.println("result : " + result);
	}
	public static void demoC() {
		ArrayList<Integer> nos=new ArrayList<Integer>();
		nos.add(100);
		nos.add(20);
		nos.add(30);
		nos.add(25);
		nos.add(80);
		nos.forEach((n)-> System.out.println(n));
//		Single line statement
	}
	public static void demoD() {
		IntegerFunction getTotal=(x,y)->x+y;
		ArrayList<Integer> nos=new ArrayList<Integer>();
		nos.add(100);
		nos.add(20);
		nos.add(30);
		nos.add(25);
		nos.add(80);
		int i=100;
		nos.forEach((n)-> 
		{
			int result=0;
			result=getTotal.doOperations(n, i);
			System.out.println(" total: "+result);
		}
		);
//		multi line statements 
	}
}
