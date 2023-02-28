package laddergame.view;

import java.util.Map;
import java.util.Map.Entry;
import laddergame.domain.Ladder;
import laddergame.domain.Line;
import laddergame.domain.Point;
import laddergame.domain.dto.ResultsDto;
import laddergame.domain.dto.UsersNameDto;
import laddergame.utils.LadderFormat;

public class OutputView {

    private static final String USER_NAME_ENTER_NOTICE_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String RESULT_ENTER_NOTICE_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String LADDER_HEIGHT_ENTER_NOTICE_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String LADDER_RESULT = "사다리 결과";
    private static final String USER_TO_CHECK_ENTER_NOTICE_MESSAGE = "결과를 보고 싶은 사람은?";
    private static final String GAME_RESULT = "실행 결과";
    private static final String NEXT_LINE = "\n";
    private static final String BLANK = " ";
    private static final String KEY_VALUE_DELIMITER = " : ";

    private static final int MAX_NAME_LENGTH = 5;

    private static final int SECOND_INDEX = 1;

    public void printEnterUserNotice() {
        System.out.println(USER_NAME_ENTER_NOTICE_MESSAGE);
    }

    public void printEnterGameResultsNotice() {
        System.out.println(NEXT_LINE + RESULT_ENTER_NOTICE_MESSAGE);
    }

    public void printEnterHeightNotice() {
        System.out.println(NEXT_LINE + LADDER_HEIGHT_ENTER_NOTICE_MESSAGE);
    }

    public void printLadderResult(Ladder ladder, UsersNameDto usersName, ResultsDto results) {
        System.out.println(NEXT_LINE + LADDER_RESULT + NEXT_LINE);

        String firstUserName = usersName.getNames().get(0);
        String firstResult = results.getResults().get(0);
        int firstLength = Math.max(firstUserName.length(), firstResult.length());

        printUsers(usersName, firstLength);
        printLadder(ladder, firstLength);
        printResults(results, firstLength);
    }

    public void printEnterUserToCheckResultNotice() {
        System.out.println(USER_TO_CHECK_ENTER_NOTICE_MESSAGE);
    }

    public void printResultOfOneUser(String result) {
        System.out.println(NEXT_LINE + GAME_RESULT);
        System.out.println(result + NEXT_LINE);
    }

    public void printResultOfAllUser(Map<String, String> gameResultByUserName) {
        StringBuilder builder = new StringBuilder(NEXT_LINE).append(GAME_RESULT).append(NEXT_LINE);
        for (Entry<String, String> resultByUser : gameResultByUserName.entrySet()) {
            builder.append(resultByUser.getKey()).append(KEY_VALUE_DELIMITER).append(resultByUser.getValue());
            builder.append(NEXT_LINE);
        }
        System.out.println(builder);
    }

    public void printErrorMessage(Exception e) {
        System.out.println(e.getMessage() + NEXT_LINE);
    }

    private void printUsers(UsersNameDto usersName, int firstLength) {
        StringBuilder builder = new StringBuilder();

        String firstUserName = usersName.getNames().get(0);
        builder.append(BLANK.repeat(firstLength - firstUserName.length() + 1)).append(firstUserName);
        for (int index = SECOND_INDEX; index < usersName.getNames().size(); index++) {
            String name = usersName.getNames().get(index);
            builder.append(BLANK.repeat(MAX_NAME_LENGTH + 1 - name.length())).append(name);
        }
        System.out.println(builder);
    }

    private void printLadder(Ladder ladder, int width) {
        StringBuilder builder = new StringBuilder();
        for (Line line : ladder.getLines()) {
            builder.append(BLANK.repeat(width)).append(LadderFormat.LADDER_COLUMN);
            appendLine(builder, line);
            builder.append(NEXT_LINE);
        }
        System.out.print(builder);
    }

    private void printResults(ResultsDto results, int firstLength) {
        StringBuilder builder = new StringBuilder();
        String firstResult = results.getResults().get(0);
        builder.append(BLANK.repeat(firstLength - firstResult.length() + 1)).append(firstResult);
        for (int index = SECOND_INDEX; index < results.getResults().size(); index++) {
            String result = results.getResults().get(index);
            builder.append(BLANK.repeat(MAX_NAME_LENGTH + 1 - result.length())).append(result);
        }
        builder.append(NEXT_LINE);
        System.out.println(builder);
    }

    private void appendLine(StringBuilder builder, Line line) {
        for (Point point : line.getPoints()) {
            builder.append(getConnectionStatus(point));
            builder.append(LadderFormat.LADDER_COLUMN);
        }
    }

    private LadderFormat getConnectionStatus(Point point) {
        if (point.isConnected()) {
            return LadderFormat.CONNECTION;
        }
        return LadderFormat.NON_CONNECTION;
    }

}
