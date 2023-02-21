package controller;

import domain.Item;
import domain.Result;
import domain.User;
import view.InputView;
import view.OutputView;

import java.util.HashMap;
import java.util.concurrent.Callable;

public class ResultController {
    public static String END_COMMAND = "all";
    private final InputView inputView;
    private final OutputView outputView;
    private final Result result;

    private ResultController(InputView inputView, OutputView outputView, Result result) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.result = result;
    }

    public static ResultController of(InputView inputView, OutputView outputView, Result result) {
        return new ResultController(inputView, outputView, result);
    }

    public void run() {
        Status status;
        do {
            status = retryOnError(this::process);
        } while (status.isCONTINUE());
    }

    private Status process() {
        String command = inputView.inputWinner();
        outputView.printUserResult(resultCommand(command, result));
        return Status.valueOfStatus(command);
    }

    private HashMap<User, Item> resultCommand(String command, Result result) {
        if (Status.valueOfStatus(command).equals(Status.ALL)) {
            return result.getItemsALL();
        }
        return result.getItem(new User(command));
    }

    private <T> T retryOnError(Callable<T> runnable) {
        try {
            return runnable.call();
        } catch (Exception e) {
            outputView.printExceptionMessage(e.getMessage());
            return retryOnError(runnable);
        }
    }

    private enum Status {
        CONTINUE, ALL;

        public boolean isCONTINUE() {
            return this != ALL;
        }

        public static Status valueOfStatus(String command) {
            if (command.equals(END_COMMAND)) {
                return ALL;
            }
            return CONTINUE;
        }
    }
}
