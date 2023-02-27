package controller;

import domain.LadderGame;
import domain.ladder.Ladder;
import domain.booleangenerator.BooleanGenerator;
import domain.player.Players;
import domain.prize.Prizes;
import domain.prize.Results;
import utils.Command;
import utils.LogType;
import view.InputView;
import view.OutputView;

import java.util.List;

public class LadderController {

    private static final String INVALID_PRIZE_COUNT_ERROR_MESSAGE = "사다리 게임의 실행 결과는 사람 수와 동일하게 입력해야합니다.";

    private final InputView inputView;
    private final OutputView outputView;
    private final BooleanGenerator booleanGenerator;

    public LadderController(InputView inputView, OutputView outputView, BooleanGenerator booleanGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.booleanGenerator = booleanGenerator;
    }

    public void run() {
        LadderGame ladderGame = init();
        Results results = ladderGame.run();
        print(ladderGame, results);
    }

    private LadderGame init() {
        Players players = generatePlayers();
        int playerCount = players.getPlayerSize();
        Ladder ladder = generateLadder(playerCount);
        Prizes prizes = generatePrize(playerCount);
        return new LadderGame(ladder, players, prizes);
    }

    private void print(LadderGame ladderGame, Results results) {
        outputView.printLadderGame(ladderGame);
        printResults(results);
    }

    private Players generatePlayers() {
        try {
            List<String> names = inputView.readNames();
            validateCommandNames(names);
            return new Players(names);
        } catch (IllegalArgumentException exception) {
            LogType.ERROR_MESSAGE.log(exception.getMessage());
            return generatePlayers();
        }
    }

    private void validateCommandNames(List<String> names) {
        if (Command.isIn(names)) {
            throw new IllegalArgumentException("사다리 게임 참여자의 이름은 결과 검색 명령어와는 달라야합니다.");
        }
    }

    private Ladder generateLadder(int personCount) {
        try {
            int height = inputView.readHeight();
            return Ladder.of(height, personCount, booleanGenerator);
        } catch (IllegalArgumentException exception) {
            LogType.ERROR_MESSAGE.log(exception.getMessage());
            return generateLadder(personCount);
        }
    }

    private Prizes generatePrize(int playerCount) {
        try {
            List<String> prizes = inputView.readPrizes();
            validate(prizes, playerCount);
            return Prizes.of(prizes, playerCount);
        } catch (IllegalArgumentException exception) {
            LogType.ERROR_MESSAGE.log(exception.getMessage());
            return generatePrize(playerCount);
        }
    }

    private void validate(List<String> prizes, int personCount) {
        validatePrizesCount(prizes, personCount);
    }

    private void validatePrizesCount(List<String> prizes, int personCount) {
        if (!isSameCountBetween(prizes, personCount)) {
            throw new IllegalArgumentException(INVALID_PRIZE_COUNT_ERROR_MESSAGE);
        }
    }

    private boolean isSameCountBetween(List<String> objects, int personCount) {
        return objects.size() == personCount;
    }

    private void printResults(Results results) {
        String command = inputView.readResultOfPlayer();
        if (Command.FINISH_GAME_COMMAND.isEqualTo(command)) {
            return;
        }
        if (Command.ALL_PRINT_COMMAND.isEqualTo(command)) {
            printAllResult(results);
            return;
        }
        printOneResult(results, command);
    }

    private void printOneResult(Results results, String command) {
        try {
            outputView.printOnePlayerResult(results, command);
        } catch (IllegalArgumentException exception) {
            LogType.ERROR_MESSAGE.log(exception.getMessage());
        }
        printResults(results);
    }

    private void printAllResult(Results results) {
        outputView.printAllPlayerResult(results);
        printResults(results);
    }
}
