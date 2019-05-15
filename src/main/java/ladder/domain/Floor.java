package ladder.domain;

public class Floor {
    public static final String NAT_NUM_EXCEPTION_MESSAGE = "층 수 0이하 입력 오류";
    public static final String VALID_TYPE_EXCEPTION_MESSAGE = "층 수 입력 형식 오류";

    private int number;

    public Floor(String input) {
        int number = checkValidType(input);
        checkNatNum(number);
        this.number = number;
    }

    private void checkNatNum(int number) {
        if (number < 0) {
            throw new IllegalArgumentException(NAT_NUM_EXCEPTION_MESSAGE);
        }
    }

    private int checkValidType(String input) {
        int number;
        try {
            number = Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("층 수 입력 형식 오류");
        }
        return number;
    }

    public int getNumber() {
        return number;
    }
}
