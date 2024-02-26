package ladder.controller;

import java.util.List;
import java.util.function.Supplier;
import ladder.domain.dto.LadderResponseDto;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.RungGenerator;
import ladder.domain.participant.Participants;
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
        Participants participants = repeatUntilValid(this::getParticipants);
        int participantsCount = participants.getCount();

        Ladder ladder = repeatUntilValid(() -> getLadder(participantsCount));
        LadderResponseDto ladderResponseDto = ladder.getResultLadders();

        outputView.printResult(ladderResponseDto, participants.getNames());
    }

    private Participants getParticipants() {
        List<String> inputNames = inputView.getNames();
        return new Participants(inputNames);
    }

    private Ladder getLadder(int participantsCount) {
        int height = inputView.getHeight();
        return new Ladder(height, participantsCount, rungGenerator);
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
