package controller;

import domain.Height;
import domain.Lines;
import domain.Names;
import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;
import view.InputView;
import view.OutputView;

public class MainController {

    private final InputView inputView;
    private final OutputView outputView;

    private final Map<ApplicationStatus, Supplier<ApplicationStatus>> gameGuide;
    private Names names;
    private Height height;
    private Lines lines;


    public MainController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.gameGuide = initializeGameGuide();
    }

    public void start() {
        ApplicationStatus applicationStatus = progress(ApplicationStatus.INPUT_NAME);
        while (applicationStatus.playable()) {
            applicationStatus = progress(applicationStatus);
        }
    }

    private ApplicationStatus progress(ApplicationStatus applicationStatus) {
        try {
            return gameGuide.get(applicationStatus).get();
        } catch (NullPointerException exception) {
            return ApplicationStatus.APPLICATION_EXIT;
        }
    }

    private Map<ApplicationStatus, Supplier<ApplicationStatus>> initializeGameGuide() {
        Map<ApplicationStatus, Supplier<ApplicationStatus>> gameGuide = new EnumMap<>(
                ApplicationStatus.class);
        gameGuide.put(ApplicationStatus.INPUT_NAME, this::inputName);
        gameGuide.put(ApplicationStatus.INPUT_HEIGHT, this::inputHeight);
        gameGuide.put(ApplicationStatus.CREATE_LINES, this::createLines);
        gameGuide.put(ApplicationStatus.PRINT_RESULT, this::printResult);
        return gameGuide;
    }

    private ApplicationStatus inputName() {
        try {
            names = inputView.readNames();
            return ApplicationStatus.INPUT_HEIGHT;
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception);
            return ApplicationStatus.INPUT_NAME;
        }
    }

    private ApplicationStatus inputHeight() {
        try {
            height = inputView.readHeight();
            return ApplicationStatus.CREATE_LINES;
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception);
            return ApplicationStatus.INPUT_HEIGHT;
        }
    }

    private ApplicationStatus createLines() {
        int lineNumber = names.getPersonNumber() - 1;
        lines = new Lines(lineNumber, height.getHeight());
        return ApplicationStatus.PRINT_RESULT;
    }


    private ApplicationStatus printResult() {
        outputView.printResult(names, lines);
        return ApplicationStatus.APPLICATION_EXIT;
    }


    private enum ApplicationStatus {
        INPUT_NAME,
        INPUT_HEIGHT,
        CREATE_LINES,
        PRINT_RESULT,
        APPLICATION_EXIT;

        boolean playable() {
            return this != APPLICATION_EXIT;
        }
    }
}
