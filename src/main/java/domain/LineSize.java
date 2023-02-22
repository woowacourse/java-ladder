package domain;

public class LineSize {
    private static final int PERSON_NUMBER_LINE_SIZE_DIFFERENCE = 1;

    private final int lineSize;

    public LineSize(int personNumber) {
        lineSize = personNumber - PERSON_NUMBER_LINE_SIZE_DIFFERENCE;
    }

    public int getLineSize() {
        return lineSize;
    }
}
