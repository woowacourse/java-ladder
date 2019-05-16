package ladder.model;

public class Floor {
    private static final String NOT_NATURAL_NUMBER_ERROR = "층 수 0이하 입력 오류";
    private static final String TYPE_ERROR = "층 수 입력 형식 오류";
    private static final int NUMBER_LOWER_BOUND = 0;

    private int number;

    public Floor(String input) {
        int number = checkValidType(input);
        checkNaturalNumber(number);
        this.number = number;
    }

    private int checkValidType(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(TYPE_ERROR);
        }
    }

    private void checkNaturalNumber(int number) {
        if (number <= NUMBER_LOWER_BOUND) {
            throw new IllegalArgumentException(NOT_NATURAL_NUMBER_ERROR);
        }
    }

    public int getNumber() {
        return number;
    }
}
