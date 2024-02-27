package view.formatter;

public class ItemFormatter {
    public String format(final String itemName) {
        return String.format("%-4s", itemName);
    }
}
