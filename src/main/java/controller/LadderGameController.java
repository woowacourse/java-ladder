package controller;

import domain.Height;
import domain.Ladder;
import domain.Player;
import domain.Players;
import domain.booleangenerator.BooleanGenerator;
import java.util.List;
import view.InputView;
import view.OutputView;

public class LadderGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final BooleanGenerator booleanGenerator;

    public LadderGameController(InputView inputView, OutputView outputView, BooleanGenerator booleanGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.booleanGenerator = booleanGenerator;
    }

    public void run() {
        List<String> names = inputView.readPlayerNames();
        Players players = new Players(makePlayers(names));
        int height = inputView.readHeight();

        Ladder ladder = makeLadder(players.getSize(), height);

        outputView.printResult(ladder, names);
    }

    private List<Player> makePlayers(List<String> names) {
        return names.stream()
                .map(Player::new)
                .toList();
    }

    private Ladder makeLadder(int playerCount, int height) {
        return new Ladder(playerCount, new Height(height), booleanGenerator);
    }
}
