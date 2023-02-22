package ladder.controller;

import ladder.domain.generator.BooleanGenerator;
import ladder.domain.ladder.Height;
import ladder.domain.ladder.Ladder;
import ladder.domain.player.Player;
import ladder.domain.player.Players;
import ladder.domain.reward.Continue;
import ladder.domain.reward.GameResult;
import ladder.domain.reward.Reward;
import ladder.domain.reward.Rewards;
import ladder.view.Input;
import ladder.view.Result;

import java.util.Map;

public class LadderController {

    private final Input input;
    private final Result result;
    private final BooleanGenerator booleanGenerator;
    private final ExceptionProcess exceptionProcess;

    public LadderController(Input input, Result result, BooleanGenerator booleanGenerator) {
        this.input = input;
        this.result = result;
        this.booleanGenerator = booleanGenerator;
        this.exceptionProcess = new ExceptionProcess(result);
    }

    public void run() {
        Players players = exceptionProcess.repeat(input::inputPlayerNames, Players::create);
        Rewards rewards = exceptionProcess
                .repeat(input::inputRewards, inputRewards -> Rewards.create(inputRewards, players.count()));
        Height heightOfLadder = exceptionProcess.repeat(input::inputHeightOfLadder, Height::new);
        Ladder ladder = Ladder.create(players.count(), heightOfLadder.getHeight(), booleanGenerator);

        result.printLadder(players, ladder, rewards);

        endOfGame(players, ladder, rewards);
    }

    private void endOfGame(Players players, Ladder ladder, Rewards rewards) {
        GameResult gameResult = GameResult.create(players, ladder, rewards);
        Continue resultContinue;
        do {
            Players targetPlayers = exceptionProcess.repeat(input::inputTargetPlayerNames, players::createTargetPlayers);
            Map<Player, Reward> resultByPlayers = gameResult.findResultByPlayers(targetPlayers);

            result.printGameResult(resultByPlayers);

            resultContinue = exceptionProcess.repeat(input::inputContinue, Continue::getContinue);
        } while (resultContinue == Continue.CONTINUE);
    }

}
