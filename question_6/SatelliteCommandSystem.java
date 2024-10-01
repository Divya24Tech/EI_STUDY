import java.util.Scanner;
import java.util.logging.Logger;

public class SatelliteCommandSystem {
    private static final Logger logger = SatelliteLogger.getLogger();

    public static void main(String[] args) {
        Satellite satellite = new Satellite();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Enter command: rotate [direction] | activatePanels | deactivatePanels | collectData | exit");
                String input = scanner.nextLine().trim();
                if (input.equalsIgnoreCase("exit")) {
                    logger.info("Exiting Satellite Command System.");
                    break;
                }

                SatelliteCommand command = parseCommand(input);
                if (command != null) {
                    command.execute(satellite);
                    satellite.displayState();
                }
            } catch (CustomException e) {
                logger.severe("Error: " + e.getMessage());
            } catch (Exception e) {
                logger.severe("An unexpected error occurred: " + e.getMessage());
            }
        }
        scanner.close();
    }

    private static SatelliteCommand parseCommand(String input) throws CustomException {
        if (input.startsWith("rotate")) {
            String[] parts = input.split(" ");
            if (parts.length == 2) {
                return new RotateCommand(parts[1]);
            } else {
                throw new CustomException("Invalid rotate command format. Usage: rotate [direction]");
            }
        } else if (input.equals("activatePanels")) {
            return new ActivatePanelsCommand();
        } else if (input.equals("deactivatePanels")) {
            return new DeactivatePanelsCommand();
        } else if (input.equals("collectData")) {
            return new CollectDataCommand();
        } else {
            throw new CustomException("Unknown command: " + input);
        }
    }
}
