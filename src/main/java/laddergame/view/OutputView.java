package laddergame.view;

public class OutputView {
    private static final String ANNOUNCE_LADDER_RESULT = "사다리 결과";
    private static final String ANNOUNCE_MATCH_RESULTS = "실행 결과";

    public void printResult(final String ladderFrom) {
        System.out.println(ANNOUNCE_LADDER_RESULT);
        System.out.println(ladderFrom);
    }

    public void printMatchResult(final String matchForm) {
        System.out.println(ANNOUNCE_MATCH_RESULTS);
        System.out.println(matchForm);
    }
}
