package application;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import domain.LadderResultRequest;
import domain.ladder.Ladder;
import domain.ladder.LadderGenerator;
import domain.ladder.LadderHeight;
import domain.player.Name;
import domain.player.Player;
import domain.player.Players;
import domain.player.Position;
import dto.PlayerLadderResult;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;
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
        outputView.printLadder(players, ladder);

        printResult(players, ladder);
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

    private Players createPlayers() {
        List<Name> names = inputView.readNames();

        return IntStream.range(0, names.size())
                .mapToObj(idx -> new Player(names.get(idx), new Position(idx + 1)))
                .collect(collectingAndThen(toList(), Players::new));
    }

    private void printResult(Players players,
                             Ladder ladder) {
        while (true) {
            LadderResultRequest request = inputView.readSpecificResult();

            if (request.isAll()) {
                printEveryPlayerResult(players, ladder);
                return;
            }

            if (!request.isPlayerName(players)) {
                outputView.printNoMatchingPlayerMessage(request);
                continue;
            }

            Player findPlayer = players.findSpecificNamePlayer(request.getMessage());
            printSinglePlayerResult(findPlayer, ladder);
        }
    }

    private void printEveryPlayerResult(Players players, Ladder ladder) {
        List<PlayerLadderResult> everyPlayerResult = getEveryPlayerResult(players, ladder);
        outputView.printEveryPlayerResult(everyPlayerResult);
    }

    private List<PlayerLadderResult> getEveryPlayerResult(Players players, Ladder ladder) {
        return players.stream()
                .map(player -> {
                    String result = ladder.play(player);
                    return new PlayerLadderResult(player.getName(), result);
                })
                .collect(toList());
    }

    private void printSinglePlayerResult(Player player, Ladder ladder) {
        String singlePlayerResult = ladder.play(player);
        outputView.printSinglePlayerResult(singlePlayerResult);
    }
}
