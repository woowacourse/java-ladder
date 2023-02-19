package controller;

import domain.Item;
import domain.Result;
import domain.User;
import view.InputView;
import view.OutputView;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ResultController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Map<Status, Supplier<Status>> controllerGuide;
    private final Result result;

    public ResultController(InputView inputView, OutputView outputView, Result result) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.controllerGuide = new EnumMap<>(Status.class);
        this.result = result;
        initializeControllerGuide();
    }

    public void process() {
        Status status = Status.CONTINUE;
        do {
            try {
                status = controllerGuide.get(status).get();
            } catch (IllegalArgumentException e) {
                outputView.printExceptionMessage(e.getMessage());
                status = Status.CONTINUE;
            }
        } while (status.isEnd());
    }

    private void initializeControllerGuide() {
        controllerGuide.put(Status.CONTINUE, this::resultRepeat);
    }

    private Status resultRepeat() {
        String command = inputView.inputWinner();

        if (command.equals("end")) {
            return Status.END;
        }
        outputView.printUserResult(resultCommand(command, result));
        return Status.CONTINUE;

    }

    private HashMap<User, Item> resultCommand(String command, Result result) {
        if (command.equals("all")) {
            return result.getItemsALL();
        }
        return result.getItem(new User(command));
    }

    private enum Status {
        END,
        CONTINUE;

        public boolean isEnd() {
            return this == CONTINUE;
        }
    }
}
