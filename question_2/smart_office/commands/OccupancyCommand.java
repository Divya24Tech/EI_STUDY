package commands;

import facility.Office;

public class OccupancyCommand implements Command {
    private int roomId;
    private int occupants;
    private Office office;

    public OccupancyCommand(Office office, int roomId, int occupants) {
        this.office = office;
        this.roomId = roomId;
        this.occupants = occupants;
    }

    @Override
    public void execute() {
        office.updateOccupancy(roomId, occupants);
    }
}
