import commands.*;
import facility.Office;

public class Main {
    public static void main(String[] args) {
        Office office = Office.getInstance();

        // Configure rooms
        office.configureRoom(1, 10);
        office.configureRoom(2, 8);

        // Command pattern to handle booking, cancelling, and occupancy
        Command bookRoom1 = new BookRoomCommand(office, 1, "09:00", 60);
        Command cancelRoom1 = new CancelRoomCommand(office, 1);
        Command addOccupantsRoom1 = new OccupancyCommand(office, 1, 2);
        Command removeOccupantsRoom1 = new OccupancyCommand(office, 1, 0);

        // Execute commands
        bookRoom1.execute();
        addOccupantsRoom1.execute();
        removeOccupantsRoom1.execute();
        cancelRoom1.execute();
    }
}
