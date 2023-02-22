package laddergame.view;


public class OutputView {
    public void printResult(final String ladderFrom) {
        System.out.println("실행결과");
        System.out.println(ladderFrom);
    }

    public static void printExceptionMessage(final String message) {
        System.out.println(message);
    }
}
