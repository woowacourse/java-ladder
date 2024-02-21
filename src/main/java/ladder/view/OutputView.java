package ladder.view;

import ladder.domain.People;

/*
실행결과

 pobi honux crong    jk
    |-----|     |-----|
    |     |-----|     |
    |-----|     |     |
    |     |-----|     |
    |-----|     |-----|
 */
public class OutputView {
    private static final String EXECUTION_RESULT = "실행결과";

    private OutputView() {
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }
}
