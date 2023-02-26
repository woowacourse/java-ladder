package laddergame.model;

public class Prize {
    private static final int MIN_PRIZE_LENGTH = 1;
    private static final int MAX_PRIZE_LENGTH = 5;

    private final String prize;

    public Prize(String prize) {
        validateTrimLength(prize.trim());
        this.prize = prize.trim();
    }

    private void validateTrimLength(String prize) {
        if (prize.length() < MIN_PRIZE_LENGTH || prize.length() > MAX_PRIZE_LENGTH) {
            throw new IllegalArgumentException(
                    "공백에 제거된 실행 결과의 길이는 " + MIN_PRIZE_LENGTH + "보다 크고 " + MAX_PRIZE_LENGTH + "보다 작아야 합니다.");
        }
    }

    public String getPrize() {
        return prize;
    }
}
