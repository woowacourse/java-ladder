package ladder;

public class Ladder {
    public Ladder(int countOfPerson, int countOfLine) {
        checkZero(countOfLine);
    }

    private void checkZero(int countOfLine) {
        if (countOfLine <= 0) {
            throw new IllegalArgumentException();
        }
    }
}
