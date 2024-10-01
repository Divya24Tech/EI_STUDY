public class RotateCommand implements SatelliteCommand {
    private final String direction;

    public RotateCommand(String direction) {
        this.direction = direction;
    }

    @Override
    public void execute(Satellite satellite) throws CustomException {
        satellite.rotate(direction);
    }
}
