package ladder.controller;

import java.util.List;
import java.util.function.Supplier;
import ladder.domain.Carpenter;
import ladder.domain.Height;
import ladder.domain.Participants;
import ladder.domain.dto.ResultLadderDto;
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

    public void run() {

        Height height = repeatUntilValid(this::getHeight);
        Participants participants = repeatUntilValid(this::getNames);

        int participantsCount = participants.getParticipantsCount();

        Carpenter carpenter = new Carpenter(height, participantsCount, numberGenerator);
        ResultLadderDto resultLadderDto = buildLadder(carpenter, participantsCount);

        outputView.printResult(resultLadderDto, participants.getNames());
    }

    private Participants getNames() {
        List<String> inputNames = inputView.getNames();
        return new Participants(inputNames);
    }

    private Height getHeight() {
        String inputHeight = inputView.getHeight();
        return new Height(inputHeight);
    }

    private ResultLadderDto buildLadder(Carpenter carpenter, int participantsCount) {
        carpenter.buildLadders(participantsCount);
        return carpenter.getResultLadders();
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
