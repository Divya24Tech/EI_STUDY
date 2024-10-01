package smartHome.observer;

import smartHome.devices.SmartDevice;

public interface DeviceObserver {
    void update(SmartDevice device);
}
