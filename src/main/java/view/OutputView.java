package view;

import java.util.List;
import view.dto.LadderResponse;
import view.dto.LineResponse;

public class OutputView {
    public void printResult(List<String> names, LadderResponse ladderResponse) {
        System.out.printf("%n실행결과%n%n");
        printPlayers(names);
        printLadder(names.get(0).length(), ladderResponse);
    }

    private void printPlayers(List<String> names) {

    }

    private void printLadder(int paddingSize, LadderResponse ladderResponse) {
        StringBuilder stringBuilder = new StringBuilder();
        for(LineResponse lineResponse : ladderResponse.getLadderResponse()) {
            stringBuilder.append(" ".repeat(paddingSize));

            stringBuilder.append(lineResponse.getValue());
            stringBuilder.append("%n");
        }
        System.out.printf(stringBuilder.toString());
    }
}
