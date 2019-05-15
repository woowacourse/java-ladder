package calculator;

public class StringCalculator {
    public int input(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(s);
    }
}
