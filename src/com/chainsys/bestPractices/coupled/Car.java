package com.chainsys.bestPractices.coupled;

// Object of this class can work only with petrol engine and steel wheel
// The car class is tightly coupled with petrolEngine class and steelWheel class
public class Car {
   private  PetrolEngine engine ;      // Early bound with petrol engine
   private SteelWheel[] wheels;          //early bound with steelwheel
   
   
   public Car() {
	   engine =new PetrolEngine();
	   wheels = new SteelWheel[4];
	   wheels[0] =  new SteelWheel();
	   wheels[0].location = "Front left";
	   wheels[1] =  new SteelWheel();
	   wheels[1].location = "Front Right";
	   wheels[2] =  new SteelWheel();
	   wheels[2].location = "Back left";
	   wheels[3] =  new SteelWheel();
	   wheels[3].location = "Back Right";
   }
   
   public Car(PetrolEngine engine, SteelWheel wheel[]) {
	   this. engine = engine;
	   this.wheels = wheel;
	     wheels[0].location = "Front left";
	     wheels[1].location = "Front Right";
	     wheels[2].location = "Back left";
	     wheels[3].location = "Back Right";
   }
   
   public SteelWheel[] getWheels() {
	   return this.wheels;
   }
   
   public void startCar() {
	   engine.start();
	   wheels[0].rotate();
	   
   }
}
