package simulator;

import util.LoggerUtil;

public class Rocket {
    private StateManager stateManager = new StateManager();

    public void processCommand(String command) throws Exception {
        if (command.startsWith("start_checks")) {
            startPreLaunchChecks();
        } else if (command.startsWith("launch")) {
            launch();
        } else if (command.startsWith("fast_forward")) {
            String[] parts = command.split(" ");
            int seconds = Integer.parseInt(parts[1]);
            fastForward(seconds);
        }
    }

    private void startPreLaunchChecks() {
        LoggerUtil.logInfo("Pre-launch checks started.");
        stateManager.performPreLaunchChecks();
    }

    private void launch() {
        LoggerUtil.logInfo("Rocket launch initiated.");
        stateManager.launchRocket();
    }

    private void fastForward(int seconds) {
        LoggerUtil.logInfo("Fast forwarding by " + seconds + " seconds.");
        stateManager.fastForward(seconds);
    }

    public boolean isFuelRemaining() {
        return stateManager.getFuel() > 0;
    }
}
