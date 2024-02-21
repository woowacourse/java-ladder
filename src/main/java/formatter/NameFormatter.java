package formatter;

public class NameFormatter {

    public static String format(String name) {
        if (name.length() == 5) {
            return String.format("%5s", name);
        }
        return String.format("%4s ", name);
    }
}
