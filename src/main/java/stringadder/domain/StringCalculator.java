package stringadder.domain;

import java.util.List;

public class StringCalculator {
    public static int calculateSumOf(String input) {
        StringSpliter stringSpliter = new StringSpliter();
        String numberString = stringSpliter.setAdditionalSeparatorsFrom(input);
        List<String> numbersBeforeConvert = stringSpliter.splitBySeparators(numberString);
        List<Integer> numbers = IntegerConverter.convert(numbersBeforeConvert);
        return IntegerAdder.add(numbers);
    }
}
