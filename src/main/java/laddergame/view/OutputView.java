package laddergame.view;

import java.util.List;

import laddergame.model.Ladder.Ladder;
import laddergame.model.LadderGame;
import laddergame.model.Participants;
import laddergame.model.Rewards;

public class OutputView {
    private static final String LADDER_RESULT_MSG = System.lineSeparator() + "사다리 결과";
    private static final String RESULT_MSG = System.lineSeparator() + "실행결과";
    private static final String VERTICAL_LINE = "|";
    private static final String REWARDS_DELIMITER = " : ";

    public void printResult(Ladder ladder, Participants participants, Rewards rewards) {
        System.out.println(LADDER_RESULT_MSG);
        printPersons(participants);
        printLadder(ladder);
        printExecutionResults(rewards);
    }

    private void printPersons(Participants participants) {
        participants.getParticipants()
            .forEach(participant -> System.out.printf("%6s", participant.getName()));
        System.out.println();
    }

    public void printLadder(Ladder ladder) {
        for (int i = 0; i < ladder.getHeight(); i++) {
            List<Boolean> lines = ladder.get(i).getLine();
            System.out.printf("%6s", VERTICAL_LINE);
            printSymbol(lines);
            System.out.println();
        }
    }

    private void printExecutionResults(Rewards rewards) {
        rewards.getRewardNames()
            .forEach(resultName -> System.out.printf("%6s", resultName.getName()));
        System.out.println();
    }

    private void printSymbol(List<Boolean> lines) {
        for (boolean bool : lines) {
            System.out.print(LineSymbol.findByBool(bool).getSymbol());
            System.out.print(VERTICAL_LINE);
        }
    }

    public void printReward(LadderGame ladderGame, String name) {
        System.out.println(RESULT_MSG);
        if (LadderGame.ALL_MATCHING_KEY.equals(name)) {
            printAllRewards(ladderGame);
            return;
        }
        System.out.println(ladderGame.getReward(name));
    }

    private void printAllRewards(LadderGame ladderGame) {
        ladderGame.getMatching().forEach((key, value) ->
            System.out.println(key.getName() + REWARDS_DELIMITER + value.getName()));
    }
}
