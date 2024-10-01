package smartHome.hub;

import smartHome.devices.SmartDevice;
import smartHome.factory.SmartDeviceFactory;
import smartHome.observer.DeviceObserver;

import java.util.ArrayList;
import java.util.List;

public class SmartHomeHub {
    private List<SmartDevice> devices = new ArrayList<>();
    private List<DeviceObserver> observers = new ArrayList<>();

    public void addDevice(String type, int id) {
        SmartDevice device = SmartDeviceFactory.createDevice(type, id);
        devices.add(device);
        notifyObservers(device);
    }

    public void removeDevice(int id) {
        devices.removeIf(device -> device.getId() == id);
    }

    public void turnDeviceOn(int id) {
        for (SmartDevice device : devices) {
            if (device.getId() == id) {
                device.turnOn();
                notifyObservers(device);
                break;
            }
        }
    }

    public void turnDeviceOff(int id) {
        for (SmartDevice device : devices) {
            if (device.getId() == id) {
                device.turnOff();
                notifyObservers(device);
                break;
            }
        }
    }

    public void addObserver(DeviceObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(DeviceObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers(SmartDevice device) {
        for (DeviceObserver observer : observers) {
            observer.update(device);
        }
    }

    public void showStatus() {
        for (SmartDevice device : devices) {
            System.out.println(device.getStatus());
        }
    }
}
