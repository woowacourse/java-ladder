package view;

import java.util.List;

public class OutputView {

    public void printLadder(List<String> ladder) {
        System.out.println(String.join("\n", ladder));
    }

    public void printResult(String result) {
        System.out.println("\n실행 결과\n" + result);
    }
}
