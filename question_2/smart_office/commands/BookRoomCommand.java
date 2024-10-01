package commands;

import facility.Office;
import exceptions.BookingException;

public class BookRoomCommand implements Command {
    private int roomId;
    private String startTime;
    private int duration;
    private Office office;

    public BookRoomCommand(Office office, int roomId, String startTime, int duration) {
        this.office = office;
        this.roomId = roomId;
        this.startTime = startTime;
        this.duration = duration;
    }

    @Override
    public void execute() {
        try {
            office.bookRoom(roomId, startTime, duration);
        } catch (BookingException e) {
            System.out.println(e.getMessage());
        }
    }
}
