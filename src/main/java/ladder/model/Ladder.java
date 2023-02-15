package ladder.model;

public class Ladder {

    public Ladder(int height) {
        validateHeight(height);
    }

    private void validateHeight(int height) {
        if (height < ConstantNumber.MIN_HEIGHT.getNumber()) {
            throw new IllegalArgumentException(ErrorMessage.EXCEPTION_INVALID_HEIGHT.getMessage());
        }
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

    private enum ConstantNumber {

        MIN_HEIGHT(2);

        private final int number;

        ConstantNumber(int number) {
            this.number = number;
        }

        public int getNumber() {
            return number;
        }
    }
}
