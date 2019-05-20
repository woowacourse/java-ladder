package calculator;

public class Positive {
    private final int number;

    public Positive(final String number) {
        this(Integer.parseInt(number));
    }

    public Positive(final int number) {
        if (number < 0) {
            throw new IllegalArgumentException("0 이상의 수를 입력해 주세요");
        }
        this.number = number;
    }

    int getNumber() {
        return number;
    }
}
