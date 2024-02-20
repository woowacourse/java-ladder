package domain;

public class LadderHeight {
    private final int value;

    public LadderHeight(String value) {

        try {
            Integer.parseInt(value);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException();
        }
        int height = Integer.parseInt(value);

        if (height < 2 || height > 10) {
            throw new IllegalArgumentException();
        }
        this.value = height;
    }

    public int getValue() {
        return value;
    }
}
