package domain;

public enum LadderPrinter {

    BAR("|-----"),
    NON_BAR("|     ");

    private final String singleLine;

    LadderPrinter(String singleLine) {
        this.singleLine = singleLine;
    }

    public static String generateSingleLine(Line line) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("    ");
        for (Boolean point : line.getPoints()) {
            stringBuilder.append(convert(point));
        }
        stringBuilder.append("|");
        return stringBuilder.toString();
    }

    private static String convert(boolean point) {
        if (point) return BAR.singleLine;
        return NON_BAR.singleLine;
    }
}
