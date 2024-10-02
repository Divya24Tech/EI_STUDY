package  Car_Rental_System.car.abstractfactory;

import  Car_Rental_System.utilities.Logging;

public class SUV extends Car {
    @Override
    public void drive() {
        Logging.info("Driving an SUV...");
        // SUV-specific driving logic
    }
}
