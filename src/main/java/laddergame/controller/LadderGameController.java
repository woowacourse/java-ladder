package laddergame.controller;

import java.util.List;
import laddergame.view.InputView;

public class LadderGameController {
    InputView inputView = new InputView();

    public void run() {
        List<String> names = inputView.readPersonNames();
    }
}
