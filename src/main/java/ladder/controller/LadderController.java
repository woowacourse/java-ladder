package ladder.controller;

import ladder.domain.ladder.Height;
import ladder.domain.ladder.Ladder;
import ladder.domain.player.Players;
import ladder.domain.valueGenerator.ValueGenerator;
import ladder.view.Input;
import ladder.view.Result;

public class LadderController {

    private final Input input;
    private final Result result;
    private final ValueGenerator valueGenerator;
    private final ExceptionProcess exceptionProcess;

    public LadderController(Input input, Result result, ValueGenerator valueGenerator) {
        this.input = input;
        this.result = result;
        this.valueGenerator = valueGenerator;
        this.exceptionProcess = new ExceptionProcess(result);
    }

    public void run() {
        Players players = exceptionProcess.repeat(
                input::inputPlayerNames,
                Players::create);
        Height heightOfLadder = exceptionProcess.repeat(
                input::inputHeightOfLadder,
                inputHeight -> Height.create(inputHeight, valueGenerator));
        Ladder ladder = Ladder.create(players.count(), heightOfLadder.getHeight(), valueGenerator);

        result.printLadder(players, ladder);
    }

}
