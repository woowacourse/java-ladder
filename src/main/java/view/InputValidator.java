package view;

public class InputValidator {

    public int validateHeight(String height) {
        try {
            return Integer.parseInt(height);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
