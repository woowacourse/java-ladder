package calculator.domain;

import java.util.Objects;

public class Number {
    private final int number;

    public Number(String number){
        this.number = parseNumber(number);
        if (this.number < 0) {
            throw new RuntimeException("0 이상의 정수를 입력하세요");
        }
    }

    private int parseNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new RuntimeException("문자를 입력하지마세요");
        }
    }

    public int plus(int sum) {
        return this.number + sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Number)) return false;
        Number number1 = (Number) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
