package facility;

import exceptions.BookingException;
import exceptions.RoomNotFoundException;
import sensors.OccupancySensor;

import java.util.HashMap;
import java.util.Map;

public class Office {
    private static Office instance;
    private Map<Integer, Room> rooms = new HashMap<>();
    
    private Office() {}

    public static Office getInstance() {
        if (instance == null) {
            instance = new Office();
        }
        return instance;
    }

    public void configureRoom(int roomId, int capacity) {
        rooms.put(roomId, new Room(roomId, capacity));
        System.out.println("Room " + roomId + " configured with capacity: " + capacity);
    }

    public void bookRoom(int roomId, String startTime, int duration) throws BookingException {
        Room room = getRoom(roomId);
        room.book(startTime, duration);
    }

    public void cancelBooking(int roomId) throws RoomNotFoundException {
        Room room = getRoom(roomId);
        room.cancelBooking();
    }

    public void updateOccupancy(int roomId, int occupants) {
        Room room = getRoom(roomId);
        room.updateOccupancy(occupants);
    }

    private Room getRoom(int roomId) {
        if (!rooms.containsKey(roomId)) {
            throw new RoomNotFoundException("Room " + roomId + " does not exist.");
        }
        return rooms.get(roomId);
    }
}
