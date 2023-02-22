package controller;

import builder.LadderGameBuilder;
import domain.GameResult;
import domain.Ladder;
import domain.LadderGame;
import domain.LadderResults;
import domain.Participants;
import util.BooleanGenerator;
import util.RandomBooleanGenerator;
import view.InputView;
import view.OutputView;

public class LadderGameController {

    private static final String FINISH = "all";
    private final InputView inputView;
    private final OutputView outputView;
    private final LadderGame ladderGame;

    public LadderGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.ladderGame = generateLadderGame();
    }

    private LadderGame generateLadderGame() {
        Participants participants = getParticipantNames();
        Ladder ladder = generateLadder(participants, new RandomBooleanGenerator());
        LadderResults ladderResults = getLadderResults(participants.getCount());
        LadderGameBuilder ladderGameBuilder = new LadderGameBuilder();
        return ladderGameBuilder
            .addParticipants(participants)
            .addLadder(ladder)
            .addLadderResults(ladderResults)
            .build();
    }

    private Participants getParticipantNames() {
        try {
            String participantsName = inputView.enterParticipantsName();
            return new Participants(participantsName);
        } catch (IllegalArgumentException exception) {
            inputView.printErrorMessage(exception);
            return getParticipantNames();
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

    private Ladder generateLadder(Participants participants, BooleanGenerator booleanGenerator) {
        try {
            final String height = inputView.enterHeight();
            final int lineWeight = participants.getCount() - 1;
            return new Ladder(height, lineWeight, booleanGenerator);
        } catch (IllegalArgumentException exception) {
            inputView.printErrorMessage(exception);
            return generateLadder(participants, booleanGenerator);
        }
    }

    public void play() {
        GameResult gameResult = new GameResult(ladderGame);
        showLadderGameMap();
        showGameResultUntilFinish(gameResult);
        outputView.printAllGameResult(gameResult);
    }

    private void showLadderGameMap() {
        outputView.printGameMap(ladderGame);
    }

    private void showGameResultUntilFinish(GameResult gameResult) {
        String nameForResult = getNameForResult(gameResult);
        while (isNotFinish(nameForResult)) {
            outputView.printGameResult(nameForResult);
            nameForResult = getNameForResult(gameResult);
        }
    }

    private boolean isNotFinish(String nameForResult) {
        return !nameForResult.equals(FINISH);
    }

    private String getNameForResult(GameResult gameResult) {
        try {
            String nameForResult = inputView.enterNameForResult();
            return gameResult.getResultByName(nameForResult);
        } catch (IllegalArgumentException exception) {
            inputView.printErrorMessage(exception);
            return getNameForResult(gameResult);
        }
    }
}
