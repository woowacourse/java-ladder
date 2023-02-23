package laddergame.controller;

import laddergame.domain.*;
import laddergame.util.TrueOrFalseGenerator;
import laddergame.view.InputView;
import laddergame.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGameController {
    private static final String NAME_INPUT_REQUEST = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String HEIGHT_INPUT_REQUEST = "최대 사다리 높이는 몇 개인가요?";
    private static final String REWARD_INPUT_REQUEST = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String TARGET_INPUT_REQUEST = "결과를 보고 싶은 사람은?";


    private final InputView inputView;
    private final OutputView outputView;
    private final TrueOrFalseGenerator trueOrFalseGenerator;

    public LadderGameController(InputView inputView, OutputView outputView, TrueOrFalseGenerator trueOrFalseGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.trueOrFalseGenerator = trueOrFalseGenerator;
    }

    public void run() {
        Players players = requestUserNames();
        Rewards rewards = requestRewards(players.getPlayersCount());
        Height height = requestLadderHeight();
        Ladder ladder = new Ladder(players, height, trueOrFalseGenerator);
        LadderGame ladderGame = new LadderGame(players, rewards, ladder);
        ladderGame.start();
        List<String> playerNames = players.getPlayers().stream().map(Player::getName).collect(Collectors.toList());
        outputView.printResult(playerNames, ladder.getLines(), players.getMaxPlayerNameLength());
        Target target = requestTarget(playerNames);
        if (target.isAll()){
            outputView.printAllResult(players);
            return ;
        }
        Player targetPlayer = players.getTargetPlayer(target.getName());
        outputView.printPlayerResult(targetPlayer);
    }

    private Players requestUserNames() {
        try {
            outputView.printMessage(NAME_INPUT_REQUEST);
            return inputView.readUserNames();
        } catch (IllegalArgumentException e) {
            outputView.printErrormessage(e.getMessage());
            return requestUserNames();
        }
    }

    private Height requestLadderHeight() {
        try {
            outputView.printMessage(HEIGHT_INPUT_REQUEST);
            return inputView.readHeight();
        } catch (IllegalArgumentException e) {
            outputView.printErrormessage(e.getMessage());
            return requestLadderHeight();
        }
    }

    private Rewards requestRewards(int playerCount) {
        try {
            outputView.printMessage(REWARD_INPUT_REQUEST);
            Rewards rewards = inputView.readRewards();
            rewards.checkRewardsCount(playerCount);
            return rewards;
        } catch (IllegalArgumentException e) {
            outputView.printErrormessage(e.getMessage());
            return requestRewards(playerCount);
        }
    }

    private Target requestTarget(List<String> playerNames) {
        try {
            outputView.printMessage(TARGET_INPUT_REQUEST);
            Target target = inputView.readTarget();
            target.checkNotPlayerNameOrNotAll(playerNames);
            return target;
        } catch (IllegalArgumentException e) {
            outputView.printErrormessage(e.getMessage());
            return requestTarget(playerNames);
        }
    }
}
