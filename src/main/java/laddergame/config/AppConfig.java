package laddergame.config;

import laddergame.controller.LadderController;
import laddergame.domain.generator.RandomLadderGenerator;
import laddergame.service.LadderGame;
import laddergame.view.InputView;
import laddergame.view.OutputView;

public class AppConfig {

    private static final LadderController INSTANCE = getInstance();

    private AppConfig() {
    }

    public static LadderController ladderController() {
        return INSTANCE;
    }

    private static LadderController getInstance() {
        return new LadderController(new InputView(), new OutputView(), ladderGame());
    }

    private static LadderGame ladderGame() {
        return new LadderGame(new RandomLadderGenerator());
    }
}
