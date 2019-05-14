import java.util.Arrays;

public class Calculator {
    public int evaluate(String input) {
        String[] splittedInputs = input.split(",");

        return Arrays.asList(splittedInputs).stream()
                .mapToInt((splittedInput) -> Integer.parseInt(splittedInput))
                .sum();
    }
}
