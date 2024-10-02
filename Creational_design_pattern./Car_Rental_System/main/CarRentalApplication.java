package  Car_Rental_System.main;

import  Car_Rental_System.car.abstractfactory.Car;
import  Car_Rental_System.car.objectpool.CarPool;
import  Car_Rental_System.utilities.Logging;

import java.util.Scanner;

public class CarRentalApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CarPool carPool = new CarPool();

        System.out.println("Enter car type (suv or sedan):");
        String carType = scanner.nextLine();

        try {
            // Get car from pool or create a new one
            Car car = carPool.getCar(carType);
            car.drive();

            // Return car to the pool
            carPool.releaseCar(car);
        } catch (IllegalArgumentException e) {
            Logging.error(e.getMessage());
        }

        scanner.close();
    }
}
