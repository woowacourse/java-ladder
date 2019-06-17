package ladder;

import ladder.model.Game;
import ladder.view.Input;
import ladder.view.Output;

import java.util.List;

public class Main {
    private static void printEndResults(Game game) {
        String name = Input.memberResult();
        try {
            Output.endResult(game, name);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            printEndResults(game);
        }
    }

    public static void main(String[] args) {
        List<String> names = Input.names();
        List<String> outcomes = Input.outcomes(names);
        int ladderHeight = Input.ladderHeight();
        Game game = new Game(names, outcomes, ladderHeight);
        Output.GameResult(game);
        printEndResults(game);
    }
}
