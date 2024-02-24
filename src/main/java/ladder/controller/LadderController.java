package ladder.controller;

import java.util.List;
import java.util.function.Supplier;
import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.dto.LadderResponseDto;
import ladder.domain.participant.Participants;
import ladder.domain.randomGenerator.RungGenerator;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RungGenerator rungGenerator;

    public LadderController(InputView inputView, OutputView outputView, RungGenerator rungGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.rungGenerator = rungGenerator;
    }

    public void run() {
        Height height = repeatUntilValid(this::getHeight);
        Participants participants = repeatUntilValid(this::getParticipants);

        int participantsCount = participants.getParticipantsCount();

        Ladder ladder = new Ladder(height, participantsCount, rungGenerator);
        LadderResponseDto ladderResponseDto = ladder.getResultLadders();

        outputView.printResult(ladderResponseDto, participants.getNames());
    }

    private Participants getParticipants() {
        List<String> inputNames = inputView.getNames();
        return new Participants(inputNames);
    }

    private Height getHeight() {
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
