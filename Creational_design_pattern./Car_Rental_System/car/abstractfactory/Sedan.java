package  Car_Rental_System.car.abstractfactory;

import  Car_Rental_System.utilities.Logging;

public class Sedan extends Car {
    @Override
    public void drive() {
        Logging.info("Driving a Sedan...");
        // Sedan-specific driving logic
    }
}
