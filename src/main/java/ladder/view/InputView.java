package ladder.view;

import ladder.domain.Players;
import ladder.domain.Rewards;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final int MIN_HEIGHT = 1;
    private static final String ITEM_SPLITTER = ",";
    private static final String NEW_LINE = System.getProperty("line.separator");
    private static final Scanner scanner = new Scanner(System.in);

    public static Players createPlayers() {
        try {
            return new Players(getNames());
        } catch (Exception e) {
            OutputView.printPlayerErrorMsg(e);
            return createPlayers();
        }
    }

    private static String getNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 (" + ITEM_SPLITTER + ")로 구분하세요)");
        return scanner.nextLine();
    }

    public static Rewards createRewards(int playersSize) {
        try {
            Rewards rewards = new Rewards(getRewards());
            validatePlayerRewardLength(playersSize, rewards.getRewardSize());
            return rewards;
        } catch (IllegalArgumentException e) {
            OutputView.printRewardErrorMsg(e);
            return createRewards(playersSize);
        }
    }

    private static String getRewards() {
        System.out.println(NEW_LINE + "실행 결과를 입력하세요. (결과는 (" + ITEM_SPLITTER + ")로 구분하세요)");
        return scanner.nextLine();
    }

    private static void validatePlayerRewardLength(int playersSize, int rewardsSize) {
        if (playersSize != rewardsSize)
            throw new IllegalArgumentException("플레이어의 이름과 같은 갯수의 보상을 입력해주세요.");
    }

    public static int getHeight() {
        try {
            System.out.println(NEW_LINE + "최대 사다리 높이는 몇 개인가요?");
            final int height = Integer.parseInt(scanner.nextLine());
            validateNaturalNumber(height);
            return height;
        } catch (NumberFormatException e) {
            OutputView.printHeightFormatErrorMsg();
        } catch (Exception e) {
            OutputView.printHeightRangeErrorMsg(e);
        }
        return getHeight();
    }

    static void validateNaturalNumber(final int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException("사다리 높이는 최소 1 이어야 합니다.");
        }
    }

    static String getName() {
        System.out.println("결과를 보고 싶은 사람은?");
        return scanner.nextLine();
    }
}