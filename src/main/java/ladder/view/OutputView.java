package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Names;

public class OutputView {

    public void printResult(Names names, Ladder ladder) {
        System.out.println("실행결과");
        System.out.println(names);
        System.out.println(ladder);
    }

    public void printError(String message) {
        System.out.println(message);
    }
}
