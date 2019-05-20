package ladder.view;

import ladder.domain.LadderGameResult;
import ladder.domain.reward.RewardGroup;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.PointDTO;
import ladder.domain.ladder.Line;
import ladder.domain.participant.ParticipantGroup;

import java.util.List;

public class OutputView {
    private static final String VERTICAL_LINE = "-----";
    private static final String VERTICAL_EMPTY = "     ";
    private static final String HORIZONTAL_LINE = "|";
    private static final int NAME_CONTAINER_WIDTH = 6;

    public static void printLadderResult(ParticipantGroup participantGroup, Ladder ladder, RewardGroup rewards) {
        System.out.println("\n사다리 결과\n");
        drawParticipants(participantGroup);
        drawLadder(ladder);
        drawRewards(rewards);
        System.out.println();
    }

    private static void drawParticipants(ParticipantGroup participants) {
        participants.getParticipantList().stream()
                .forEach(x -> System.out.print(x.toString() + nameBlank(x.toString().length())));
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
        for (PointDTO pointDTO : line.getPointDTO()) {
            System.out.print(HORIZONTAL_LINE);
            lineOrEmpty(pointDTO.getRight());
        }
    }

    private static void lineOrEmpty(boolean haveLine) {
        if (haveLine) {
            System.out.print(VERTICAL_LINE);
            return;
        }
        System.out.print(VERTICAL_EMPTY);
    }

    private static void drawRewards(RewardGroup rewards) {
        rewards.getRewardList().stream()
                .forEach(x -> System.out.print(x.toString() + nameBlank(x.toString().length())));
        System.out.println();
    }

    public static void printGameResult(LadderGameResult ladderGameResult, List<String> names) {
        System.out.println("\n실행 결과");
        try {
            ladderGameResult.getResult(names).entrySet().stream()
                    .forEach(entry -> printResult(entry.getKey(), entry.getValue()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
    }

    private static void printResult(String name, String reward) {
        System.out.println(name + " : " + reward);
    }
}
