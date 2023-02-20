package ladder.controller;

import ladder.domain.ladder.Height;
import ladder.domain.ladder.Ladder;
import ladder.domain.player.Players;
import ladder.domain.valueGenerator.BooleanGenerator;
import ladder.domain.valueGenerator.IntegerGenerator;
import ladder.view.Input;
import ladder.view.Result;

public class LadderController {

    private final Input input;
    private final Result result;
    private final BooleanGenerator booleanGenerator;
    private final IntegerGenerator integerGenerator;
    private final ExceptionProcess exceptionProcess;

    public LadderController(Input input, Result result, BooleanGenerator booleanGenerator, IntegerGenerator integerGenerator) {
        this.input = input;
        this.result = result;
        this.booleanGenerator = booleanGenerator;
        this.integerGenerator = integerGenerator;
        this.exceptionProcess = new ExceptionProcess(result);
    }

    public void run() {
        Players players = exceptionProcess.repeat(
                input::inputPlayerNames,
                Players::create);
        Height heightOfLadder = exceptionProcess.repeat(
                input::inputHeightOfLadder,
                inputHeight -> Height.create(inputHeight, integerGenerator));
        Ladder ladder = Ladder.create(players.count(), heightOfLadder.getHeight(), booleanGenerator);

        result.printLadder(players, ladder);
    }

}
