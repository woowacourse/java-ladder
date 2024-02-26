package domain;

public class Prize {

    private final String prize;

    public Prize(String prize) {
        validateNoPrize(prize);
        this.prize = prize;
    }

    private void validateNoPrize(String prize) {
        if (prize == null || prize.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 결과가 없습니다.");
        }
    }

    public String getPrize() {
        return prize;
    }
}
