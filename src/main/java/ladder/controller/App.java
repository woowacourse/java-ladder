package ladder.controller;

import ladder.model.EndResult;
import ladder.model.LadderGame;
import ladder.model.Members;
import ladder.view.Input;
import ladder.view.Output;

import java.util.List;

public class App {
    private static final String EXCEPTION_WRONG_INPUT = "잘못 입력하셨습니다.";
    private static final String ALL = "ALL";

    public void play() {
        LadderGame game = initGame();
        EndResult results = playGame(game);
        endGame(results);
    }

    private LadderGame initGame() {
        List<String> names = Input.names();
        Members members = new Members(names);
        List<String> results = Input.results(members.size());
        int ladderHeight = Input.ladderHeight();
        return new LadderGame(members, ladderHeight, results);
    }

    private EndResult playGame(LadderGame game) {
        Output.printLadder(game);
        return game.execute();
    }

    private void endGame(EndResult results) {
        String name = Input.memberResult();
        if (name.toUpperCase().equals(ALL)) {
            Output.allResult(results.getAllResult());
            return;
        }
        try {
            Output.memberResult(results.getMemberResult(name));
        } catch (IllegalArgumentException e) {
            System.err.println(EXCEPTION_WRONG_INPUT);
            endGame(results);
        }
    }
}
