package controller;

import domain.Height;
import domain.Ladder;
import domain.Player;
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

    private static List<Player> makePlayers(List<String> names) {
        return names.stream()
                .map(Player::new)
                .toList();
    }

    public void run() {
        List<String> names = inputView.readPlayerNames();
        List<Player> players = makePlayers(names);
        int height = inputView.readHeight();

        Ladder ladder = makeLadder(names, height);

        outputView.printResult(ladder, names);
    }

    private Ladder makeLadder(List<String> names, int height) {
        return new Ladder(names.size(), new Height(height), booleanGenerator);
    }
}
