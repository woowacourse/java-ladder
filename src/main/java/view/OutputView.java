package view;

import java.util.List;

public class OutputView {

    public void printPlayers(String result) {
        System.out.println("\n사다리 결과\n" + result);
    }

    public void printLadderOutput(List<String> ladder) {
        System.out.println(String.join("\n", ladder));
    }

    public void printResultsOutput(String result) {
        System.out.println(result);
    }
}
