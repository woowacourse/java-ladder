import domain.*;
import ui.input.InputView;
import ui.output.OutputView;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static ui.input.InputView.*;

public class Application {
    private static final String VALIDATE_INPUT_PLAYER = "존재하지 않는 플레이어를 입력할 수 없습니다.";

    public static void main(String[] args) {
        Players players = getPlayers();
        Results results = new Results(players.getPlayersCount(), Arrays.asList(InputView.getResult().split(",")));
        Lines lines = getLinesResult(players);

        OutputView.printLadderResult(players, lines, results);
        Map<String, Integer> playerPositionResults = players.calculatePosition(lines);
        Map<String, String> finalResults = getFinalResults(results, playerPositionResults, players);
        showPlayersLadderResults(players, finalResults);
    }

    private static Players getPlayers() {
        String playersName = getPlayersName();
        return new Players(Arrays.asList(playersName.split(",")));
    }

    private static Lines getLinesResult(Players players) {
        return new Lines(players.getPlayersCount(), getLadderHeight());
    }

    private static void showPlayersLadderResults(Players players, Map<String, String> finalResults) {
        String playerName = getPlayer();
        if (!playerName.equals("all") && !players.contains(playerName)) {
            throw new IllegalArgumentException(VALIDATE_INPUT_PLAYER);
        }
        OutputView.printExecuteResult(players, finalResults, playerName);
    }

    private static Map<String, String> getFinalResults(Results results, Map<String, Integer> playerPositionResults, Players players) {
        Map<String, String> finalResults = new HashMap<>();
        for (Player player : players.getPlayers()) {
            finalResults.put(player.getName(), results.getResults().get(playerPositionResults.get(player.getName())).getPrize());
        }
        return finalResults;
    }
}
