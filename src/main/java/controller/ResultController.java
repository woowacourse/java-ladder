package controller;

import domain.Item;
import domain.Result;
import domain.User;
import view.InputView;
import view.OutputView;

import java.util.Arrays;
import java.util.HashMap;

public class ResultController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Result result;

    public ResultController(InputView inputView, OutputView outputView, Result result) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.result = result;
    }

    public void run() {
        Status status = Status.CONTINUE;
        do {
            try {
                status = process();
            } catch (IllegalArgumentException e) {
                outputView.printExceptionMessage(e.getMessage());
            }
        } while (status.isCONTINUE());
    }

    private Status process() {
        String command = inputView.inputWinner();

        if (Status.from(command).equals(Status.END)) {
            return Status.END;
        }
        outputView.printUserResult(resultCommand(command, result));
        return Status.CONTINUE;

    }

    private HashMap<User, Item> resultCommand(String command, Result result) {
        if (Status.from(command).equals(Status.ALL)) {
            return result.getItemsALL();
        }
        return result.getItem(new User(command));
    }

    private enum Status {
        END("end"),
        CONTINUE("continue"),
        ALL("all");
        private final String command;

        Status(String command) {
            this.command = command;
        }

        public boolean isCONTINUE() {
            return this != END;
        }

        public static Status from(String command) {
            return Arrays.stream(Status.values())
                    .filter(option -> option.command.equals(command))
                    .findAny()
                    .orElse(Status.CONTINUE);
        }
    }
}
