package application;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import domain.Ladder;
import domain.LadderHeight;
import domain.Name;
import domain.Player;
import domain.Players;
import java.util.List;
import java.util.function.Supplier;
import utils.RandomNumberGenerator;
import view.InputView;
import view.OutputView;

public class LadderGameApplication {

    private final InputView inputView;
    private final OutputView outputView;

    public LadderGameApplication(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Players players = repeat(this::createPlayers);
        LadderHeight ladderHeight = repeat(inputView::readLadderHeight);
        Ladder ladder = Ladder.create(players.size(), ladderHeight, new RandomNumberGenerator());

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
