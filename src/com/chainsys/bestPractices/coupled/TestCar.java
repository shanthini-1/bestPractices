package com.chainsys.bestPractices.coupled;

public class TestCar {

	public static void main(String[] args) {
		Car newCar = new Car();
		newCar.startCar();
		
		SteelWheel[]  carWheels = newCar.getWheels();
		int length = carWheels.length;
		for(int i=0; i<length; i++) {
			System.out.println(carWheels[i].location);
		}

	}

}
