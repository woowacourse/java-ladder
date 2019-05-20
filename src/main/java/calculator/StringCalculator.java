package calculator;

public class StringCalculator {
    static int calculate(String[] numbers) {
        if (isValidSize(numbers)) {
            return 0;
        }
        return plus(numbers);
    }

    private static boolean isValidSize(String[] numbers) {
        return numbers == null || numbers.length == 0;
    }

    private static int plus(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            sum += toPositive(number).getNumber();
        }
        return sum;
    }

    private static Positive toPositive(String number) {
        return new Positive(number);
    }
}
