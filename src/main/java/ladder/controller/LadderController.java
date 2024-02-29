package ladder.controller;

import java.util.List;
import java.util.function.Supplier;
import ladder.domain.carpenter.Carpenter;
import ladder.domain.carpenter.Energy;
import ladder.domain.dto.MadeLadderDto;
import ladder.domain.ladder.Height;
import ladder.domain.ladderGame.LadderGame;
import ladder.domain.participant.Participants;
import ladder.domain.prize.GamePrizes;
import ladder.domain.randomGenerator.NumberGenerator;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderController {

    private final NumberGenerator numberGenerator;
    private final InputView inputView;
    private final OutputView outputView;

    public LadderController(NumberGenerator numberGenerator, InputView inputView, OutputView outputView) {
        this.numberGenerator = numberGenerator;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public LadderResultController run() {

        Participants participants = repeatUntilValid(this::readyParticipants);
        int participantCount = participants.size();

        Carpenter carpenter = readyCarpenter(participantCount);
        GamePrizes gamePrizes = repeatUntilValid(() -> readyPrizes(participantCount));

        LadderGame ladderGame = new LadderGame(carpenter, participants);
        MadeLadderDto resultLadder = ladderGame.play(participantCount);

        outputView.printMadeLadder(resultLadder, participants.getNames(), gamePrizes.getPrizes());

        return new LadderResultController(inputView, outputView, resultLadder, participants, gamePrizes);
    }

    private Participants readyParticipants() {
        List<String> inputNames = inputView.getNames();
        return new Participants(inputNames);
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

    private <T> T repeatUntilValid(Supplier<T> function) {
        try {
            return function.get();
        } catch (IllegalArgumentException e) {
            outputView.printError(e);
            return repeatUntilValid(function);
        }
    }
}
