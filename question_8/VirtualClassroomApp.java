
import manager.VirtualClassroomManager;
import java.util.logging.Logger;

public class VirtualClassroomApp {
    private static final Logger LOGGER = Logger.getLogger(VirtualClassroomApp.class.getName());

    public static void main(String[] args) {
        LOGGER.info("Starting Virtual Classroom Manager...");
        VirtualClassroomManager manager = new VirtualClassroomManager();
        manager.start();
    }
}
