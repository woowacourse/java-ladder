package ladder.view;

import java.util.HashMap;
import ladder.domain.game.GameResource;
import ladder.domain.game.GameResult;
import ladder.domain.resource.ladder.Ladder;
import ladder.domain.resource.prize.Prize;
import ladder.domain.resource.prize.Prizes;
import ladder.domain.resource.user.User;
import ladder.domain.resource.user.Users;

public class OutputView {

    private static final String BLANK = " ";
    private static final String LINE_VERTICAL = "|";
    private static final String LINE_HORIZONTAL = "-----";
    private static final int MAX_NAME_LENGTH = 5;

    private final Formatter formatter = new Formatter();

    public void printError(String message) {
        System.out.println(message);
    }

    public void printLadderGame(GameResource gameResource) {
        System.out.println("\n실행결과\n");
        printUsers(gameResource.getUsers());
        printLadder(gameResource.getLadder());
        printPrizes(gameResource.getPrizes());
    }

    public void printUserResult(Prize prize) {
        System.out.println("\n실행 결과");
        System.out.println(prize.getPrizeName());
    }

    public void printAllResult(GameResult gameResult) {
        System.out.println("\n실행 결과");

        HashMap<User, Prize> allResult = gameResult.getAllResult();
        for (User user : allResult.keySet()) {
            Prize prize = allResult.get(user);
            System.out.printf("%s : %s\n", user.getUserName(), prize.getPrizeName());
        }
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
