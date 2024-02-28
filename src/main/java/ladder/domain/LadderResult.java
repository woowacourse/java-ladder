package ladder.domain;

public record LadderResult(String value) {

    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;

    public LadderResult {
        if (value.isBlank() || value.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(
                    "결과는 %d~%d글자로 입력해주세요: %s".formatted(
                            MIN_LENGTH,
                            MAX_LENGTH,
                            value
                    ));
        }
    }
}
