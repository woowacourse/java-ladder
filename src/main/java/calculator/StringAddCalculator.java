package calculator;

public class StringAddCalculator {
    private static final String COMMA = ",";

    int add(String text) {
        if (isTextEmpty(text)) {
            return 0;
        }

        String[] texts = text.split(COMMA);
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
