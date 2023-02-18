package view;

import static domain.Name.MAX_NAME_LENGTH;
import static utils.LadderFormat.LADDER_COLUMN;
import static utils.LadderFormat.NON_CONNECTION;
import static utils.LadderFormat.CONNECTION;

import domain.Ladder;
import domain.Line;
import domain.User;
import domain.Users;
import java.util.List;
import utils.LadderFormat;

public class OutputView {

    private final String USER_ENTER_NOTICE_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private final String LADDER_HEIGHT_ENTER_NOTICE_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private final String FINAL_RESULT = "실행결과";
    private final String BLANK = " ";
    private final char NEXT_LINE = '\n';
    private final int SECOND_USER_INDEX = 1;

    public void printEnterUserNotice() {
        System.out.println(USER_ENTER_NOTICE_MESSAGE);
    }

    public void printEnterHeightNotice() {
        System.out.println(LADDER_HEIGHT_ENTER_NOTICE_MESSAGE);
    }

    public void printGameResult(Ladder ladder, Users users) {
        System.out.println(FINAL_RESULT + NEXT_LINE);

        String firstUsersName = users.getFirstUserName();

        printUsers(users);
        printLadder(ladder, firstUsersName.length());
    }

    private void printUsers(Users users) {
        StringBuilder result = new StringBuilder();
        result.append(BLANK)
            .append(users.getFirstUserName());
        buildUserPrintingFormat(users, result);
        System.out.println(result);
    }

    private void buildUserPrintingFormat(Users users, StringBuilder result) {
        List<User> allUsers = users.getUsers();

        for (int index = SECOND_USER_INDEX; index < allUsers.size(); index++) {
            User user = allUsers.get(index);
            String name = user.getName();
            result.append(BLANK.repeat(MAX_NAME_LENGTH + 1 - name.length()))
                .append(name);
        }
    }

    private void printLadder(Ladder ladder, int width) {
        StringBuilder result = new StringBuilder();
        for (Line line : ladder.getLines()) {
            result.append(BLANK.repeat(width))
                .append(LADDER_COLUMN);
            appendLine(result, line);
            result.append(NEXT_LINE);
        }
        System.out.println(result);
    }

    private void appendLine(StringBuilder result, Line line) {
        for (Boolean point : line.getPoints()) {
            result.append(getConnectionStatus(point));
            result.append(LADDER_COLUMN);
        }
    }

    private LadderFormat getConnectionStatus(Boolean point) {
        if (point) {
            return CONNECTION;
        }
        return NON_CONNECTION;
    }

}
