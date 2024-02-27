package view;

import java.util.List;
import java.util.Map;

public class OutputView {

    public void printLadderResultMessage() {
        System.out.println("\n사다리 결과");
    }

    public void printLadder(List<String> ladder) {
        System.out.println(String.join("\n", ladder));
    }

    public void printResultMessage() {
        System.out.print("\n실행결과\n");
    }

    public void printPlayerResult(String prize) {
        System.out.println(prize);
    }

    public void printAllPlayerResults(Map<String, String> results) {
        for (String name : results.keySet()) {
            System.out.println(name + " : " + results.get(name));
        }
    }
}
