package controller;

import java.util.List;

import domain.Ladder;
import domain.Players;
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
        Ladder ladder = generateLadder(players.getPlayerSize());
        outputView.printNames(players);
        outputView.printLadder(ladder);
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

    private Ladder generateLadder(int personCount) {
        try {
            int height = inputView.readHeight();
            return new Ladder(height, personCount, numberGenerator);
        } catch (IllegalArgumentException exception) {
            LogType.ERROR_MESSAGE.log(exception.getMessage());
            return generateLadder(personCount);
        }
    }

    private void validateCommandNames(List<String> names) {
        if (Command.isIn(names)) {
            throw new IllegalArgumentException("사다리 게임 참여자의 이름은 결과 검색 명령어와는 달라야합니다.");
        }
    }
}
