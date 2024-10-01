package facility;

import sensors.OccupancySensor;
import sensors.ACSystem;
import sensors.LightSystem;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private int roomId;
    private int capacity;
    private boolean isBooked;
    private boolean isOccupied;
    private List<OccupancySensor> sensors = new ArrayList<>();

    public Room(int roomId, int capacity) {
        this.roomId = roomId;
        this.capacity = capacity;
        this.sensors.add(new ACSystem());
        this.sensors.add(new LightSystem());
    }

    public void book(String startTime, int duration) {
        if (isBooked) {
            System.out.println("Room " + roomId + " is already booked.");
        } else {
            isBooked = true;
            System.out.println("Room " + roomId + " booked from " + startTime + " for " + duration + " minutes.");
        }
    }

    public void cancelBooking() {
        if (!isBooked) {
            System.out.println("Room " + roomId + " is not booked.");
        } else {
            isBooked = false;
            System.out.println("Booking for Room " + roomId + " cancelled.");
        }
    }

    public void updateOccupancy(int occupants) {
        if (occupants >= 2 && !isOccupied) {
            isOccupied = true;
            System.out.println("Room " + roomId + " is now occupied by " + occupants + " persons.");
            notifySensors(true);
        } else if (occupants == 0 && isOccupied) {
            isOccupied = false;
            System.out.println("Room " + roomId + " is now unoccupied.");
            notifySensors(false);
        } else {
            System.out.println("Occupancy insufficient to mark room as occupied.");
        }
    }

    private void notifySensors(boolean status) {
        for (OccupancySensor sensor : sensors) {
            sensor.update(status);
        }
    }
}
