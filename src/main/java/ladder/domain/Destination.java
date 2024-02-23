package ladder.domain;

public record Destination(String value) {

    public Destination {
        if (value.length() > 5) {
            throw new IllegalArgumentException("실행 결과 수는 사용자 수와 같아야 합니다.");
        }
    }
}
