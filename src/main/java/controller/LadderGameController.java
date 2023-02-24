package controller;

import domain.Height;
import domain.LadderGame;
import domain.Persons;
import exception.ErrorCode;
import java.util.Arrays;
import java.util.List;
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
        Persons persons = requestPlayerName();
        List<String> prizes = requestLadderPrize(persons.getTotalPersonCount());
        Height height = requestLadderHeight();

        ladderGame = new LadderGame(persons, height);
        ladderGame.run();
        ladderGame.makeGameResult(prizes);

        showLadder(prizes);
        showResult();
    }

    private Persons requestPlayerName() {
        try {
            String inputNames = inputView.requestNames();
            List<String> playerNames = Arrays.stream(inputNames.split(DELIMITER))
                    .collect(Collectors.toList());
            Persons persons = Persons.from(playerNames);
            return persons;
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
            return requestPlayerName();
        }
    }

    private Height requestLadderHeight() {
        try {
            return Height.from(inputView.requestHeight());
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
            return requestLadderHeight();
        }
    }

    private List<String> requestLadderPrize(int personCount) {
        try {
            String inputPrizes = inputView.requestPrize();
            List<String> prizes = Arrays.stream(inputPrizes.split(DELIMITER))
                    .collect(Collectors.toList());
            validatePrizeCount(prizes.size(), personCount);
            return prizes;
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
            return requestLadderPrize(personCount);
        }
    }

    private static void validatePrizeCount(int prizeCount, int personCount) {
        if (prizeCount != personCount) {
            throw new IllegalArgumentException(ErrorCode.COUNT_OR_PRIZE_IS_NOT_MATCH_WITH_PERSON_COUNT.getMessage());
        }
    }

    private void showLadder(List<String> prizes) {
        outputView.printLadderResult(ladderGame.getAllPlayerNames(), ladderGame.getLadderStatus(), prizes);
    }

    private void showResult() {
        String inputName = inputView.requestShowingName();
        if ("all".equals("inputName")) {
            outputView.printAllResult(ladderGame.getAllResult());
            return;
        }
        try {
            outputView.printPersonalResult(ladderGame.getPersonalResult(inputName));
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
        }
        showResult();
    }
}
