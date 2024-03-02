package ladder.controller;

import static ladder.controller.util.RepeatUtil.repeatUntilValid;

import java.util.List;
import ladder.domain.carpenter.Carpenter;
import ladder.domain.carpenter.Energy;
import ladder.domain.dto.MadeLadderDto;
import ladder.domain.ladder.Height;
import ladder.domain.ladderGame.GameExecutionCommand;
import ladder.domain.ladderGame.LadderMapper;
import ladder.domain.ladderGame.ResultFinder;
import ladder.domain.participant.Name;
import ladder.domain.participant.Participants;
import ladder.domain.prize.GamePrizes;
import ladder.domain.randomGenerator.NumberGenerator;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderGameController {

    private static final String SEE_ALL_PARTICIPANT_COMMEND = "all";

    private final NumberGenerator numberGenerator;
    private final OutputView outputView;
    private final InputView inputView;

    public LadderGameController(NumberGenerator numberGenerator, InputView inputView, OutputView outputView) {
        this.numberGenerator = numberGenerator;
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void run() {

        Participants participants = repeatUntilValid(this::readyParticipants, outputView);
        int participantCount = participants.size();

        MadeLadderDto madeLadder = buildLadder(participantCount);
        GamePrizes gamePrizes = repeatUntilValid(() -> readyPrizes(participantCount), outputView);

        outputView.printMadeLadder(madeLadder, participants.getNames(), gamePrizes.getPrizes());

        showResult(participants, gamePrizes, madeLadder);

    }

    private Participants readyParticipants() {
        List<String> inputNames = inputView.getNames();
        return new Participants(inputNames);
    }

    private MadeLadderDto buildLadder(int participantCount) {
        Carpenter carpenter = readyCarpenter(participantCount);

        carpenter.buildLadders(participantCount);
        return carpenter.getResultLadders();
    }

    private Carpenter readyCarpenter(int participantsCount) {
        Height height = repeatUntilValid(this::initHeight, outputView);
        Energy energy = new Energy(numberGenerator);
        return new Carpenter(height, participantsCount, energy);
    }

    private Height initHeight() {
        String inputHeight = inputView.getHeight();
        return new Height(inputHeight);
    }

    private GamePrizes readyPrizes(int participantCount) {
        List<String> inputPrizes = inputView.getPrizes();
        return new GamePrizes(inputPrizes, participantCount);
    }

    private void showResult(Participants participants, GamePrizes gamePrizes, MadeLadderDto madeLadder) {
        boolean endOrNotChoice = repeatUntilValid(this::isEndOrNot, outputView);

        LadderMapper ladderMapper = new LadderMapper(madeLadder, participants.size());

        if (endOrNotChoice) {
            ResultFinder resultFinder = new ResultFinder(participants, gamePrizes, ladderMapper);

            chooseParticipant(resultFinder);
            showResult(participants, gamePrizes, madeLadder);
        }
    }

    private boolean isEndOrNot() {
        String inputChoice = inputView.getEndOrNotChoice();

        return GameExecutionCommand.isExecuteGameCommand(inputChoice);
    }

    private void chooseParticipant(ResultFinder resultFinder) {
        String participantChoice = inputView.getSeeResultParticipant();

        if (SEE_ALL_PARTICIPANT_COMMEND.equals(participantChoice)) {
            outputView.printAllResult(resultFinder.findAllPrizes());
            return;
        }

        try {
            Name name = new Name(participantChoice);
            outputView.printSingleResult(resultFinder.findPrize(name));
        } catch (IllegalArgumentException e) {
            outputView.printError(e);
        }
    }
}
