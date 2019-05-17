package ladder.controller;

import ladder.domain.LadderGame;
import ladder.domain.Result;
import ladder.domain.User;
import ladder.view.InputCheck;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        LadderGame ladderGame = new LadderGame(
                InputView.inputNames(), InputView.inputLadderHeight());
        List<User> users = ladderGame.getUsers();
        Result result = new Result(InputView.inputResults(), users.size());
        List<String> results = result.getResults();
        ladderGame.createLadder();
        ladderGame.startLadderGame();

        OutputView.outputNames(users);
        OutputView.outputLadder(ladderGame.getLadder());
        OutputView.outputResult(results);

        String name;
        do {
            name = InputView.inputName();
            OutputView.outputSelectResult(name, users, results);
        } while (!name.equals("all"));
        OutputView.outputAllResult(users, results);
    }
}
