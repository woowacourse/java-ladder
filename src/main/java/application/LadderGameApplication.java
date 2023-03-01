package application;

import static java.util.stream.Collectors.toList;

import domain.RetryCount;
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

    public static final String RETRY_COUNT_OVER_EXCEPTION_MESSAGE = "재시도 횟수를 초과하여, 어플리케이션을 종료합니다.";

    private final InputView inputView;
    private final OutputView outputView;
    private final LadderGenerator ladderGenerator;

    public LadderGameApplication(InputView inputView, OutputView outputView, LadderGenerator ladderGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.ladderGenerator = ladderGenerator;
    }

    public void run() {
        Players players = createPlayers(new RetryCount(5));
        LadderHeight ladderHeight = createLadderHeight(new RetryCount(5));
        LadderPrizes ladderPrizes = createLadderPrizes(new RetryCount(5));

        Ladder ladder = ladderGenerator.generate(players.size(), ladderHeight);
        LadderGame ladderGame = new LadderGame(ladder, players, ladderPrizes);

        outputView.printLadderMap(players, ladder, ladderPrizes);

        printResult(ladderGame);
    }

    private Players createPlayers(RetryCount retryCount) {
        while (!retryCount.isLimit()) {
            try {
                List<Name> names = createNames();
                List<Player> players = createRawPlayers(names);
                return new Players(players);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
                retryCount.decrease();
            }
        }
        throw new IllegalStateException(RETRY_COUNT_OVER_EXCEPTION_MESSAGE);

    }

    private List<Name> createNames() {
        return inputView.readNames()
                .stream()
                .map(Name::new)
                .collect(toList());
    }

    private static List<Player> createRawPlayers(List<Name> names) {
        List<Player> players = new ArrayList<>();
        for (int idx = 0; idx < names.size(); idx++) {
            players.add(new Player(names.get(idx), new Position(idx + 1)));
        }
        return players;
    }

    private LadderHeight createLadderHeight(RetryCount retryCount) {
        while (!retryCount.isLimit()) {
            try {
                int height = inputView.readLadderHeight();
                return new LadderHeight(height);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
                retryCount.decrease();

            }
        }
        throw new IllegalStateException(RETRY_COUNT_OVER_EXCEPTION_MESSAGE);
    }

    private LadderPrizes createLadderPrizes(RetryCount retryCount) {
        while (!retryCount.isLimit()) {
            try {
                List<String> rawLadderPrizes = inputView.readLadderPrizes();
                List<LadderPrize> ladderPrizes = new ArrayList<>();
                for (int index = 0; index < rawLadderPrizes.size(); index++) {
                    ladderPrizes.add(new LadderPrize(rawLadderPrizes.get(index), new Position(index + 1)));
                }
                return new LadderPrizes(ladderPrizes);
            } catch (IllegalArgumentException e) {

                outputView.printErrorMessage(e.getMessage());
                retryCount.decrease();
            }
        }
        throw new IllegalStateException(RETRY_COUNT_OVER_EXCEPTION_MESSAGE);
    }

    private void printResult(LadderGame ladderGame) {
        while (true) {
            ResultRequestDto request = inputView.readSpecificResult();

            if (request.isAllResults()) {
                printEveryPlayerResult(ladderGame);
                return;
            }

            if (!ladderGame.containName(request.getMessage())) {
                outputView.printPlayerNotExistMessage(request);
                continue;
            }

            printSinglePlayerResult(ladderGame, request);
        }
    }

    private void printEveryPlayerResult(LadderGame ladderGame) {
        List<GameResultDto> results = ladderGame.findResults();
        outputView.printAllPlayerResult(results);
    }

    private void printSinglePlayerResult(LadderGame ladderGame, ResultRequestDto request) {
        LadderPrize ladderPrize = ladderGame.findResultByName(request.getMessage());
        outputView.printSinglePlayerResult(ladderPrize);
    }
}
