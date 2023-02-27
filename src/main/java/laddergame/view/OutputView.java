package laddergame.view;

import laddergame.domain.LadderGame;
import laddergame.domain.Line;
import laddergame.domain.Reward;

import java.util.List;

public class OutputView {
    private static final String BLANK = " ";
    private static final String BAR = "|";
    private static final String ERROR_PREFIX = "[ERROR] ";

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printResult(List<String> playersName, List<Line> lines, int maxPlayerNameLength, List<Reward> rewards) {
        playersName.forEach(name -> System.out.printf("%" + maxPlayerNameLength + "s ", name));
        System.out.println();
        lines.forEach(line -> System.out.println(changeFormat(line, maxPlayerNameLength)));
        rewards.forEach(reward -> System.out.printf("%" + maxPlayerNameLength + "s ", reward.getRewardName()));
        System.out.println();
    }

    public void printErrormessage(String errorMessage) {
        System.out.println(ERROR_PREFIX + errorMessage);
    }

    public void printPlayerResult(String rewardName) {
        System.out.println("실행 결과");
        System.out.println(rewardName);
    }

    public void printAllResult(List<String> playerNames, LadderGame ladderGame) {
        System.out.println("실행 결과");
        playerNames.forEach(playerName ->
        {
            System.out.printf("%s : %s", playerName, ladderGame.getReward(playerName).getRewardName());
            System.out.print(System.lineSeparator());
        });
    }

    private String changeFormat(Line line, int maxPlayerNameLength) {
        int preBlankLength = maxPlayerNameLength - 1;
        List<Boolean> points = line.getPoints();
        StringBuilder ladderLine = new StringBuilder(BLANK.repeat(preBlankLength) + BAR);
        for (Boolean point : points) {
            ladderLine.append(printLine(point, maxPlayerNameLength));
        }
        return ladderLine.toString();
    }

    private String printLine(Boolean point, int maxPlayerNameLength) {
        return LadderStep.valueOf(point).getStep().repeat(maxPlayerNameLength) + BAR;
    }
}
