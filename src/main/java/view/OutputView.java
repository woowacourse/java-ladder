package view;

import domain.Line;
import domain.Prize;
import java.util.List;
import java.util.Map;

//TODO: static 키워드 제거
public class OutputView {
    private static final String RESULT_MESSAGE = "실행결과";

    public static void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
        System.out.println();
    }

    public static void printUserNames(final List<String> userNames) {
        final String formattedUserNames = formatUserNames(userNames);
        System.out.println(formattedUserNames);
    }

    public static void printResult(final List<Line> lines) {
        for (final Line line : lines) {
            System.out.println(LineRender.render(line));
        }
    }

    private static String formatUserNames(final List<String> userNames) {
        final StringBuilder builder = new StringBuilder();
        for (final String userName : userNames) {
            final String formattedUserName = String.format("%6s", userName);
            builder.append(formattedUserName);
        }
        return builder.toString();
    }

    public static void printErrorMessage(final Exception errorMessage) {
        System.out.println(errorMessage.getMessage());
    }

    public static void printPrizes(final List<Prize> prizes) {
        for (final Prize prize : prizes) {
            System.out.println(String.format("%6s", prize.getName()));
        }
    }

    public static void printPrize(final Prize prize) {
        System.out.println(prize.getName());
        System.out.println();
    }

    public static void printAllUsersAndPrizes(final Map<String, String> allUsersAndPrizes) {
        for (final Map.Entry<String, String> entry : allUsersAndPrizes.entrySet()) {
            System.out.printf("%s: %s\n", entry.getKey(), entry.getValue());
        }
    }
}
