package ladder.model;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private static final int MIN_HEIGHT = 2;

    private final List<Raw> ladder;

    public Ladder(List<Raw> ladder) {
        validateHeight(ladder.size());
        this.ladder = ladder;
    }

    private void validateHeight(int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException(ErrorMessage.EXCEPTION_INVALID_HEIGHT.getMessage());
        }
    }

    public List<Raw> getRaws() {
        return ladder;
    }


    private enum ErrorMessage {
        EXCEPTION_INVALID_HEIGHT("사다리 높이는 2 이상이어야 합니다.");
        private final String message;

        ErrorMessage(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
