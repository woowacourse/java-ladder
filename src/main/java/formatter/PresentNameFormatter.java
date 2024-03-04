package formatter;

public class PresentNameFormatter {

    public static String format(final String name) {
        if (name.length() == 5) {
            return String.format("%5s", name);
        }
        return String.format("%4s ", name);
    }
}
