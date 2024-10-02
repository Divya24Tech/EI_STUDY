

package Document_Generation_System.main;

import Document_Generation_System.document.factory.Document;
import Document_Generation_System.document.factory.DocumentFactory;
import Document_Generation_System.document.singleton.TemplateManager;
import Document_Generation_System.utilities.Logging;

import java.util.Scanner;

public class DocumentApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Singleton instance of TemplateManager
        TemplateManager templateManager = TemplateManager.getInstance();
        templateManager.loadTemplate("Default Template");

        System.out.println("Enter document type (pdf or word):");
        String docType = scanner.nextLine();

        try {
            Document document = DocumentFactory.createDocument(docType);
            document.generate();
        } catch (IllegalArgumentException e) {
            Logging.error(e.getMessage());
        }

        scanner.close();
    }
}
