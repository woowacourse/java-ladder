package laddergame;

import laddergame.config.AppConfig;
import laddergame.controller.LadderController;

public class Application {

    public static void main(final String[] args) {
        final LadderController ladderController = AppConfig.ladderController();
        ladderController.run();
    }
}
