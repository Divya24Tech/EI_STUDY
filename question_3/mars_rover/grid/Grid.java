package grid;

import exceptions.ObstacleException;
import java.util.List;

public class Grid {
    private int width;
    private int height;
    private List<Obstacle> obstacles;

    public Grid(int width, int height, List<Obstacle> obstacles) {
        this.width = width;
        this.height = height;
        this.obstacles = obstacles;
    }

    public void checkForObstacle(int x, int y) throws ObstacleException {
        for (Obstacle obstacle : obstacles) {
            if (obstacle.getX() == x && obstacle.getY() == y) {
                throw new ObstacleException("Obstacle detected at (" + x + ", " + y + ")");
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
