package ladder.controller;

import ladder.domain.LadderGame;
import ladder.domain.LadderGameResult;
import ladder.domain.Match;
import ladder.domain.Reward.RewardGroup;
import ladder.domain.participant.ParticipantGroup;
import ladder.view.InputView;
import ladder.view.OutputView;

public class GameApplication {
    public static void main(String[] args) {
        ParticipantGroup participants = createParticipantGroup();
        RewardGroup rewardGroup = createRewards(participants.getSize());

        LadderGame ladderGame = createLadderGame(participants, rewardGroup);
        OutputView.printLadderResult(participants, ladderGame.getLadder(), rewardGroup);

        Match match = ladderGame.matchingPoint();

        LadderGameResult ladderGameResult = match.matchLadder(participants, rewardGroup);
        while (!ladderGameResult.isEnd()) {
            OutputView.printGameResult(ladderGameResult);
        }
    }

    private static ParticipantGroup createParticipantGroup() {
        try {
            return new ParticipantGroup(InputView.inputNames());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + "\n");
            return createParticipantGroup();
        }
    }

    private static RewardGroup createRewards(final int rewardSize) {
        try {
            return new RewardGroup(InputView.inputRewards(), rewardSize);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + "\n");
            return createRewards(rewardSize);
        }
    }

    private static LadderGame createLadderGame(final ParticipantGroup participants, final RewardGroup rewardGroup) {
        try {
            return new LadderGame(participants, InputView.inputLadderHeight());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + "\n");
            return createLadderGame(participants, rewardGroup);
        }
    }
}
