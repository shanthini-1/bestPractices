package com.chainsys.bestPractices.defaulemethod;

public class TestVehicle {

	public static void main(String[] args) {
		
		Car firstCar = new Car();
		firstCar.move();
		firstCar.start();
		
		Bike firstBike =  new Bike();
		firstBike.move();
		firstBike.start();
		

	}

}
