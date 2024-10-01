package src;

import simulator.Rocket;
import simulator.Validator;
import util.LoggerUtil;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LoggerUtil.logInfo("Rocket Launch Simulator initiated.");
        Rocket rocket = new Rocket();
        Scanner scanner = new Scanner(System.in);
        String command;

        while (rocket.isFuelRemaining()) {
            System.out.println("Enter command (start_checks, launch, fast_forward X): ");
            command = scanner.nextLine();
            
            try {
                if (Validator.isValidCommand(command)) {
                    rocket.processCommand(command);
                } else {
                    LoggerUtil.logWarning("Invalid command entered: " + command);
                    System.out.println("Invalid command. Try again.");
                }
            } catch (Exception e) {
                util.ExceptionHandler.handleException(e);
            }
        }

        LoggerUtil.logInfo("Mission ended. Fuel depleted.");
        scanner.close();
    }
}
