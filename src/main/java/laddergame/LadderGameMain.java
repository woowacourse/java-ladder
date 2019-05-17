package laddergame;

import laddergame.controller.LadderGameController;

public class LadderGameMain {
    public static void main(String[] args) {
        LadderGameController ladderGameController = new LadderGameController();
        ladderGameController.printLadder();
        ladderGameController.playGame();
    }
}
