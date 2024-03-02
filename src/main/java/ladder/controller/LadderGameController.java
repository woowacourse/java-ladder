package ladder.controller;

import java.util.List;
import ladder.domain.carpenter.Carpenter;
import ladder.domain.carpenter.Energy;
import ladder.domain.dto.MadeLadderDto;
import ladder.domain.ladder.Height;
import ladder.domain.participant.Participants;
import ladder.domain.prize.GamePrizes;
import ladder.domain.randomGenerator.NumberGenerator;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderGameController extends RepeatableController {

    private final NumberGenerator numberGenerator;
    private final InputView inputView;

    public LadderGameController(NumberGenerator numberGenerator, InputView inputView, OutputView outputView) {
        super(outputView);
        this.numberGenerator = numberGenerator;
        this.inputView = inputView;
    }

    public LadderResultController run() {

        Participants participants = repeatUntilValid(this::readyParticipants);
        int participantCount = participants.size();

        MadeLadderDto madeLadder = buildLadder(participantCount);
        GamePrizes gamePrizes = repeatUntilValid(() -> readyPrizes(participantCount));

        outputView.printMadeLadder(madeLadder, participants.getNames(), gamePrizes.getPrizes());
        return new LadderResultController(inputView, outputView, madeLadder, participants, gamePrizes);
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
        Height height = repeatUntilValid(this::initHeight);
        Energy energy = new Energy(numberGenerator);
        return new Carpenter(height, participantsCount, energy);
    }

    private GamePrizes readyPrizes(int participantCount) {
        List<String> inputPrizes = inputView.getPrizes();
        return new GamePrizes(inputPrizes, participantCount);
    }

    private Height initHeight() {
        String inputHeight = inputView.getHeight();
        return new Height(inputHeight);
    }
}
