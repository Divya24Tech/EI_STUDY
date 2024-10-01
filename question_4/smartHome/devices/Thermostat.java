package smartHome.devices;

public class Thermostat extends SmartDevice {
    private int temperature;

    public Thermostat(int id, int initialTemp) {
        super(id, "thermostat");
        this.temperature = initialTemp;
    }

    public void setTemperature(int temp) {
        this.temperature = temp;
        System.out.println("Thermostat " + id + " is set to " + temp + " degrees");
    }

    @Override
    public void turnOn() {
        System.out.println("Thermostat " + id + " is On");
    }

    @Override
    public void turnOff() {
        System.out.println("Thermostat " + id + " is Off");
    }

    @Override
    public String getStatus() {
        return "Thermostat " + id + " is set to " + temperature + " degrees";
    }
}
