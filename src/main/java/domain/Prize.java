package domain;

import java.util.Objects;

public class Prize {
    private static final int MINIMUM_PRIZE_LENGTH = 1;
    private static final int MAXIMUM_PRIZE_LENGTH = 5;

    private final String prize;

    public Prize(String prize) {
        validate(prize);
        this.prize = prize;
    }

    private void validate(String prize) {
        if (validateRange(prize)) {
            throw new IllegalArgumentException(String.format("1글자 이상 5글자 이하의 값을 입력해주세요. 입력한 값 : %s", prize));
        }
    }

    private boolean validateRange(String prize) {
        return prize.length() < MINIMUM_PRIZE_LENGTH || prize.length() > MAXIMUM_PRIZE_LENGTH;
    }

    public String getName(){
        return prize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Prize prize1 = (Prize) o;
        return Objects.equals(prize, prize1.prize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prize);
    }
}
