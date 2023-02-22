package controller;

import domain.GameResult;
import domain.Ladder;
import domain.LadderResults;
import domain.Participants;
import util.BooleanGenerator;
import view.InputView;
import view.OutputView;

public class RadderGameController {

    public static final String FINISH = "all";
    private final InputView inputView;
    private final OutputView outputView;

    public RadderGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play(BooleanGenerator booleanGenerator) {
        Participants participants = makeParticipants();
        Ladder ladder = generateLadder(participants, booleanGenerator);
        LadderResults ladderResults = makeLadderResults();
        showGameMap(participants, ladder, ladderResults);
        GameResult gameResult = makeGameResult(ladder, participants, ladderResults);
        showGameResultUntilFinish(gameResult);
        outputView.printAllGameResult(gameResult.getResults());
    }

    private Participants makeParticipants() {
        try {
            String participantsName = inputView.enterParticipantsName();
            return new Participants(participantsName);
        } catch (IllegalArgumentException exception) {
            inputView.printErrorMessage(exception);
            return makeParticipants();
        }
    }

    private LadderResults makeLadderResults() {
        try {
            String participantsName = inputView.enterLadderResult();
            return new LadderResults(participantsName);
        } catch (IllegalArgumentException exception) {
            inputView.printErrorMessage(exception);
            return makeLadderResults();
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

    private void showGameMap(Participants participants, Ladder ladder, LadderResults ladderResults) {
        outputView.printGameMap(participants, ladder, ladderResults);
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

    private GameResult makeGameResult(Ladder ladder, Participants participants, LadderResults ladderResults) {
        return new GameResult(ladder, participants, ladderResults);
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
