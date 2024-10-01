package simulator;

import util.LoggerUtil;

public class StateManager {
    private int fuel = 100;
    private int altitude = 0;
    private int speed = 0;
    private String stage = "Pre-Launch";

    private static final int FUEL_CONSUMPTION_PER_SECOND = 10;
    private static final int STAGE_1_ALTITUDE_LIMIT = 100;
    private static final int STAGE_2_ALTITUDE_LIMIT = 300;
    private static final int STAGE_1_SPEED = 1000;
    private static final int STAGE_2_SPEED = 1500;

    private boolean preLaunchChecksComplete = false;

    public void performPreLaunchChecks() {
        System.out.println("All systems are 'Go' for launch.");
        preLaunchChecksComplete = true;
    }

    public void launchRocket() {
        if (!preLaunchChecksComplete) {
            throw new IllegalStateException("Launch cannot proceed without pre-launch checks.");
        }
        while (fuel > 0 && altitude < STAGE_2_ALTITUDE_LIMIT) {
            updateState(1);
            printStatus();
        }

        if (altitude >= STAGE_2_ALTITUDE_LIMIT) {
            System.out.println("Orbit achieved! Mission Successful.");
            LoggerUtil.logInfo("Mission successful. Orbit achieved.");
        } else {
            LoggerUtil.logError("Mission failed due to insufficient fuel.");
            System.out.println("Mission Failed due to insufficient fuel.");
        }
    }

    public void fastForward(int seconds) {
        for (int i = 0; i < seconds && fuel > 0; i++) {
            updateState(1);
        }
        printStatus();
    }

    private void updateState(int seconds) {
        if ("Stage 1".equals(stage)) {
            fuel -= FUEL_CONSUMPTION_PER_SECOND * seconds;
            altitude += 10 * seconds;
            speed = STAGE_1_SPEED;

            if (altitude >= STAGE_1_ALTITUDE_LIMIT) {
                stage = "Stage 2";
                LoggerUtil.logInfo("Stage 1 complete. Entering Stage 2.");
                System.out.println("Stage 1 complete. Separating stage. Entering Stage 2.");
            }
        } else if ("Stage 2".equals(stage)) {
            fuel -= FUEL_CONSUMPTION_PER_SECOND * seconds;
            altitude += 15 * seconds;
            speed = STAGE_2_SPEED;
        }
    }

    public int getFuel() {
        return fuel;
    }

    private void printStatus() {
        LoggerUtil.logInfo(String.format("Stage: %s, Fuel: %d%%, Altitude: %d km, Speed: %d km/h", stage, fuel, altitude, speed));
        System.out.println(String.format("Stage: %s, Fuel: %d%%, Altitude: %d km, Speed: %d km/h", stage, fuel, altitude, speed));
    }
}
