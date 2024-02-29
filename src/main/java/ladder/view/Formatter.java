package ladder.view;

import java.util.ArrayList;
import java.util.List;
import ladder.domain.resource.direction.Direction;
import ladder.domain.resource.ladder.Ladder;
import ladder.domain.resource.line.Line;
import ladder.domain.resource.prize.Prize;
import ladder.domain.resource.prize.Prizes;
import ladder.domain.resource.user.User;
import ladder.domain.resource.user.Users;

public class Formatter {

    private static final String SPACE = " ";
    private static final int MAX_LENGTH = 5;
    private static final int SHORT_LENGTH_DEFAULT_SPACE = 1;

    public String formatUserNames(Users users) {
        List<String> userNames = users.getUsers().stream()
                .map(User::getUserName)
                .toList();

        List<String> formattedNames = new ArrayList<>();
        for (String userName : userNames) {
            formattedNames.add(formatUserName(userName));
        }

        return String.join(SPACE, formattedNames);
    }

    public String formatPrizeNames(Prizes prizes) {
        List<String> prizeNames = prizes.getPrizes().stream()
                .map(Prize::getPrizeName)
                .toList();

        List<String> formattedNames = new ArrayList<>();
        for (String prizeName : prizeNames) {
            formattedNames.add(formatPrizeName(prizeName));
        }

        return String.join(SPACE, formattedNames);
    }

    public String formatLadder(Ladder ladder) {
        List<String> ladderFormat = new ArrayList<>();
        for (Line line : ladder.getLines()) {
            ladderFormat.add(formatLine(line));
        }

        return String.join("\n", ladderFormat);
    }

    private String formatUserName(String userName) {
        if (userName.length() < MAX_LENGTH) {
            return String.format("%5s", userName + SPACE);
        }

        return String.format("%5s", userName);
    }

    private String formatPrizeName(String prizeName) {
        if (prizeName.length() < MAX_LENGTH) {
            return String.format("%-5s", prizeName + SPACE);
        }

        return String.format("%-5s", prizeName);
    }

    private String formatLine(Line line) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("    ");
        for (Direction direction : line.getDirections()) {
            stringBuilder.append("|").append(formatDirection(direction));
        }

        return stringBuilder.toString();
    }

    private String formatDirection(Direction direction) {
        if (direction == Direction.RIGHT) {
            return "-----";
        }

        return "     ";
    }
}
