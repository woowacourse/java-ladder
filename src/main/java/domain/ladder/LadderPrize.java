package domain.ladder;

import domain.player.Position;
import java.util.Objects;

public class LadderPrize {

    private static final int MAX_RESULT_LENGTH = 5;

    private final String prize;
    private final Position position;

    public LadderPrize(String prize, Position position) {
        validatePrize(prize);
        this.prize = prize;
        this.position = position;
    }

    private void validatePrize(String prize) {
        if (Objects.isNull(prize) || prize.isBlank()) {
            throw new IllegalArgumentException(String.format("경품명은 공백이거나 비어있을 수 없습니다. 입력값 : %s", prize));
        }

        if (prize.length() > MAX_RESULT_LENGTH) {
            throw new IllegalArgumentException(String.format("경품명은 1글자 이상, 5글자 이하여야합니다. 입력값 : %s", prize));
        }
    }

    public boolean isSamePosition(Position otherPosition) {
        return position.equals(otherPosition);
    }

    public String getPrize() {
        return prize;
    }

    public Position getPosition() {
        return position;
    }
}
