package utils;

import controller.Controller;
import controller.LadderController;
import controller.LadderControllerInvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Scanner;
import model.LadderMaker;
import strategy.RandomPassGenerator;
import view.InputView;
import view.OutputView;

public class LadderApplicationConfig {

    public Controller ladderController() {
        InputView inputView = new InputView(new Scanner(System.in));
        OutputView outputView = new OutputView();
        LadderMaker ladderMaker = new LadderMaker(new RandomPassGenerator());
        LadderController ladderController = new LadderController(inputView, outputView, ladderMaker);

        return (Controller) Proxy.newProxyInstance(Controller.class.getClassLoader(),
                new Class[]{Controller.class},
                new LadderControllerInvocationHandler(ladderController, outputView));
    }
}
