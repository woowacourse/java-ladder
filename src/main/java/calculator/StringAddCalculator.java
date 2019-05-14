package calculator;

public class StringAddCalculator {
    private static final String COMMA = ",";
    private static final String COLON = ":";
    private static final String PIPE = "|";

    int add(String text) {
        if (isTextEmpty(text)) {
            return 0;
        }

        String[] texts = text.split(COMMA + PIPE + COLON);
        return getSum(texts);
    }

    private boolean isTextEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private int getSum(String[] texts) {
        int sum = 0;
        for (String number : texts) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }
}
