package ladder.domain;

public class Height {

    //todo: 변수명 & 메서드명 변경
    private final int value;

    public Height(int value) {
        this.value = value;
    }

    public boolean isSame(int size) {
        return size == value;
    }
}
