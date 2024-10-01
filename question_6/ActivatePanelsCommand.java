public class ActivatePanelsCommand implements SatelliteCommand {

    @Override
    public void execute(Satellite satellite) {
        satellite.activatePanels();
    }
}
