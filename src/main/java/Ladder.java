public class Ladder {
    int height;

    public Ladder(int height) {
        validateHeight(height);
        this.height = height;
    }

    public void validateHeight(int height) {
        if (height < 1) {
            throw new IllegalArgumentException();
        }
    }
}
