package ladder.controller;

import ladder.model.Game;
import ladder.view.Input;
import ladder.view.Output;

public class App {
    public static void main(String[] argc) {
        Game game = new Game(Input.names(), Input.rewards(), Input.height());
        Output.game(game);
        while(Output.result(game.getResultOf(Input.candidates())));
    }
}