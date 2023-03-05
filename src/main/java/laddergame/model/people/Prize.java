package laddergame.model.people;

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
            String message = String.format("공백이 제거된 실행 결과의 길이는 %d보다 크고, %d보다 작아야 합니다."
                    , MIN_PRIZE_LENGTH, MAX_PRIZE_LENGTH);
            throw new IllegalArgumentException(message);
        }
    }

    public String getPrize() {
        return prize;
    }
}
