package application;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import domain.LadderResultRequest;
import domain.ladder.Ladder;
import domain.ladder.LadderGenerator;
import domain.ladder.LadderHeight;
import domain.ladder.LadderResult;
import domain.ladder.LadderResults;
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
        LadderResults ladderResults = retryIfError(() -> createLadderResults(players.size()));

        Ladder ladder = ladderGenerator.generate(players.size(), ladderHeight, ladderResults);
        outputView.printLadderMap(players, ladder);

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

    private LadderResults createLadderResults(int size) {
        List<LadderResult> ladderResults = inputView.readLadderResults();
        return LadderResults.createByPlayersSize(ladderResults, size);
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
                    LadderResult ladderResult = ladder.play(player);
                    return new PlayerLadderResult(player.getName(), ladderResult.getResult());
                })
                .collect(toList());
    }

    private void printSinglePlayerResult(Player player, Ladder ladder) {
        LadderResult ladderResult = ladder.play(player);
        outputView.printSinglePlayerResult(ladderResult);
    }
}
