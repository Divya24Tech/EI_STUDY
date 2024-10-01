public class DeactivatePanelsCommand implements SatelliteCommand {

    @Override
    public void execute(Satellite satellite) {
        satellite.deactivatePanels();
    }
}
