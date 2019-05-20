package ladder.controller;

import ladder.model.Game;
import ladder.view.Input;
import ladder.view.OutputView;

// TODO: readme.md 기능목록 작성

public class App {
    public static void main(String[] argc) {
        Game game = new Game(Input.names(), Input.rewards(), Input.height());
        OutputView.printGame(game);
        while(OutputView.printResult(game.getResultOf(Input.candidates())));
    }
}