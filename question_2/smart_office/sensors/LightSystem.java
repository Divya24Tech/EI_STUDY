package sensors;

public class LightSystem implements OccupancySensor {
    @Override
    public void update(boolean isOccupied) {
        if (isOccupied) {
            System.out.println("Lights turned ON.");
        } else {
            System.out.println("Lights turned OFF.");
        }
    }
}
