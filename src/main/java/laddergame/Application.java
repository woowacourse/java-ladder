package laddergame;

import laddergame.controller.GameController;

public class Application {

    public static void main(String[] args) {
        final GameController gameController = new GameController();
        gameController.process();
    }
}
