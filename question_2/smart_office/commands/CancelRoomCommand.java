package commands;

import facility.Office;
import exceptions.RoomNotFoundException;

public class CancelRoomCommand implements Command {
    private int roomId;
    private Office office;

    public CancelRoomCommand(Office office, int roomId) {
        this.office = office;
        this.roomId = roomId;
    }

    @Override
    public void execute() {
        try {
            office.cancelBooking(roomId);
        } catch (RoomNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
