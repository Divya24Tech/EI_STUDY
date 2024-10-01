package smartHome.devices;

public class DoorLock extends SmartDevice {
    private boolean isLocked;

    public DoorLock(int id) {
        super(id, "door lock");
        this.isLocked = true; // Initially locked
    }

    public void lock() {
        this.isLocked = true;
        System.out.println("Door " + id + " is locked");
    }

    public void unlock() {
        this.isLocked = false;
        System.out.println("Door " + id + " is unlocked");
    }

    @Override
    public void turnOn() {
        unlock();
    }

    @Override
    public void turnOff() {
        lock();
    }

    @Override
    public String getStatus() {
        return "Door " + id + " is " + (isLocked ? "Locked" : "Unlocked");
    }
}
