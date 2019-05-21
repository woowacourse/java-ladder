package ladder.view;

import ladder.domain.LadderGameResult;
import ladder.domain.Reward.RewardGroup;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.Line;
import ladder.domain.ladder.Point;
import ladder.domain.participant.ParticipantGroup;

import java.util.List;

public class OutputView {
    private static final int NAME_CONTAINER_WIDTH = 6;

    public static void printLadderResult(ParticipantGroup participantGroup, Ladder ladder, RewardGroup rewardGroup) {
        System.out.println("\n사다리 결과\n");
        drawName(participantGroup);
        drawLadder(ladder);
        drawRewards(rewardGroup);
        System.out.println();
    }

    private static void drawName(ParticipantGroup participantGroup) {
        participantGroup.getParticipantList().stream().forEach(x -> System.out.print(x.toString() + nameBlank(x.toString().length())));
        System.out.println();
    }

    private static String nameBlank(int nameLength) {
        StringBuilder blank = new StringBuilder();
        for (int i = 0; i < NAME_CONTAINER_WIDTH - nameLength; i++) {
            blank.append(" ");
        }
        return blank.toString();
    }

    public static void drawLadder(Ladder ladder) {
        for (Line line : ladder.getLines()) {
            drawLine(line);
            System.out.println();
        }
    }

    private static void drawLine(Line line) {
        for (Point p : line.getPoints()) {
            System.out.print(line.toString() + p.toString());
        }
    }

    private static void drawRewards(RewardGroup rewardGroup) {
        rewardGroup.getRewardList().stream().forEach(reward -> System.out.print(reward.toString() + nameBlank(reward.toString().length())));
        System.out.println();
    }

    public static void printGameResult(LadderGameResult ladderGameResult) {
        List<String> names = InputView.inputResultNames();
        System.out.println("\n실행 결과");
        try {
            ladderGameResult.getResult(names).entrySet().stream()
                    .forEach(entry -> printResult(entry.getKey(), entry.getValue()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        ;
        System.out.println();
    }

    private static void printResult(String name, String reward) {
        System.out.println(name + " : " + reward);
    }
}
