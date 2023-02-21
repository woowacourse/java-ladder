package ladder.controller;

import ladder.domain.ladder.Height;
import ladder.domain.ladder.Ladder;
import ladder.domain.player.Player;
import ladder.domain.player.Players;
import ladder.domain.reward.GameResult;
import ladder.domain.reward.Reward;
import ladder.domain.reward.Rewards;
import ladder.domain.valueGenerator.BooleanGenerator;
import ladder.domain.valueGenerator.IntegerGenerator;
import ladder.view.Input;
import ladder.view.Result;

import java.util.Map;

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
        Players players = exceptionProcess
                .repeat(input::inputPlayerNames, Players::create);
        Rewards rewards = exceptionProcess
                .repeat(input::inputRewards, inputRewards -> Rewards.create(inputRewards, players.count()));
        Height heightOfLadder = exceptionProcess
                .repeat(input::inputHeightOfLadder, inputHeight -> Height.create(inputHeight, integerGenerator));
        Ladder ladder = Ladder.create(players.count(), heightOfLadder.getHeight(), booleanGenerator);

        result.printLadder(players, ladder, rewards);

        pop(players, ladder, rewards);
    }

    private void pop(Players players, Ladder ladder, Rewards rewards) {
        GameResult gameResult = GameResult.create(players, ladder, rewards);

        Players targetPlayers = exceptionProcess
                .repeat(input::inputTargetPlayerNames, players::createTargetPlayers);

        Map<Player, Reward> resultByPlayers = gameResult.findResultByPlayers(targetPlayers);

        result.printGameResult(resultByPlayers);
    }

}
