import domain.*;
import ui.input.InputView;
import ui.output.OutputView;

import java.util.Arrays;

import static ui.input.InputView.*;

public class Application {
    private static final String VALIDATE_INPUT_PLAYER = "존재하지 않는 플레이어를 입력할 수 없습니다.";
    public static void main(String[] args) {
        Players players = getPlayers();
        Results results = new Results(players.getPlayersCount(), Arrays.asList(InputView.getResult().split(COMMA)));
        Lines lines = getLinesResult(players);

        OutputView.printLadderResult(players, lines, results);
        lines.calculateResults(players, results);
        showPlayersLadderResults(players, results);
    }

    private static Players getPlayers() {
        String playersName = getPlayersName();
        return new Players(Arrays.asList(playersName.split(COMMA)));
    }

    private static Lines getLinesResult(Players players) {
        return new Lines(players.getPlayersCount(), getLadderHeight());
    }

    private static void showPlayersLadderResults(Players players, Results results) {
        String playerName = getPlayer();
        if (!playerName.equals("all") && !players.isIncludePlayerName(playerName)) {
            throw new IllegalArgumentException(VALIDATE_INPUT_PLAYER);
        }
        OutputView.printExecuteResult(players, results, playerName);
    }
}
