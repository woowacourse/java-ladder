package view;

import domain.Line;
import domain.Prize;
import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String LADDER_MESSAGE = "사다리 결과";
    private static final String RESULT_MESSAGE = "실행 결과";

    public void printLadderResultMessage() {
        System.out.println(LADDER_MESSAGE);
        printBlankLine();
    }

    public void printUserNames(final List<String> userNames) {
        final String formattedUserNames = formatUserNames(userNames);
        System.out.println(formattedUserNames);
    }

    public void printLadders(final List<Line> lines) {
        for (final Line line : lines) {
            System.out.println(LineRender.render(line));
        }
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

    public void printPrizes(final List<Prize> prizes) {
        for (final Prize prize : prizes) {
            System.out.print(String.format("%6s", prize.getName()));
        }
        printBlankLine();
        printBlankLine();
    }

    public void printPrize(final Prize prize) {
        System.out.println(RESULT_MESSAGE);
        System.out.println(prize.getName());
        printBlankLine();
    }

    public void printAllUsersAndPrizes(final Map<String, String> allUsersAndPrizes) {
        System.out.println(RESULT_MESSAGE);
        for (final Map.Entry<String, String> entry : allUsersAndPrizes.entrySet()) {
            System.out.printf("%s: %s\n", entry.getKey(), entry.getValue());
        }
        printBlankLine();
    }

    private void printBlankLine() {
        System.out.println();
    }
}
