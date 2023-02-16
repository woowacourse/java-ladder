package laddervalidate;

import java.util.regex.Pattern;

public class HeightValidator {
    public void checkNumberMissMatch(String height) {
        if (!Pattern.matches("^[0-9]*$", height)) {
            throw new IllegalArgumentException();
        }
    }

    public void checkNumberRange(String height) {
        if (Integer.parseInt(height) <= 0) {
            throw new IllegalArgumentException();
        }
    }
}
