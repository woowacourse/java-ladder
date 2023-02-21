package domain;

public class LineSize {
    private static final int PERSON_NUMBER_LINE_SIZE_DIFFERENCE = 1;

    private final int lineSize;

    public LineSize(Names names) {
        lineSize = names.getPersonNumber() - PERSON_NUMBER_LINE_SIZE_DIFFERENCE;
    }

    public int getLineSize() {
        return lineSize;
    }
}
