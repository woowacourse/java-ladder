package view;

import java.util.List;

public class OutputView {

    public void printParticipantLineUp(String result) {
        System.out.println("\n실행 결과\n" + result);
    }

    public void printLadderOutput(List<String> ladder) {
        System.out.println(String.join("\n", ladder));
    }

    public void printResultsOutput(String result) {
        System.out.println(result);
    }
}
