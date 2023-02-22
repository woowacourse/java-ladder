package ladder.domain.reward;

public enum Continue {
    CONTINUE("Y"),
    STOP("N");

    private final String value;

    Continue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Continue getContinue(String inputContinue) {
        validateBlank(inputContinue);
        String inputContinueToUpperCase = inputContinue.toUpperCase();
        validateYOrN(inputContinueToUpperCase);
        if (inputContinueToUpperCase.equals(CONTINUE.getValue())) {
            return CONTINUE;
        }
        return STOP;
    }

    private static void validateBlank(String inputContinue) {
        if (inputContinue.isBlank()) {
            throw new IllegalArgumentException("공백은 입력할 수 없습니다.");
        }
    }

    private static void validateYOrN(String inputContinue) {
        if ((!inputContinue.equals(CONTINUE.getValue())) && (!inputContinue.equals(STOP.getValue()))) {
            throw new IllegalArgumentException("y 혹은 n만 입력해주세요.");
        }
    }

}
