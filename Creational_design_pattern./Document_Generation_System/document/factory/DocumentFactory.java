


package Document_Generation_System.document.factory;

import Document_Generation_System.utilities.Validation;

public class DocumentFactory {
    public static Document createDocument(String type) {
        Validation.validateString(type, "Document type cannot be null or empty.");
        
        switch (type.toLowerCase()) {
            case "pdf":
                return new PDFDocument();
            case "word":
                return new WordDocument();
            default:
                throw new IllegalArgumentException("Unknown document type: " + type);
        }
    }
}
