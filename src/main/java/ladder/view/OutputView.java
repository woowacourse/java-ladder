package ladder.view;

import ladder.domain.direction.Direction;
import ladder.domain.ladder.Ladder;
import ladder.domain.line.Line;
import ladder.domain.user.User;
import ladder.domain.user.Users;

import java.util.List;

public class OutputView {
    public void printLadderGameResult(Users users, Ladder ladder) {
        System.out.println("\n실행결과\n");
        printUserNames(users);
        printLadder(ladder);
    }

    private void printUserNames(Users users) {
        StringBuilder sb = new StringBuilder();
        for (User user : users.getUsers()) {
            String userName = user.getUserName();
            appendNameFormat(userName, sb);
        }
        System.out.println(sb);
    }

    private void printLadder(Ladder ladder) {
        List<Line> lines = ladder.getLines();
        StringBuilder sb = new StringBuilder();
        for (Line line : lines) {
            sb.append("    ");
            List<Direction> directionsInfo = line.getDirectionsInfo();
            for (Direction direction : directionsInfo) {
                sb.append("|");
                if (direction == Direction.RIGHT) {
                    sb.append("-----");
                }
                if (direction != Direction.RIGHT) {
                    sb.append("     ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private void appendNameFormat(String userName, StringBuilder sb) {
        if (userName.length() == 5) {
            sb.append(userName).append(" ");
        }
        if (userName.length() < 5) {
            String blank = " ";
            String blankFormats = blank.repeat(4 - userName.length());
            sb.append(blankFormats).append(userName).append(blank).append(blank);
        }
    }
}
