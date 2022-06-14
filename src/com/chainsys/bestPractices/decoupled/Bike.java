package com.chainsys.bestPractices.decoupled;
                                            // Objects of this class can work with any engine, and with any wheel
                                            // The car class is decoupled from PetrolEngine class, and SteelWheel class
public class Bike {
	private Iengine engine; //early bound with engine interface
	public Iengine getEngine() {
		return engine;
	}
	
	 // early bound with wheel interface
     // The type of engine,  will be injected to the Bike class 
    //  At runtime using the setter methods. This is called as setter based 
   //   dependency injection
	public void setEngine(Iengine engine) {
		this.engine = engine;
	}
	
	//early bound with wheel interface
    // The type of wheel,  will be injected to the Bike class 
   // At runtime using the setter methods. This is called as setter based 
  // dependency injection

	public void setWheels(Iwheel[] wheels) {
		this.wheels = wheels;
	}
	private Iwheel[] wheels;      
	
   public void startBike() {
	   engine.start();
	   wheels[0].rotate();
	   wheels[1].rotate();
	  
   }
   public Iwheel[] getWheels() {
	   return this.wheels;
   }
}