package laddergame.model;

public class Prize {
    private static final int MIN_PRIZE_LENGTH = 1;
    private static final int MAX_PRIZE_LENGTH = 5;

    private final String prize;

    public Prize(String prize) {
        String prize2 = prize.trim();
        if (prize2.length() < MIN_PRIZE_LENGTH || prize2.length() > MAX_PRIZE_LENGTH) {
            throw new IllegalArgumentException(
                    "[ERROR] 공백에 제거된 당첨 결과의 길이는 " + MIN_PRIZE_LENGTH + "보다 크고 " + MAX_PRIZE_LENGTH + "보다 작아야 합니다.");
        }
        this.prize = prize2;
    }

    public String getPrize() {
        return prize;
    }
}
