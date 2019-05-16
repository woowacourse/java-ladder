package ladder.controller;

import ladder.domain.LadderGame;
import ladder.domain.Result;
import ladder.view.InputCheck;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Main {
    public static void main(String[] args) {
        LadderGame ladderGame = createLadderGame();
        String results;
        Result result;
        do {
            results = InputView.inputResults();
        } while (!InputCheck.checkResultSize(results, ladderGame.getUsers().size()));
        result = new Result(results);
        OutputView.outputNames(ladderGame.getUsers());
        ladderGame.createLadder();
        ladderGame.startLadderGame();
        OutputView.outputLadder(ladderGame.getLadder());
        OutputView.outputResult(result.getResults());
        String name;
        do {
            name = InputView.inputNames1();
            OutputView.output(name, ladderGame.getUsers(), result.getResults());
        } while (!name.equals("all"));
        OutputView.outputAll(ladderGame.getUsers(), result.getResults());
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
