package calculator.domain;

import calculator.constants.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Splitter {
    private String delimiter = Constants.DEFAULT_DELIMITER;
    private String expression;

    public Splitter(String input) {
        StringTokenizer st = new StringTokenizer(input, "\\n");
        if (input.contains("//") && input.contains("\\n")) {
            this.delimiter = st.nextToken();
        }
        this.expression = st.nextToken();
    }

    public List<Integer> getExpression() {
        List<Integer> numbers = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(expression, this.getDelimiter());
        while (st.hasMoreTokens()) {
            numbers.add(Integer.valueOf(st.nextToken()));
        }
        return numbers;
    }

    private String getDelimiter() {
        return this.delimiter.replace(Constants.CUSTOM_START_IDENTIFIER, "");
    }
}