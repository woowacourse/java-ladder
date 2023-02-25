package controller;

import java.util.List;
import java.util.Map;

import domain.*;
import domain.numbergenerator.NumberGenerator;
import utils.Command;
import utils.LogType;
import view.InputView;
import view.OutputView;

public class LadderController {

    private final InputView inputView;
    private final OutputView outputView;
    private final NumberGenerator numberGenerator;

    public LadderController(InputView inputView, OutputView outputView, NumberGenerator numberGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.numberGenerator = numberGenerator;
    }

    public void run() {
        LadderGame ladderGame = init();
        Map<Player, Prize> results = ladderGame.run();
        print(ladderGame, results);
    }

    private LadderGame init() {
        Players players = generatePlayers();
        int playerCount = players.getPlayerSize();
        Ladder ladder = generateLadder(playerCount);
        Prizes prizes = generatePrize(playerCount);
        LadderGame ladderGame = new LadderGame(ladder, players, prizes);
        return ladderGame;
    }

    private void print(LadderGame ladderGame, Map<Player, Prize> results) {
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
            return new Ladder(height, personCount, numberGenerator);
        } catch (IllegalArgumentException exception) {
            LogType.ERROR_MESSAGE.log(exception.getMessage());
            return generateLadder(personCount);
        }
    }

    private Prizes generatePrize(int playerCount) {
        try {
            List<String> prizes = inputView.readPrizes();
            return new Prizes(prizes, playerCount);
        } catch (IllegalArgumentException exception) {
            LogType.ERROR_MESSAGE.log(exception.getMessage());
            return generatePrize(playerCount);
        }
    }

    private void printResults(Map<Player, Prize> results) {
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

    private void printOneResult(Map<Player, Prize> results, String command) {
        try {
            outputView.printOnePlayerResult(results, command);
        } catch (IllegalArgumentException exception) {
            LogType.ERROR_MESSAGE.log(exception.getMessage());
        }
        printResults(results);
    }

    private void printAllResult(Map<Player, Prize> results) {
        outputView.printAllPlayerResult(results);
        printResults(results);
    }
}
