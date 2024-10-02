package Car_Rental_System.car.abstractfactory;

import  Car_Rental_System.utilities.Validation;

public class CarFactory {
    public static Car createCar(String type) {
        Validation.validateString(type, "Car type cannot be null or empty.");
        
        switch (type.toLowerCase()) {
            case "suv":
                return new SUV();
            case "sedan":
                return new Sedan();
            default:
                throw new IllegalArgumentException("Unknown car type: " + type);
        }
    }
}
