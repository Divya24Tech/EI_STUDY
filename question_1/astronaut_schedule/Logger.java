import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private static Logger instance = null;

    private Logger() {}

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void logError(String message) {
        try (FileWriter fw = new FileWriter("application.log", true)) {
            fw.write("ERROR: " + message + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
