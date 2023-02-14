package view;

public class InputValidator {

    public void validateHeight(String height) {
        try {
            int i = Integer.parseInt(height);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
