package ladder.controller;

import java.util.List;
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
        List<String> inputNames = inputView.getNames();
        String inputHeight = inputView.getHeight();

        Height height = new Height(inputHeight);
        Carpenter carpenter = new Carpenter(height, inputNames.size(), numberGenerator);
        Participants participants = new Participants(inputNames);

        carpenter.buildLadders(inputNames.size());
        ResultLadderDto resultLadderDto = carpenter.getResultLadders();

        outputView.printResult(resultLadderDto, participants.getNames());
    }

}
