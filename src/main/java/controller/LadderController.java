package controller;

import java.util.List;
import java.util.Map;

import domain.Ladder;
import domain.LadderGame;
import domain.Players;
import domain.Prize;
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
        Players players = generatePlayers();
        int playerCount = players.getPlayerSize();
        Ladder ladder = generateLadder(playerCount);
        Prize prize = generatePrize(playerCount);
        LadderGame ladderGame = new LadderGame(ladder, players, prize);
        Map<String, String> result = ladderGame.run();
        print(players, ladder, prize, result);
    }

    private void print(Players players, Ladder ladder, Prize prize, Map<String, String> result) {
        outputView.printNames(players);
        outputView.printLadder(ladder);
        outputView.printPrizes(prize);
        printResult(result);
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

    private Prize generatePrize(int playerCount) {
        try {
            List<String> prizes = inputView.readPrizes();
            return new Prize(prizes, playerCount);
        } catch (IllegalArgumentException exception) {
            LogType.ERROR_MESSAGE.log(exception.getMessage());
            return generatePrize(playerCount);
        }
    }

    private void printResult(Map<String, String> result) {
        String command = inputView.readResultOfPlayer();
        if (command.equals(Command.FINISH_GAME_COMMAND.getCommand())) {
            return;
        }
        if (command.equals(Command.ALL_PRINT_COMMAND.getCommand())) {
            outputView.printAllPlayerResult(result);
            printResult(result);
            return;
        }
        outputView.printOnePlayerResult(result, command);
        printResult(result);
    }
}
