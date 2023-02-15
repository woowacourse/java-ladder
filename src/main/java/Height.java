import java.util.regex.Pattern;

public class Height {
    private int height;
    public Height(String height) {
        checkNumberMissMatch(height);
        checkNumberRange(height);
        this.height = Integer.parseInt(height);
    }

    public boolean isPossibleCount() {
        return this.height > 0;
    }

    public void minusHeight() {
        this.height--;
    }

    private void checkNumberMissMatch(String height) {
        if (!Pattern.matches("^[0-9]*$", height)) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkNumberRange(String height) {
        if (Integer.parseInt(height) <= 0) {
            throw new IllegalArgumentException();
        }
    }
}
