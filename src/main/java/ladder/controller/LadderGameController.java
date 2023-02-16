package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.LadderMaker;
import ladder.domain.Player;
import ladder.domain.Players;
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
        List<String> playerNames = InputView.inputPlayer();
        return new Players(playerNames);
    }

    private Ladder initLadder(int playerNumber) {
        int height = InputView.inputLadderHeight();
        LadderMaker ladderMaker = new LadderMaker();
        return ladderMaker.makeLadder(playerNumber, height);
    }

    private List<String> mapPlayersToPlayersName(Players players) {
        return players.getPlayers().stream()
                .map(Player::getName)
                .collect(Collectors.toUnmodifiableList());
    }

    private void showResult(Players players, Ladder ladder) {
        List<String> playersName = mapPlayersToPlayersName(players);
        OutputView.printGameResultHeader();
        OutputView.printPlayersName(playersName);
        OutputView.printLadder(ladder);
    }
}
