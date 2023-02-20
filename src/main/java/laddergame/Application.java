package laddergame;

import laddergame.controller.GameController;
import laddergame.domain.RandomBooleanPicker;

public class Application {

    public static void main(String[] args) {
        final GameController gameController = new GameController(new RandomBooleanPicker());
        gameController.process();
    }
}
