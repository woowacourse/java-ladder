package ladder.view;

import java.util.List;
import ladder.domain.direction.Direction;
import ladder.domain.ladder.Ladder;
import ladder.domain.line.Line;
import ladder.domain.prize.Prizes;
import ladder.domain.result.Result;
import ladder.domain.user.Users;

public class OutputView {

    private static final String BLANK = " ";
    private static final String LINE_VERTICAL = "|";
    private static final String LINE_HORIZONTAL = "-----";
    private static final String DELIMITER = " : ";
    private static final int MAX_NAME_LENGTH = 5;
    public static final int BLANK_DEFAULT_COUNT = 4;

    public void printError(String message) {
        System.out.println(message);
    }

    public void printLadderResult(Users users, Ladder ladder, Prizes prizes) {
        System.out.println("\n사다리 결과\n");
        printUserNames(users);
        printLadder(ladder);
        printPrizes(prizes);
    }

    public void printUserPrize(String userName, Result result) {
        System.out.println("\n실행결과");
        System.out.println(result.getPrizeByUser(userName));
    }

    public void printAllPrizeResult(List<String> allResult) {
        System.out.println("\n실행결과");
        for (int i = 0; i < allResult.size(); i += 2) {
            System.out.println(allResult.get(i) + DELIMITER + allResult.get(i + 1));
        }
    }

    private void printUserNames(Users users) {
        StringBuilder sb = new StringBuilder();
        for(String userName : users.getUsersNames()) {
            appendNameFormat(sb, userName);
        }
        System.out.println(sb);
    }

    private void appendNameFormat(StringBuilder sb, String userName) {
        if (userName.length() < MAX_NAME_LENGTH) {
            sb.append(BLANK.repeat(BLANK_DEFAULT_COUNT - userName.length()));
        }

        sb.append(userName).append(BLANK);

        if (userName.length() < MAX_NAME_LENGTH) {
            sb.append(BLANK);
        }
    }

    private void printLadder(Ladder ladder) {
        List<Line> lines = ladder.getLines();
        StringBuilder sb = new StringBuilder();
        for (Line line : lines) {
            printLine(sb, line.getDirectionsInfo());
        }
        System.out.print(sb);
    }

    private void printLine(StringBuilder sb, List<Direction> directionsInfo) {
        sb.append(BLANK.repeat(BLANK_DEFAULT_COUNT));
        for (int i = 0; i < directionsInfo.size() - 1; i++) {
            sb.append(LINE_VERTICAL)
                    .append(printDirections(directionsInfo.get(i)));
        }
        sb.append(LINE_VERTICAL).append("\n");
    }

    private String printDirections(Direction direction) {
        if (direction == Direction.RIGHT) {
            return LINE_HORIZONTAL;
        }
        return BLANK.repeat(MAX_NAME_LENGTH);
    }

    private void printPrizes(Prizes prizes) {
        StringBuilder sb = new StringBuilder();
        for(String prizeName : prizes.getPrizesNames()) {
            appendNameFormat(sb, prizeName);
        }
        System.out.println(sb);
    }
}
