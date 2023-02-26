package view;

import exception.ErrorMessage;
import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String LADDER_MESSAGE = "사다리 결과";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final int SELECT_ONE_USER = 1;

    public void printLadderResultMessage() {
        System.out.println(LADDER_MESSAGE);
        printBlankLine();
    }

    public void printUserNames(final List<String> userNames) {
        final String formattedUserNames = formatUserNames(userNames);
        System.out.println(formattedUserNames);
    }

    public void printLadders(final List<String> renderedLadder) {
        renderedLadder.forEach(System.out::println);
    }

    private String formatUserNames(final List<String> userNames) {
        final StringBuilder builder = new StringBuilder();
        for (final String userName : userNames) {
            final String formattedUserName = String.format("%6s", userName);
            builder.append(formattedUserName);
        }
        return builder.toString();
    }

    public void printErrorMessage(final Exception errorMessage) {
        System.out.println(errorMessage.getMessage());
    }

    public void printPrizes(final List<String> prizeNames) {
        for (final String prizeName : prizeNames) {
            System.out.printf("%6s", prizeName);
        }
        printBlankLine();
        printBlankLine();
    }

    public void printResult(final Map<String, String> userNameAndPrizes) {
        System.out.println(RESULT_MESSAGE);
        if (userNameAndPrizes.size() == SELECT_ONE_USER) {
            printOneUsersPrize(userNameAndPrizes);
            return;
        }
        printAllUsersAndPrizes(userNameAndPrizes);
    }

    private void printOneUsersPrize(final Map<String, String> userNameAndPrize) {
        if (userNameAndPrize.size() != SELECT_ONE_USER) {
            throw new IllegalStateException(ErrorMessage.USER_AND_PRIZE_COUNT_IS_NOT_ONE.getMessage());
        }
        final String prizeName = userNameAndPrize.values().stream().findFirst().get();
        System.out.println(prizeName);
        printBlankLine();
    }

    private void printAllUsersAndPrizes(final Map<String, String> allUsersAndPrizes) {
        for (final String userName : allUsersAndPrizes.keySet()) {
            System.out.printf("%s : %s\n", userName, allUsersAndPrizes.get(userName));
        }
        printBlankLine();
    }

    private void printBlankLine() {
        System.out.println();
    }
}
