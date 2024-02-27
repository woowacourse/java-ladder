package view;

import java.util.List;

public class OutputView {

    public void printLadderResultMessage() {
        System.out.println("\n사다리 결과");
    }

    public void printResultMessage() {
        System.out.print("\n실행결과\n");
    }

    public void printLadder(List<String> ladder) {
        System.out.println(String.join("\n", ladder));
    }
}
