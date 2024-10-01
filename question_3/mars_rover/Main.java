import commands.Command;
import commands.MoveCommand;
import commands.TurnLeftCommand;
import commands.TurnRightCommand;
import grid.Grid;
import grid.Obstacle;
import rover.Rover;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Obstacle> obstacles = Arrays.asList(new Obstacle(2, 2), new Obstacle(3, 5));
        Grid grid = new Grid(10, 10, obstacles);
        Rover rover = new Rover(0, 0, 'N', grid);

        Command moveCommand = new MoveCommand(rover);
        Command leftCommand = new TurnLeftCommand(rover);
        Command rightCommand = new TurnRightCommand(rover);

        // Sample sequence of commands
        List<Command> commands = Arrays.asList(moveCommand, moveCommand, rightCommand, moveCommand, leftCommand, moveCommand);

        for (Command command : commands) {
            command.execute();
        }

        System.out.println(rover.getStatus());
    }
}
