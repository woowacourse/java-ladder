package domain;

public class Ladder {

    public Ladder(int height) {
        if (height < 5 || height > 10) {
            throw new RuntimeException("사다리 높이는 5이상 10 이하여야 합니다.");
        }
    }
}
