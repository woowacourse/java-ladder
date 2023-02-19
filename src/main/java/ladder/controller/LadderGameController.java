package ladder.controller;

import ladder.domain.builder.LadderMaker;
import ladder.domain.builder.RandomBlockGenerator;
import ladder.domain.ladder.Block;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.Line;
import ladder.domain.player.Players;
import ladder.exception.CustomException;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGameController {

    public void run() {
        Players players = initPlayers();
        Ladder ladder = initLadder(players.size());

        showResult(players, ladder);
    }

    private Players initPlayers() {
        try {
            List<String> playerNames = InputView.inputPlayer();
            return new Players(playerNames);
        } catch (CustomException e) {
            OutputView.printErrorMessage(e);
            return initPlayers();
        }
    }

    private Ladder initLadder(int playerNumber) {
        try {
            final int height = InputView.inputLadderHeight();
            LadderMaker ladderMaker = new LadderMaker(new RandomBlockGenerator());
            return ladderMaker.makeLadder(playerNumber, height);
        } catch (CustomException e) {
            OutputView.printErrorMessage(e);
            return initLadder(playerNumber);
        }
    }

    private void showResult(Players players, Ladder ladder) {
        List<String> playersName = toPlayersName(players);
        OutputView.printGameResultHeader();
        OutputView.printPlayersName(playersName);
        OutputView.printLadder(toLines(ladder));
    }

    private List<String> toPlayersName(Players players) {
        return players.getPlayers().stream()
                .map(player -> player.getPlayerName().getName())
                .collect(Collectors.toUnmodifiableList());
    }

    private List<List<Boolean>> toLines(Ladder ladder) {
        return ladder.getLines().stream()
                .map(this::toBlocks)
                .collect(Collectors.toUnmodifiableList());
    }

    private List<Boolean> toBlocks(Line line) {
        return line.getBlocks().stream()
                .map(Block::isExistBlock)
                .collect(Collectors.toUnmodifiableList());
    }
}
