package application;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import domain.ladder.Ladder;
import domain.ladder.LadderGenerator;
import domain.ladder.LadderHeight;
import domain.player.Name;
import domain.player.Player;
import domain.player.Players;
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
        Players players = repeat(this::createPlayers);
        LadderHeight ladderHeight = repeat(inputView::readLadderHeight);
        Ladder ladder = ladderGenerator.generate(players.size(), ladderHeight);

        outputView.printResult(players, ladder);
    }

    private Players createPlayers() {
        List<Name> names = inputView.readNames();
        return names.stream()
                .map(Player::new)
                .collect(collectingAndThen(toList(), Players::new));
    }

    private <T> T repeat(Supplier<T> inputSupplier) {
        while (true) {
            try {
                return inputSupplier.get();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
