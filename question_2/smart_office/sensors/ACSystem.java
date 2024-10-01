package sensors;

public class ACSystem implements OccupancySensor {
    @Override
    public void update(boolean isOccupied) {
        if (isOccupied) {
            System.out.println("AC turned ON.");
        } else {
            System.out.println("AC turned OFF.");
        }
    }
}
