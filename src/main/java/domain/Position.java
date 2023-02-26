package domain;

public class Position {

    private int value;

    public Position(int value) {
        this.value = value;
    }

    public void moveToRight() {
        value++;
    }

    public void moveToLeft() {
        value--;
    }

    public int value() {
        return value;
    }

}
