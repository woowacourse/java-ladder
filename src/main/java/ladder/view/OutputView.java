package ladder.view;

import ladder.domain.GameResource;
import ladder.domain.GameResult;
import ladder.domain.ladder.Ladder;
import ladder.domain.prize.Prize;
import ladder.domain.prize.Prizes;
import ladder.domain.user.Users;

public class OutputView {

    private static final String RUN_RESULT_MESSAGE = "실행 결과";
    private static final String NEW_LINE = System.lineSeparator();

    private final Formatter formatter = Formatter.getInstance();

    public void printError(String message) {
        System.out.println(message);
    }

    public void printLadderGame(GameResource gameResource) {
        System.out.println(NEW_LINE + RUN_RESULT_MESSAGE + NEW_LINE);
        printUsers(gameResource.getUsers());
        printLadder(gameResource.getLadder());
        printPrizes(gameResource.getPrizes());
    }

    public void printUserResult(Prize prize) {
        System.out.println(NEW_LINE + RUN_RESULT_MESSAGE);
        System.out.println(prize.getPrizeName());
    }

    public void printAllResult(GameResult gameResult) {
        System.out.println(NEW_LINE + RUN_RESULT_MESSAGE);
        String formattedAllResult = formatter.formatAllResult(gameResult);
        System.out.println(formattedAllResult);
    }

    private void printUsers(Users users) {
        String formattedUserNames = formatter.formatUserNames(users);
        System.out.println(formattedUserNames);
    }

    private void printLadder(Ladder ladder) {
        String formatLadder = formatter.formatLadder(ladder);
        System.out.println(formatLadder);
    }

    private void printPrizes(Prizes prizes) {
        String formattedPrizeNames = formatter.formatPrizeNames(prizes);
        System.out.println(formattedPrizeNames);
    }
}
