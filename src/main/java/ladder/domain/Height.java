package ladder.domain;

public class Height {

    public Height(int value) {
        if (value < 1) {
            throw new IllegalArgumentException("사다리 높이는 1 이상이어야 합니다.");
        }
    }
}
