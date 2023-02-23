package application;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import domain.LadderResultRequest;
import domain.ladder.Ladder;
import domain.ladder.LadderGame;
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
        LadderGame ladderGame = new LadderGame(ladder, players);

        outputView.printLadderMap(players, ladder);

        printResult(ladderGame);
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

    private void printResult(LadderGame ladderGame) {
        while (true) {
            LadderResultRequest request = inputView.readSpecificResult();

            if (request.isAll()) {
                printEveryPlayerResult(ladderGame);
                return;
            }

            if (ladderGame.isNotMatchingPlayerByName(request.getMessage())) {
                outputView.printNoMatchingPlayerMessage(request);
                continue;
            }

            printSinglePlayerResult(ladderGame, request);
        }
    }

    private void printEveryPlayerResult(LadderGame ladderGame) {
        List<PlayerLadderResult> allPlayerResult = ladderGame.findAllPlayerResult();
        outputView.printAllPlayerResult(allPlayerResult);
    }

    private void printSinglePlayerResult(LadderGame ladderGame, LadderResultRequest request) {
        LadderResult ladderResult = ladderGame.findSinglePlayerResultByName(request.getMessage());
        outputView.printSinglePlayerResult(ladderResult);
    }
}
