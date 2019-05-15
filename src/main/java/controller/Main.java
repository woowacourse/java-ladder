package controller;

import domain.LadderGame;
import view.InputView;
import view.OutputView;

public class Main {
    public static void main(String[] args) {
        LadderGame ladderGame = createLadderGame();
        OutputView.outputNames(ladderGame.getUsers());
        ladderGame.createLadder();
        OutputView.outputLadder(ladderGame.getLadder());
    }

    private static LadderGame createLadderGame(){
        String names = InputView.inputNames();
        int height = InputView.inputLadderHeight();
        try {
            return new LadderGame(names, height);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return  createLadderGame();
        }
    }
}
