package controller;

import builder.LadderGameBuilder;
import domain.GameResult;
import domain.LadderGame;
import domain.ladder.Ladder;
import domain.ladder.LadderHeight;
import domain.ladder.LadderResults;
import domain.ladder.LadderSize;
import domain.ladder.LineWeight;
import domain.participants.Participants;
import util.BooleanGenerator;
import util.RandomBooleanGenerator;
import view.InputView;
import view.OutputView;

public class LadderGameController {

    private static final String EXIT = "exit";
    private final InputView inputView;
    private final OutputView outputView;

    public LadderGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        LadderGame ladderGame = generateLadderGame();
        showLadderGameMap(ladderGame);
        GameResult gameResult = GameResult.from(ladderGame);
        showGameResultUntilFinish(gameResult);
    }

    private LadderGame generateLadderGame() {
        Participants participants = getParticipants();
        LadderHeight ladderHeight = getLadderHeight();
        LadderResults ladderResults = getLadderResults(participants.getCount());

        LineWeight lineWeight = new LineWeight(participants.getCount() - 1);
        LadderSize ladderSize = getLadderSize(ladderHeight, lineWeight);

        Ladder ladder = generateLadder(ladderSize, new RandomBooleanGenerator());
        LadderGameBuilder ladderGameBuilder = new LadderGameBuilder();
        return ladderGameBuilder
            .addParticipants(participants)
            .addLadder(ladder)
            .addLadderResults(ladderResults)
            .build();
    }

    private Participants getParticipants() {
        try {
            String participantsName = inputView.enterParticipantsName();
            return new Participants(participantsName);
        } catch (IllegalArgumentException exception) {
            inputView.printErrorMessage(exception);
            return getParticipants();
        }
    }

    private LadderHeight getLadderHeight() {
        try {
            String ladderHeight = inputView.enterHeight();
            return new LadderHeight(ladderHeight);
        } catch (IllegalArgumentException exception) {
            inputView.printErrorMessage(exception);
            return getLadderHeight();
        }
    }

    private LadderResults getLadderResults(int participantsCount) {
        try {
            String ladderResult = inputView.enterLadderResult();
            return new LadderResults(ladderResult, participantsCount);
        } catch (IllegalArgumentException exception) {
            inputView.printErrorMessage(exception);
            return getLadderResults(participantsCount);
        }
    }

    private LadderSize getLadderSize(LadderHeight ladderHeight, LineWeight lineWeight) {
        return new LadderSize(ladderHeight, lineWeight);
    }

    private Ladder generateLadder(LadderSize ladderSize, BooleanGenerator booleanGenerator) {
        try {
            return Ladder.valueOf(ladderSize, booleanGenerator);
        } catch (IllegalArgumentException exception) {
            inputView.printErrorMessage(exception);
            return generateLadder(ladderSize, booleanGenerator);
        }
    }

    private void showLadderGameMap(LadderGame ladderGame) {
        outputView.printGameMap(ladderGame);
    }

    private void showGameResultUntilFinish(GameResult gameResult) {
        String nameForResult = getNameForResult(gameResult);
        while (isNotFinish(nameForResult)) {
            nameForResult = getNameForResult(gameResult);
        }
    }

    private boolean isNotFinish(String nameForResult) {
        return !nameForResult.equals(EXIT);
    }

    private String getNameForResult(GameResult gameResult) {
        try {
            String nameForResult = inputView.enterNameForResult();
            if (nameForResult.equals(EXIT)) {
                return nameForResult;
            }
            outputView.printGameResult(nameForResult, gameResult);
            return nameForResult;
        } catch (IllegalArgumentException exception) {
            inputView.printErrorMessage(exception);
            return getNameForResult(gameResult);
        }
    }
}
