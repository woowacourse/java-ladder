package controller;

import domain.Height;
import domain.LadderGame;
import exception.ErrorCode;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import view.InputView;
import view.OutputView;

public class LadderGameController {
    private static final String DELIMITER = ",";
    private final InputView inputView;
    private final OutputView outputView;
    private LadderGame ladderGame;

    public LadderGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void play() {
        List<String> names = requestPlayerName();
        List<String> prizes = requestLadderPrize();
        Height height = requestLadderHeight();

        ladderGame = new LadderGame(names, height, prizes);
        ladderGame.run();
        outputView.printLadderResult(ladderGame.getAllPlayerNames(), ladderGame.getLadderStatus(), prizes);

        Map<String, String> gameResults = ladderGame.getGameResults();
        requestShowingPerson(gameResults);
    }

    private List<String> requestPlayerName() {
        try {
            String inputNames = inputView.requestNames();
            List<String> playerNames = Arrays.stream(inputNames.split(","))
                    .collect(Collectors.toList());
            return playerNames;
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
            return requestPlayerName();
        }
    }

    private Height requestLadderHeight() {
        try {
            return new Height(validateNumber(inputView.requestHeight()));
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
            return requestLadderHeight();
        }
    }

    private int validateNumber(String height) {
        try {
            return Integer.parseInt(height);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorCode.NUMBER_NOT_INTEGER.getMessage());
        }
    }

    private List<String> requestLadderPrize() {
        try {
            String inputprizes = inputView.requestPrize();
            List<String> prizes = Arrays.stream(inputprizes.split(DELIMITER))
                    .collect(Collectors.toList());
            return prizes;
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
            return requestLadderPrize();
        }
    }

    private void requestShowingPerson(Map<String, String> gameResults) {
        String inputName = inputView.requestShowingName();
        do {
            outputView.printPersonalResult(gameResults.get(inputName));
            inputName = inputView.requestShowingName();
        } while (!inputName.equals("all"));
        outputView.printAllResult(gameResults);
    }
}
