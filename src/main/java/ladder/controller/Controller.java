package ladder.controller;

import static ladder.domain.Player.ALL;

import java.util.LinkedHashMap;
import java.util.Map;

import ladder.domain.DefaultLadderDirectionSelector;
import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.LadderPosition;
import ladder.domain.LadderResult;
import ladder.domain.LadderResults;
import ladder.domain.Player;
import ladder.domain.Players;
import ladder.view.InputView;
import ladder.view.ResultView;

public class Controller {

    private final InputView inputView;
    private final ResultView resultView;

    public Controller(final InputView inputView, final ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void run() {
        Players players = inputView.inputNames();
        LadderResults results = inputView.inputLadderResults(players);
        Height height = inputView.inputHeight();
        Ladder ladder = Ladder.of(players, height, new DefaultLadderDirectionSelector());
        resultView.printLadder(players, ladder, results);
        while (true) {
            Player player = inputView.inputPlayerFrom(players);
            if (ALL.equals(player.name())) {
                Map<Player, LadderResult> result = climbAll(players, results, ladder);
                resultView.printAllResult(result);
                break;
            }
            LadderResult result = climb(players, player, results, ladder);
            resultView.printResult(result);
        }
    }

    public Map<Player, LadderResult> climbAll(Players players, LadderResults results, Ladder ladder) {
        Map<Player, LadderResult> allResult = new LinkedHashMap<>();
        players.players().forEach(player -> allResult.put(player, climb(players, player, results, ladder)));
        return allResult;
    }

    private LadderResult climb(Players players, Player player, LadderResults results, Ladder ladder) {
        LadderPosition startPosition = new LadderPosition(0, players.orderOf(player));
        LadderPosition endPosition = ladder.climbFrom(startPosition);
        return results.get(endPosition.column());
    }
}
