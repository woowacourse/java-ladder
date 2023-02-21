package application;

import domain.ladder.Ladder;
import domain.ladder.LadderGenerator;
import domain.ladder.LadderHeight;
import domain.player.Name;
import domain.player.Player;
import domain.player.Players;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import view.InputView;
import view.OutputView;

public class LadderGameApplication {

    private final InputView inputView;
    private final OutputView outputView;
    private final LadderGenerator ladderGenerator;

    public LadderGameApplication(InputView inputView, OutputView outputView, LadderGenerator ladderGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.ladderGenerator = ladderGenerator;
    }

    public void run() {
        Players players = retryIfError(this::createPlayers);
        LadderHeight ladderHeight = retryIfError(inputView::readLadderHeight);
        List<String> ladderResults = retryIfError(inputView::readLadderResults);

        Ladder ladder = ladderGenerator.generate(players.size(), ladderHeight, ladderResults);
        outputView.printResult(players, ladder);

        Player player = players.findSpecificNamePlayer(inputView.readSpecificResult());
        String result = player.play(ladder);

//        outputView.printSinglePlayerResult(player, result);
    }

    private Players createPlayers() {
        List<Name> names = inputView.readNames();

        List<Player> players = new ArrayList<>();
        for (int idx = 0; idx < names.size(); idx++) {
            players.add(new Player(names.get(idx), idx + 1));
        }

        return new Players(players);
    }

    private <T> T retryIfError(Supplier<T> inputSupplier) {
        while (true) {
            try {
                return inputSupplier.get();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
