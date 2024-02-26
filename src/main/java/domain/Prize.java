package domain;

public class Prize {

    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;

    private final String prize;

    public Prize(String prize) {
        validateLength(prize);
        this.prize = prize;
    }

    public String getPrize() {
        return prize;
    }

    private void validateLength(String prize) {
        if (isInvalidLengthName(prize)) {
            throw new IllegalArgumentException("[ERROR] 결과의 길이는 " + MIN_LENGTH + "자에서 " + MAX_LENGTH + "자 사이여야 합니다");
        }
    }

    private boolean isInvalidLengthName(String prize) {
        return prize.length() < MIN_LENGTH || prize.length() > MAX_LENGTH;
    }
}
