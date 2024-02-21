package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.People;

public class OutputView {

    public void printResult(People people, Ladder ladder) {
        System.out.println("실행결과");
        System.out.println(people);
        System.out.println(ladder);
    }

    public void printError(String message) {
        System.out.println(message);
    }
}
