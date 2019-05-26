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

    private static List<String> getNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 (" + ITEM_SPLITTER + ")로 구분하세요)");
        final String names = scanner.nextLine();
        validateNoConsecutiveCommas(names);
        final List<String> splittedNames = Arrays.asList(names.split(ITEM_SPLITTER));
        validateNoDuplication(splittedNames);

        return splittedNames;
    }

    static void validateNoConsecutiveCommas(final String names) {
        if (names.contains(ITEM_SPLITTER + ITEM_SPLITTER)) {
            throw new IllegalArgumentException(ITEM_SPLITTER + "가 두개 이상 연달아 있으면 안 됩니다.");
        }
    }

    static void validateNoDuplication(final List<String> names) {
        final List<String> reducedNames = names.stream().distinct().collect(Collectors.toList());
        if (names.size() != reducedNames.size()) throw new IllegalArgumentException("중복된 이름이 존재하면 안됩니다.");
    }

    public static Rewards createRewards(int playersSize) {
        try {
            List<String> rewardsInput = InputView.getRewards();
            validatePlayerRewardLength(playersSize, rewardsInput.size());
            return new Rewards(rewardsInput);
        } catch (IllegalArgumentException e) {
            OutputView.printRewardErrorMsg(e);
            return createRewards(playersSize);
        }
    }

    private static List<String> getRewards() {
        System.out.println(NEW_LINE + "실행 결과를 입력하세요. (결과는 (" + ITEM_SPLITTER + ")로 구분하세요)");
        final String rewards = scanner.nextLine();
        try {
            validateNoConsecutiveCommas(rewards);
            return Arrays.asList(rewards.split(ITEM_SPLITTER));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getRewards();
        }
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