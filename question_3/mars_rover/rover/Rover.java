package rover;

import exceptions.ObstacleException;
import exceptions.GridBoundaryException;
import grid.Grid;
import logs.Logger;

public class Rover {
    private int x;
    private int y;
    private char direction; // N, S, E, W
    private Grid grid;

    public Rover(int x, int y, char direction, Grid grid) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.grid = grid;
    }

    public void move() {
        try {
            switch (direction) {
                case 'N': 
                    grid.checkForObstacle(x, y + 1);
                    if (y + 1 < grid.getHeight()) y++; 
                    else throw new GridBoundaryException("Rover reached north boundary!");
                    break;
                case 'S': 
                    grid.checkForObstacle(x, y - 1);
                    if (y - 1 >= 0) y--; 
                    else throw new GridBoundaryException("Rover reached south boundary!");
                    break;
                case 'E': 
                    grid.checkForObstacle(x + 1, y);
                    if (x + 1 < grid.getWidth()) x++; 
                    else throw new GridBoundaryException("Rover reached east boundary!");
                    break;
                case 'W': 
                    grid.checkForObstacle(x - 1, y);
                    if (x - 1 >= 0) x--; 
                    else throw new GridBoundaryException("Rover reached west boundary!");
                    break;
            }
            Logger.log("Rover moved to (" + x + ", " + y + ")");
        } catch (ObstacleException | GridBoundaryException e) {
            Logger.log(e.getMessage());
        }
    }

    public void turnLeft() {
        switch (direction) {
            case 'N': direction = 'W'; break;
            case 'S': direction = 'E'; break;
            case 'E': direction = 'N'; break;
            case 'W': direction = 'S'; break;
        }
        Logger.log("Rover turned left. Now facing: " + direction);
    }

    public void turnRight() {
        switch (direction) {
            case 'N': direction = 'E'; break;
            case 'S': direction = 'W'; break;
            case 'E': direction = 'S'; break;
            case 'W': direction = 'N'; break;
        }
        Logger.log("Rover turned right. Now facing: " + direction);
    }

    public String getStatus() {
        return "Rover is at (" + x + ", " + y + ") facing " + direction;
    }
}
