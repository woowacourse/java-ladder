package application;

import static java.util.stream.Collectors.toList;

import domain.ladder.Ladder;
import domain.ladder.LadderGenerator;
import domain.ladder.LadderHeight;
import domain.ladder.LadderPrize;
import domain.ladder.LadderPrizes;
import domain.player.Name;
import domain.player.Player;
import domain.player.Players;
import domain.player.Position;
import dto.GameResultDto;
import dto.ResultRequestDto;
import java.util.ArrayList;
import java.util.List;
import service.LadderGame;
import view.InputView;
import view.OutputView;

public class LadderGameApplication {

    private static final String RETRY_COUNT_OVER_EXCEPTION = "재시도 횟수를 초과하여, 어플리케이션을 종료합니다.";

    private final InputView inputView;
    private final OutputView outputView;
    private final LadderGenerator ladderGenerator;

    public LadderGameApplication(InputView inputView, OutputView outputView, LadderGenerator ladderGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.ladderGenerator = ladderGenerator;
    }

    public void run() {
        Players players = createPlayers();
        LadderHeight ladderHeight = createLadderHeight();
        LadderPrizes ladderPrizes = createLadderPrizes(players.size());

        Ladder ladder = ladderGenerator.generate(players.size(), ladderHeight);
        LadderGame ladderGame = new LadderGame(ladder, players, ladderPrizes);

        outputView.printLadderMap(players, ladder, ladderPrizes);

        printResult(ladderGame);
    }

    private Players createPlayers() {
        int countOfMaxRetry = 5;
        while (countOfMaxRetry-- > 0) {
            try {
                List<Name> names = createNames();
                List<Player> players = new ArrayList<>();
                for (int idx = 0; idx < names.size(); idx++) {
                    players.add(new Player(names.get(idx), new Position(idx + 1)));
                }
                return new Players(players);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }

        throw new IllegalStateException(RETRY_COUNT_OVER_EXCEPTION);
    }

    private List<Name> createNames() {
        return inputView.readNames()
                .stream()
                .map(Name::new)
                .collect(toList());
    }

    private LadderHeight createLadderHeight() {
        int countOfMaxRetry = 5;
        while (countOfMaxRetry-- > 0) {
            try {
                int height = inputView.readLadderHeight();
                return new LadderHeight(height);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
        throw new IllegalStateException(RETRY_COUNT_OVER_EXCEPTION);
    }

    private LadderPrizes createLadderPrizes(int size) {
        int countOfMaxRetry = 5;
        while (countOfMaxRetry-- > 0) {
            try {
                List<String> rawLadderPrizes = inputView.readLadderPrizes();
                List<LadderPrize> ladderPrizes = rawLadderPrizes.stream()
                        .map(LadderPrize::new)
                        .collect(toList());

                return LadderPrizes.createWithSameSize(ladderPrizes, size);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }

        throw new IllegalStateException(RETRY_COUNT_OVER_EXCEPTION);
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
        LadderPrize ladderPrize = ladderGame.findSinglePlayerResultByName(request.getMessage());
        outputView.printSinglePlayerResult(ladderPrize);
    }
}
