package models;

import java.util.logging.Logger;

public class Assignment {
    private String details;
    private boolean isSubmitted;
    private static final Logger LOGGER = Logger.getLogger(Assignment.class.getName());

    public Assignment(String details) {
        if (details == null || details.isEmpty()) {
            throw new IllegalArgumentException("Assignment details cannot be null or empty.");
        }
        this.details = details;
        this.isSubmitted = false;
        LOGGER.info("Assignment created with details: " + details);
    }

    public String getDetails() {
        return details;
    }

    public boolean isSubmitted() {
        return isSubmitted;
    }

    public void submit() {
        if (!isSubmitted) {
            this.isSubmitted = true;
            LOGGER.info("Assignment submitted.");
        } else {
            LOGGER.warning("Assignment already submitted.");
        }
    }
}