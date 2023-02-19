package laddergame.view;

public class OutputView {
    private static final String ANNOUNCE_RESULT = "실행결과";

    public void printResult(final String ladderFrom) {
        System.out.println(ANNOUNCE_RESULT);
        System.out.println(ladderFrom);
    }
}
