package ladder.view;

import java.util.List;
import ladder.dto.LadderResponse;
import ladder.dto.PlayersResponse;

public class OutputView {

    public static void printResult(PlayersResponse playersResponse, LadderResponse ladderResponse) {
        System.out.println("실행결과");
        printNames(playersResponse.getPlayers());
        printLadder(ladderResponse.getLines());
    }

    private static void printLadder(List<String> lines) {
        for (String line : lines) {
            System.out.println(line);
        }
    }

    private static void printNames(String names) {
        System.out.println(names);
    }
}
