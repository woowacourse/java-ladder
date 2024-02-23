package ladder.controller;

import java.util.List;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderHeight;
import ladder.domain.ladder.generator.BooleanGenerator;
import ladder.domain.player.Player;
import ladder.domain.player.Players;
import ladder.dto.response.LadderResponse;
import ladder.dto.response.PlayersResponse;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BooleanGenerator booleanGenerator;

    public LadderController(InputView inputView, OutputView outputView, BooleanGenerator booleanGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.booleanGenerator = booleanGenerator;
    }

    public void run() {
        Players players = readPlayers();
        LadderHeight ladderHeight = readLadderHeight();

        Ladder ladder = new Ladder(players.getSize(), ladderHeight, booleanGenerator);

        printLadder(players, ladder);
    }

    public Players readPlayers() {
        List<String> playerNames = inputView.readPlayerNames();
        List<Player> players = playerNames.stream().map(Player::new).toList();

        return new Players(players);
    }

    public LadderHeight readLadderHeight() {
        int ladderHeight = inputView.readLadderHeight();

        return new LadderHeight(ladderHeight);
    }

    private void printLadder(Players players, Ladder ladder) {
        outputView.printLadderResultMessage();
        outputView.printPlayerNames(PlayersResponse.from(players));
        outputView.printLadder(LadderResponse.from(ladder));
    }
}
