package view;

import java.util.List;

public class OutputView {

    public void printResultMessage() {
        System.out.print("\n실행결과\n");
    }

    public void printLadder(List<String> ladder) {
        System.out.println(String.join("\n", ladder));
    }
}
