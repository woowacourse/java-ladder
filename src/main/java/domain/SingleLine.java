package domain;

public enum SingleLine {

    BAR("|-----"),
    NON_BAR("|     ");

    private final String singleLine;

    SingleLine(final String singleLine) {
        this.singleLine = singleLine;
    }

    public static String generateSingleLine(final Line line) {
        return "    " + drawLine(line);
    }

    private static String drawLine(Line line) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Boolean point : line.getPoints()) {
            stringBuilder.append(convert(point));
        }
        stringBuilder.append("|");
        return stringBuilder.toString();
    }

    private static String convert(final boolean point) {
        if (point) {
            return BAR.singleLine;
        }
        return NON_BAR.singleLine;
    }
}
