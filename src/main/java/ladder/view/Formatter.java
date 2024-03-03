package ladder.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import ladder.domain.GameResult;
import ladder.domain.direction.Direction;
import ladder.domain.ladder.Ladder;
import ladder.domain.line.Line;
import ladder.domain.prize.Prize;
import ladder.domain.prize.Prizes;
import ladder.domain.user.User;
import ladder.domain.user.Users;

public class Formatter {

    private static final String SPACE = " ";
    private static final String NEW_LINE = "\n";
    private static final String RIGHT_ALIGNED_FORMAT = "%5s";
    private static final String LEFT_ALIGNED_FORMAT = "%-5s";
    private static final String RESULT_FORMAT = "%s : %s";
    private static final String LINE = "|";
    private static final String CONNECTION_NO = "     ";
    private static final String CONNECTION_YES = "-----";
    private static final int MAX_LENGTH = 5;

    private static final Formatter instance = new Formatter();

    private Formatter() {
    }

    public static Formatter getInstance() {
        return instance;
    }

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

        return String.join(NEW_LINE, ladderFormat);
    }

    public String formatAllResult(GameResult gameResult) {
        List<String> allResultFormat = new ArrayList<>();

        Map<User, Prize> allResult = gameResult.getAllResult();
        for (User user : allResult.keySet()) {
            Prize prize = allResult.get(user);
            allResultFormat.add(formatResult(user.getUserName(), prize.getPrizeName()));
        }

        return String.join(NEW_LINE, allResultFormat);
    }

    private String formatUserName(String userName) {
        if (userName.length() < MAX_LENGTH) {
            return String.format(RIGHT_ALIGNED_FORMAT, userName + SPACE);
        }

        return String.format(RIGHT_ALIGNED_FORMAT, userName);
    }

    private String formatPrizeName(String prizeName) {
        if (prizeName.length() < MAX_LENGTH) {
            return String.format(LEFT_ALIGNED_FORMAT, prizeName + SPACE);
        }

        return String.format(LEFT_ALIGNED_FORMAT, prizeName);
    }

    private String formatLine(Line line) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(CONNECTION_NO);
        for (Direction direction : line.getDirectionInfo()) {
            stringBuilder.append(LINE).append(formatDirection(direction));
        }

        return stringBuilder.toString();
    }

    private String formatDirection(Direction direction) {
        if (direction == Direction.RIGHT) {
            return CONNECTION_YES;
        }

        return CONNECTION_NO;
    }

    private String formatResult(String userName, String prizeName) {
        return String.format(RESULT_FORMAT, userName, prizeName);
    }
}
