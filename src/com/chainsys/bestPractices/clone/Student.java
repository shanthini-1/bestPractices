package com.chainsys.bestPractices.clone;

public class Student  implements Cloneable  
{
	public String name ;
	public int age;
	
	 @Override 
	 
	 public  Object clone() throws CloneNotSupportedException{
	 
		 
		 return super.clone();
	 }

}
