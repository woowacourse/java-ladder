package ladderGame.model.input;

public class RowNumberValidator {
    private static final int MIN_ROW_NUMBER = 1;

    public static void validates(int rowNumber) {
        if(rowNumber > MIN_ROW_NUMBER) {
            throw new IllegalStateException();
        }
    }
}

