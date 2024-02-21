package domain;

class Ladder {

    public Ladder(int height, int playerSize) {
        if (height < 1) {
            throw new IllegalArgumentException("사다리의 높이는 최소 1 이어야 합니다.");
        }
    }
}
