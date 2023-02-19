package ladder.view;

import java.util.List;
import ladder.dto.LadderResponse;
import ladder.dto.PlayersResponse;
import ladder.dto.ResultsResponse;

public class OutputView {

    public static void printLadderResult(PlayersResponse playersResponse, LadderResponse ladderResponse,
                                         ResultsResponse resultsResponse) {
        System.out.println("사다리 결과");
        printNames(playersResponse.getPlayers());
        printLadder(ladderResponse.getLines());
        printResults(resultsResponse.getResults());
    }

    private static void printLadder(List<String> lines) {
        for (String line : lines) {
            System.out.println(line);
        }
    }

    private static void printNames(String names) {
        System.out.println(names);
    }

    private static void printResults(String results) {
        System.out.println(results);
    }
}
