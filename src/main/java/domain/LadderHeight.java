package domain;

public class LadderHeight {

    private final int value;

    public LadderHeight(int value, int numberOfPeople) {
        validate(value, numberOfPeople);
        this.value = value;
    }

    private void validate(int value, int numberOfPeople) {
        if (value < numberOfPeople - 1) {
            throw new IllegalArgumentException(String.format("사다리의 높이는 (참여할 사람 수 - 1) 보다 커야합니다. 입력값 : %s", value));
        }
    }

    public int value() {
        return this.value;
    }
}
