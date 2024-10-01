package smartHome.devices;

public class Light extends SmartDevice {
    private boolean isOn;

    public Light(int id) {
        super(id, "light");
        this.isOn = false;
    }

    @Override
    public void turnOn() {
        this.isOn = true;
        System.out.println("Light " + id + " is On");
    }

    @Override
    public void turnOff() {
        this.isOn = false;
        System.out.println("Light " + id + " is Off");
    }

    @Override
    public String getStatus() {
        return "Light " + id + " is " + (isOn ? "On" : "Off");
    }
}
