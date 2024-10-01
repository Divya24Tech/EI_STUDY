import java.util.logging.Logger;

public class Satellite {
    private String orientation;
    private boolean solarPanelsActive;
    private int dataCollected;
    private final Logger logger = SatelliteLogger.getLogger();

    // Constructor initializes the satellite state
    public Satellite() {
        this.orientation = "North";
        this.solarPanelsActive = false;
        this.dataCollected = 0;
        logger.info("Satellite initialized with default state.");
    }

    // Rotate the satellite
    public void rotate(String direction) throws CustomException {
        if (direction.equals("North") || direction.equals("South") ||
            direction.equals("East") || direction.equals("West")) {
            this.orientation = direction;
            logger.info("Satellite rotated to " + this.orientation);
        } else {
            throw new CustomException("Invalid direction: " + direction);
        }
    }

    // Activate solar panels
    public void activatePanels() {
        this.solarPanelsActive = true;
        logger.info("Solar panels activated.");
    }

    // Deactivate solar panels
    public void deactivatePanels() {
        this.solarPanelsActive = false;
        logger.info("Solar panels deactivated.");
    }

    // Collect data if solar panels are active
    public void collectData() throws CustomException {
        if (this.solarPanelsActive) {
            this.dataCollected += 10;
            logger.info("Data collected. Total: " + this.dataCollected + " units.");
        } else {
            throw new CustomException("Cannot collect data. Solar panels are inactive.");
        }
    }

    public void displayState() {
        logger.info("Satellite state -> Orientation: " + this.orientation +
                ", Solar Panels: " + (this.solarPanelsActive ? "Active" : "Inactive") +
                ", Data Collected: " + this.dataCollected + " units.");
    }
}
