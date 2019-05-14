package stringcalculator;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    private List<Integer> numbers = new ArrayList<>();

    public StringCalculator(String formula) {
        if (StringUtils.isBlank(formula)) {
            numbers.add(0);
        }
    }

    public int calculate() {
        return numbers.stream().reduce(0, Integer::sum);
    }
}
