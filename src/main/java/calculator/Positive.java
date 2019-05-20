package calculator;

public class Positive {
    private final int number;

    public Positive(final String number) {
        this(Integer.parseInt(number));
    }

    public Positive(final int number) {
        if (number < 0) {
            throw new RuntimeException();
        }
        this.number = number;
    }

    int getNumber() {
        return number;
    }
}
