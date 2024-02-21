package ladder.domain;

public record Height(int value) {
    public Height {
        validate(value);
    }

    private void validate(int height) {
        if (height < 1) {
            throw new IllegalArgumentException("높이는 1 이상입니다.");
        }
    }
}
