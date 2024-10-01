package smartHome;

import smartHome.hub.SmartHomeHub;

public class UserInterface {
    public static void main(String[] args) {
        SmartHomeHub hub = new SmartHomeHub();
        
        hub.addDevice("light", 1);
        hub.addDevice("thermostat", 2);
        hub.addDevice("door lock", 3);

        hub.turnDeviceOn(1);
        hub.turnDeviceOn(2);
        hub.turnDeviceOff(3);

        hub.showStatus();
    }
}
