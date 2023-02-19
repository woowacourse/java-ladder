package controller;

import domain.*;
import view.InputView;
import view.OutputView;

import java.util.function.Supplier;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Users users = repeatUntil(() -> new Users(inputView.inputUserName()));
        Items items = repeatUntil(()->new Items(inputView.inputItem(), users));
        Ladders ladders = new Ladders(users.getCount()
                , repeatUntil(() -> new Height(inputView.inputLadderHeight()))
                , new RandomGenerator());

        outputView.printLadderResultBoard(users, items, ladders);
        Result result = new Result(users, items, ladders);
        new ResultController(inputView, outputView, result).run();
    }

    private <T> T repeatUntil(Supplier<T> runnable) {
        try {
            return runnable.get();
        } catch (Exception e) {
            outputView.printExceptionMessage(e.getMessage());
            return repeatUntil(runnable);
        }
    }
}
