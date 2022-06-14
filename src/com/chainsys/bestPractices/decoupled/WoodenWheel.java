package com.chainsys.bestPractices.decoupled;

public class WoodenWheel implements Iwheel {
	
	public String location;

	public void rotate() {
		System.out.println("Steel wheel rotating");
		
	}
	
	
	@Override
	public void stopRotation() {
		System.out.println("Steel rotating stopped");		
	}
}
