package domain.ladder;

public class LadderPrize {

    private static final int MAX_RESULT_LENGTH = 5;

    private final String prize;

    public LadderPrize(String prize) {
        validate(prize);
        this.prize = prize;
    }

    private void validate(String prize) {
        if (prize.isBlank()) {
            throw new IllegalArgumentException(String.format("경품명은 공백이거나 비어있을 수 없습니다. 입력값 : %s", prize));
        }

        if (prize.length() > MAX_RESULT_LENGTH) {
            throw new IllegalArgumentException(String.format("경품명은 1글자 이상, 5글자 이하여야합니다. 입력값 : %s", prize));
        }
    }

    public String getPrize() {
        return prize;
    }
}
