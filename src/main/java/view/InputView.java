package view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import model.gameresult.GameResult;
import model.ladder.LadderHeight;
import model.player.Players;
import model.prize.Prizes;

public class InputView {

    private static final String SPLIT_DELIMITER = ",";
    private static final String ASK_PLAYER_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String ASK_PRIZE_NAMES = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String ASK_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    private static final String ASK_PLAYER_NAME = "결과를 보고 싶은 사람은?";
    private static final String LADDER_HEIGHT_NOT_INTEGER = "최대 사다리 높이는 숫자로 입력 해야 합니다";
    private static final String SEARCHING_END_CONDITION = "all";
    private static final String NEWLINE = System.lineSeparator();

    private InputView() {
    }

    public static Players preparePlayers() {
        return retryOnException(() -> {
            List<String> playerNames = askPlayerNames();
            return Players.of(playerNames);
        });
    }

    private static List<String> askPlayerNames() {
        System.out.println(NEWLINE + ASK_PLAYER_NAMES);
        String input = Console.readLine();
        return splitInputByDelimiter(input);
    }

    private static List<String> splitInputByDelimiter(String input) {
        return Arrays.stream(input.split(SPLIT_DELIMITER))
            .map(String::strip)
            .toList();
    }

    public static Prizes preparePrizes(Players players) {
        return retryOnException(() -> {
            List<String> prizeNames = askPrizeNames();
            return Prizes.of(prizeNames, players);
        });
    }

    private static List<String> askPrizeNames() {
        System.out.println(NEWLINE + ASK_PRIZE_NAMES);
        String input = Console.readLine();
        return splitInputByDelimiter(input);
    }

    public static LadderHeight prepareLadderHeight() {
        return retryOnException(() -> {
            int ladderHeight = askLadderHeight();
            return new LadderHeight(ladderHeight);
        });
    }

    private static int askLadderHeight() {
        System.out.println(NEWLINE + ASK_LADDER_HEIGHT);
        String input = Console.readLine();
        return parseLadderHeight(input);
    }

    private static int parseLadderHeight(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LADDER_HEIGHT_NOT_INTEGER);
        }
    }

    public static boolean preparePlayerNameAndPrintGameResult(GameResult gameResult) {
        return retryOnException(() -> {
            String playerName = askPlayerNameForSearching();
            OutputView.printSearchingResult(playerName, gameResult);
            return !playerName.equals(SEARCHING_END_CONDITION);
        });
    }

    private static String askPlayerNameForSearching() {
        System.out.println(NEWLINE + ASK_PLAYER_NAME);
        return Console.readLine().strip();
    }

    private static <T> T retryOnException(Supplier<T> retryOperation) {
        try {
            return retryOperation.get();
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e.getMessage());
            return retryOnException(retryOperation);
        }
    }
}
