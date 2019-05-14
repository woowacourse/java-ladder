package calculator;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    public static List<Integer> getFromString(String input, String delimiter) {
        String[] processedInput = input.split("\n");
        List<Integer> numbers = new ArrayList<>();
        String[] stringNumbers = processedInput[1].split(delimiter);
        for (int i = 0; i < stringNumbers.length ; i++) {
            numbers.add(Integer.valueOf(stringNumbers[i]));
        }
        return numbers;
    }
}
