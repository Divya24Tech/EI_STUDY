
package Document_Generation_System.document.singleton;

import Document_Generation_System.utilities.Logging;

public class TemplateManager {
    private static TemplateManager instance;

    private TemplateManager() {
        // Load default templates
    }

    public static TemplateManager getInstance() {
        if (instance == null) {
            instance = new TemplateManager();
        }
        return instance;
    }

    public void loadTemplate(String templateName) {
        Logging.info("Loading template: " + templateName);
        // Template loading logic
    }
}
