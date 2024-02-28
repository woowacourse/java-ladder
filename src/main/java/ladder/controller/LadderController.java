package ladder.controller;

import java.util.List;
import java.util.function.Supplier;
import ladder.domain.Carpenter;
import ladder.domain.Energy;
import ladder.domain.GamePrizes;
import ladder.domain.Height;
import ladder.domain.LadderGame;
import ladder.domain.LadderResult;
import ladder.domain.Participants;
import ladder.domain.dto.ResultLadderDto;
import ladder.domain.dto.ResultStepLadderDto;
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

        Height height = repeatUntilValid(this::getHeight);
        Participants participants = repeatUntilValid(this::getNames);
        GamePrizes gamePrizes = repeatUntilValid(this::getPrizes);

        int participantsCount = participants.getParticipantsCount();

        Energy energy = new Energy(numberGenerator);
        Carpenter carpenter = new Carpenter(height, participantsCount, energy);

        LadderGame ladderGame = new LadderGame(carpenter, participants);

        ResultLadderDto resultLadderDto = ladderGame.play(participantsCount);

        outputView.printResult(resultLadderDto, participants.getNames(), gamePrizes.getPrizes());

        ResultStepLadderDto resultStepLadderDto = carpenter.getResultLadders2();
        LadderResult ladderResult = ladderGame.mapLadderGame(resultStepLadderDto);

        return new LadderResultController(inputView, outputView, ladderResult, participants, gamePrizes);
    }

    private Participants getNames() {
        List<String> inputNames = inputView.getNames();
        return new Participants(inputNames);
    }

    private Height getHeight() {
        String inputHeight = inputView.getHeight();
        return new Height(inputHeight);
    }

    private GamePrizes getPrizes() {
        List<String> inputPrizes = inputView.getPrizes();
        return new GamePrizes(inputPrizes);
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
