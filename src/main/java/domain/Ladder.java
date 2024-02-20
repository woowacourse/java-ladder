package domain;

public class Ladder {

    public Ladder(int personCount, int height) {
        validate(personCount, height);
    }

    private void validate(int personCount, int height) {
        if (height <= 0) {
            throw new IllegalArgumentException(); // TODO 예외 메시지
        }
        if (personCount <= 0) {
            throw new IllegalArgumentException(); // TODO 예외 메시지
        }

    }
}
