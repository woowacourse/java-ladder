package laddergame.view;

import static laddergame.domain.Name.BLANK;
import static laddergame.domain.Name.MAX_NAME_LENGTH;

import java.util.Map;
import java.util.Map.Entry;
import laddergame.domain.GameResult;
import laddergame.domain.GameResults;
import laddergame.domain.Ladder;
import laddergame.domain.Line;
import laddergame.domain.Point;
import laddergame.domain.User;
import laddergame.domain.Users;
import laddergame.utils.LadderFormat;

public class OutputView {

    private static final String USER_ENTER_NOTICE_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String LADDER_HEIGHT_ENTER_NOTICE_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String LADDER_RESULT = "사다리 결과";
    private static final char NEXT_LINE = '\n';

    private static final int SECOND_INDEX = 1;

    public void printEnterUserNotice() {
        System.out.println(USER_ENTER_NOTICE_MESSAGE);
    }

    public void printEnterGameResultsNotice() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
    }

    public void printEnterHeightNotice() {
        System.out.println(LADDER_HEIGHT_ENTER_NOTICE_MESSAGE);
    }

    public void printLadderResult(Ladder ladder, Users users, GameResults gameResults) {
        System.out.println(LADDER_RESULT + NEXT_LINE);

        String firstUserName = users.getFirstUserName();
        String firstResult = gameResults.getFirstResult();
        int firstLength = Math.max(firstUserName.length(), firstResult.length());

        printUsers(users, firstLength);
        printLadder(ladder, users.getFirstUserName().length());
        printResults(gameResults, firstLength);
    }

    public void printEnterUserToCheckResultNotice() {
        System.out.println("결과를 보고 싶은 사람은?");
    }

    public void printResultOfOneUser(String result) {
        System.out.println(result + NEXT_LINE);
    }

    public void printResultOfAllUser(Map<String, String> gameResultByUserName) {
        StringBuilder builder = new StringBuilder();
        for (Entry<String, String> resultByUser : gameResultByUserName.entrySet()) {
            builder.append(resultByUser.getKey()).append(" : ").append(resultByUser.getValue());
            builder.append(NEXT_LINE);
        }
        System.out.println(builder);
    }

    public void printErrorMessage(Exception e) {
        System.out.println(e.getMessage() + NEXT_LINE);
    }

    private void printUsers(Users users, int firstLength) {
        StringBuilder result = new StringBuilder();

        String firstUserName = users.getFirstUserName();
        result.append(BLANK.repeat(firstLength - firstUserName.length())).append(firstUserName);
        for (int index = SECOND_INDEX; index < users.getUsers().size(); index++) {
            User user = users.getUsers().get(index);
            String name = user.getName();
            result.append(BLANK.repeat(MAX_NAME_LENGTH + 1 - name.length())).append(name);
        }
        System.out.println(result);
    }

    private void printLadder(Ladder ladder, int width) {
        StringBuilder result = new StringBuilder();
        for (Line line : ladder.getLines()) {
            result.append(BLANK.repeat(width)).append(LadderFormat.LADDER_COLUMN);
            appendLine(result, line);
            result.append(NEXT_LINE);
        }
        System.out.print(result);
    }

    private void printResults(GameResults gameResults, int firstLength) {
        StringBuilder builder = new StringBuilder();
        String firstResult = gameResults.getFirstResult();
        builder.append(BLANK.repeat(firstLength - firstResult.length())).append(firstResult);
        for (int index = SECOND_INDEX; index < gameResults.getResults()
                .size(); index++) {
            GameResult gameResult = gameResults.getResults().get(index);
            String result = gameResult.getResult();
            builder.append(BLANK.repeat(MAX_NAME_LENGTH + 1 - result.length())).append(result);
        }
        System.out.println(builder);
    }

    private void appendLine(StringBuilder result, Line line) {
        for (Point point : line.getPoints()) {
            result.append(getConnectionStatus(point.isConnected()));
            result.append(LadderFormat.LADDER_COLUMN);
        }
    }

    private LadderFormat getConnectionStatus(Boolean point) {
        if (point) {
            return LadderFormat.CONNECTION;
        }
        return LadderFormat.NON_CONNECTION;
    }

}
