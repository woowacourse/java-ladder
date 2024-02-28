package ladder.domain;

public record Destination(String value) {
    private static final int MAX_LENGTH = 5;

    public Destination {
        if (value.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("실행 결과는 5자 이하여야 합니다.");
        }
    }
}
