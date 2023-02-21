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
        Users users = retryOnError(() -> Users.from(inputView.inputUserName()));
        Items items = retryOnError(() -> Items.of(inputView.inputItem(), users));
        Height height = retryOnError(() -> Height.from(inputView.inputLadderHeight()));
        Ladders ladders = Ladders.of(users.getCount(), height, new RandomBooleanGenerator());

        outputView.printLadderResultBoard(users, items, ladders);
        Result result = new Result(users, items, ladders);
        ResultController.of(inputView, outputView, result).run();
    }

    private <T> T retryOnError(Supplier<T> repeat) {
        try {
            return repeat.get();
        } catch (Exception e) {
            outputView.printExceptionMessage(e.getMessage());
            return retryOnError(repeat);
        }
    }
}
