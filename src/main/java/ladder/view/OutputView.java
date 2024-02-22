package ladder.view;

import java.util.List;
import ladder.domain.direction.Direction;
import ladder.domain.ladder.Ladder;
import ladder.domain.line.Line;
import ladder.domain.user.User;
import ladder.domain.user.Users;

public class OutputView {

    private static final String BLANK = " ";
    private static final String LINE_VERTICAL = "|";
    private static final String LINE_HORIZONTAL = "-----";
    private static final int MAX_NAME_LENGTH = 5;

    public void printError(String message) {
        System.out.println(message);
    }

    public void printLadderGameResult(Users users, Ladder ladder) {
        System.out.println("\n실행결과\n");
        printUserNames(users);
        printLadder(ladder);
    }

    private void printUserNames(Users users) {
        StringBuilder sb = new StringBuilder();
        for (User user : users.getUsers()) {
            String userName = user.getUserName();
            sb.append(appendNameFormat(userName));
        }
        System.out.println(sb);
    }

    private String appendNameFormat(String userName) {
        if (userName.length() < MAX_NAME_LENGTH) {
            String blankFormats = BLANK.repeat(4 - userName.length());
            return blankFormats + userName + BLANK.repeat(2);
        }
        return userName + BLANK;
    }

    private void printLadder(Ladder ladder) {
        List<Line> lines = ladder.getLines();
        StringBuilder sb = new StringBuilder();
        for (Line line : lines) {
            printLine(sb, line.getDirectionsInfo());
        }
        System.out.println(sb);
    }

    private void printLine(StringBuilder sb, List<Direction> directionsInfo) {
        sb.append(BLANK.repeat(4));
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
        return BLANK.repeat(5);
    }
}
