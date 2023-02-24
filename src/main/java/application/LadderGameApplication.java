package application;

import static java.util.stream.Collectors.toList;

import domain.ladder.Ladder;
import domain.ladder.LadderGenerator;
import domain.ladder.LadderHeight;
import domain.ladder.LadderResult;
import domain.ladder.LadderResults;
import domain.player.Name;
import domain.player.Player;
import domain.player.Players;
import domain.player.Position;
import dto.GameResultDto;
import dto.ResultRequestDto;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import service.LadderGame;
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
        LadderHeight ladderHeight = retryIfError(this::createLadderHeight);
        LadderResults ladderResults = retryIfError(() -> createLadderResults(players.size()));

        Ladder ladder = ladderGenerator.generate(players.size(), ladderHeight);
        LadderGame ladderGame = new LadderGame(ladder, players, ladderResults);

        outputView.printLadderMap(players, ladder, ladderResults);

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
        List<Name> names = createNames();

        List<Player> players = new ArrayList<>();
        for (int idx = 0; idx < names.size(); idx++) {
            players.add(new Player(names.get(idx), new Position(idx + 1)));
        }

        return new Players(players);
    }

    private List<Name> createNames() {
        return inputView.readNames()
                .stream()
                .map(Name::new)
                .collect(toList());
    }

    private LadderHeight createLadderHeight() {
        int height = inputView.readLadderHeight();
        return new LadderHeight(height);
    }

    private LadderResults createLadderResults(int size) {
        List<String> rawLadderResults = inputView.readLadderResults();
        List<LadderResult> ladderResults = rawLadderResults.stream()
                .map(LadderResult::new)
                .collect(toList());

        return LadderResults.createWithSameSize(ladderResults, size);
    }

    private void printResult(LadderGame ladderGame) {
        while (true) {
            ResultRequestDto request = inputView.readSpecificResult();

            if (request.isAll()) {
                printEveryPlayerResult(ladderGame);
                return;
            }

            if (!ladderGame.isPlayerExistByName(request.getMessage())) {
                outputView.printPlayerNotExistMessage(request);
                continue;
            }

            printSinglePlayerResult(ladderGame, request);
        }
    }

    private void printEveryPlayerResult(LadderGame ladderGame) {
        List<GameResultDto> allPlayerResult = ladderGame.findAllPlayerResult();
        outputView.printAllPlayerResult(allPlayerResult);
    }

    private void printSinglePlayerResult(LadderGame ladderGame, ResultRequestDto request) {
        LadderResult ladderResult = ladderGame.findSinglePlayerResultByName(request.getMessage());
        outputView.printSinglePlayerResult(ladderResult);
    }
}
