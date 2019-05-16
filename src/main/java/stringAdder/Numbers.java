package stringAdder;

public class Numbers {
    public static int[] toInts(String[] values) {
        int[] numbers = new int[values.length];

        for (int i = 0; i < values.length; i++) {
            int value = validateNumber(values, i);
            Numbers.validatePositiveNumber(value);
            numbers[i] = value;
        }

        return numbers;
    }

    private static void validatePositiveNumber(int value) {
        if (value < 0) {
            throw new RuntimeException("음수입니다.");
        }
    }

    static int validateNumber(String[] values, int i) {
        int value;
        try {
            value = Integer.parseInt(values[i]);
        } catch (NumberFormatException e) {
            throw new RuntimeException("문자가 포함되었습니다.");
        }
        return value;
    }
}
