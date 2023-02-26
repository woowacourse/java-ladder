package controller;

import common.ExecuteContext;
import domain.model.Ladder;
import domain.model.Player;
import domain.model.Players;
import domain.model.Result;
import domain.model.Results;
import domain.model.LadderGame;
import domain.vo.Height;
import domain.vo.Width;
import java.util.Map;
import view.InputView;
import view.OutputView;

public class LadderController {

    private static final int NAMES_WIDTH_DIFFERENCE = 1;
    private static final String ALL = "all";
    public static final String NAME_NOT_FOUND_ERROR_MESSAGE = "해당 이름이 존재하지 않습니다.";
    private final InputView inputView;
    private final OutputView outputView;
    private final LadderGame ladderGame;

    public LadderController(final InputView inputView, final OutputView outputView, final LadderGame ladderGame) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.ladderGame = ladderGame;
    }

    public void play() {
        final Players players = getPlayers();
        final Results results = getResults(players.size());
        final Width width = new Width(players.size() - NAMES_WIDTH_DIFFERENCE);
        final Ladder ladder = ladderGame.makeLadder(getHeight(), width);
        outputView.printLadder(players, ladder, results);
        final Map<Player, Result> resultBoard = ladderGame.makeResultBoard(ladder, players, results);
        ExecuteContext.workWithExecuteStrategy(() -> printResult(resultBoard));
    }

    private Boolean printResult(final Map<Player, Result> resultBoard) {
        final String input = inputView.inputResultTarget();
        final Player player = new Player(input);
        if (player.getName().equals(ALL)) {
            outputView.printAllResult(resultBoard);
            return true;
        }
        printOneResult(resultBoard, player);
        return printResult(resultBoard);
    }

    private void printOneResult(final Map<Player, Result> resultBoard, final Player player) {
        if (resultBoard.containsKey(player)) {
            outputView.printResult(resultBoard.get(player));
            return;
        }
        throw new IllegalArgumentException(NAME_NOT_FOUND_ERROR_MESSAGE);
    }

    private Players getPlayers() {
        return ExecuteContext.workWithExecuteStrategy(() -> new Players(inputView.inputPlayers()));
    }

    private Height getHeight() {
        return ExecuteContext.workWithExecuteStrategy(() -> new Height(inputView.inputLadderHeight()));
    }

    private Results getResults(final int playersSize) {
        return ExecuteContext.workWithExecuteStrategy(() -> new Results(inputView.inputResults(playersSize))
        );
    }
}
