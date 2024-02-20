package laddergame;

import java.io.IOException;
import laddergame.view.InputView;

public class Application {
    public static void main(String[] args) {
        try {
            InputView inputView = new InputView();
            inputView.readPlayersName();
        } catch (IOException exception) {

        }

    }
}
