package simulator;

public class Validator {
    public static boolean isValidCommand(String command) {
        if (command == null || command.trim().isEmpty()) {
            return false;
        }
        String[] parts = command.split(" ");
        String baseCommand = parts[0];
        return baseCommand.equals("start_checks") || baseCommand.equals("launch") ||
                (baseCommand.equals("fast_forward") && parts.length == 2 && isNumeric(parts[1]));
    }

    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
