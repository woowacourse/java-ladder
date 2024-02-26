package domain;

public class Prize {

    public Prize(String prize) {
        validateNoPrize(prize);
    }

    private void validateNoPrize(String prize) {
        if (prize == null || prize.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 결과가 없습니다.");
        }
    }
}
