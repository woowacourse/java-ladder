package ladder.domain;

public class Line {

    private static final int LINE_GENERATING_NUMBER = 1;
    private boolean isExist = false;

    public void make(int number) {
        if (number == LINE_GENERATING_NUMBER) {
            isExist = true;
        }
    }
}
