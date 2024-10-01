public class CollectDataCommand implements SatelliteCommand {

    @Override
    public void execute(Satellite satellite) throws CustomException {
        satellite.collectData();
    }
}
