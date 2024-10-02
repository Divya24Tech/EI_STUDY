package  Car_Rental_System.car.objectpool;

import  Car_Rental_System.car.abstractfactory.Car;
import  Car_Rental_System.car.abstractfactory.CarFactory;
import  Car_Rental_System.utilities.Logging;

import java.util.Queue;
import java.util.LinkedList;

public class CarPool {
    private Queue<Car> availableCars = new LinkedList<>();

    public Car getCar(String type) {
        if (availableCars.isEmpty()) {
            Logging.info("Creating a new car: " + type);
            return CarFactory.createCar(type);
        }

        Logging.info("Reusing an available car: " + type);
        return availableCars.poll();
    }

    public void releaseCar(Car car) {
        availableCars.offer(car);
        Logging.info("Car returned to pool.");
    }
}
