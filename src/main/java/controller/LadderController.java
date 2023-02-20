package controller;

import java.util.List;

import domain.Ladder;
import domain.Players;
import domain.numbergenerator.NumberGenerator;
import utils.LogType;
import view.InputView;
import view.OutputView;

public class LadderController {

    private final InputView inputView;
    private final NumberGenerator numberGenerator;


    public LadderController(InputView inputView, NumberGenerator numberGenerator) {
        this.inputView = inputView;
        this.numberGenerator = numberGenerator;
    }

    public void run() {
        Players players = generatePlayers();
        Ladder ladder = generateLadder(players.getPlayerSize());
        OutputView.printNames(players);
        OutputView.printLadder(ladder);
    }

    private Players generatePlayers() {
        try {
            List<String> names = inputView.readNames();
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
}
