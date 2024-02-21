package view;

import java.util.List;
import view.dto.LadderResponse;

public class OutputView {
    public void printResult(List<String> names, LadderResponse ladderResponse) {
        System.out.println();
        System.out.println("실행결과");
        System.out.println();
        printPlayers(names);
        printLadder(ladderResponse);
    }

    private void printPlayers(List<String> names) {
        StringBuilder stringBuilder = new StringBuilder();
        String firstPlayer = names.get(0);

        stringBuilder.append(firstPlayer);
        stringBuilder.append(" ".repeat(5 - firstPlayer.length()));

        for (String name : names.subList(1, names.size() - 1)) {
            stringBuilder.append(" ".repeat(6 - name.length()));
            stringBuilder.append(name);
        }

        String lastPlayer = names.get(names.size() - 1);

        stringBuilder.append(" ".repeat(5 - lastPlayer.length()));
        stringBuilder.append(lastPlayer);

        System.out.println(stringBuilder);
    }

    private void printLadder() {

    }
}
