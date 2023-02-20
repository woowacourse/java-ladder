package utils;

import controller.LadderController;
import java.lang.reflect.Proxy;
import java.util.Scanner;
import model.LadderMaker;
import strategy.RandomPassGenerator;
import view.InputView;
import view.OutputView;

public class LadderApplicationConfig {

    public LadderController ladderController() {
        InputView inputView = new InputView(new Scanner(System.in));
        OutputView outputView = new OutputView();
        LadderMaker ladderMaker = new LadderMaker(new RandomPassGenerator());

        return new LadderController(inputView, outputView, ladderMaker);
    }
}
