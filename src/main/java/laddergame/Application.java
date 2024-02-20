package laddergame;

import java.io.IOException;
import laddergame.view.InputView;

public class Application {
    public static void main(String[] args) {
        try {
            InputView inputView = new InputView();
            System.out.println(inputView.readPlayersName());
            System.out.println(inputView.readLadderHeight());
        } catch (IOException exception) {

        }

    }
}
