package smartHome.factory;

import smartHome.devices.*;

public class SmartDeviceFactory {
    public static SmartDevice createDevice(String type, int id) {
        switch (type.toLowerCase()) {
            case "light":
                return new Light(id);
            case "thermostat":
                return new Thermostat(id, 72); // Default temp for thermostat
            case "door lock":
                return new DoorLock(id);
            default:
                throw new IllegalArgumentException("Unknown device type");
        }
    }
}
