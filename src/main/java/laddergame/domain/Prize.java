package laddergame.domain;

public class Prize {

    private final String prize;
    public Prize(String prize) {
        validatePrize(prize);
        this.prize = prize;
    }

    private void validatePrize(String prize) {
        if (prize.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 사다리 상품은 공백이 아니여야 합니다.");
        }
    }
}
