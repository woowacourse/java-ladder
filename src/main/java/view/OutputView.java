package view;

import static domain.LadderConnectionStatus.getConnectionStatus;
import static domain.Name.MAX_NAME_LENGTH;

import domain.Ladder;
import domain.Line;
import domain.User;
import domain.Users;
import java.util.List;

public class OutputView {

    private static final String USER_ENTER_NOTICE_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요 )";
    private static final String REWARD_ENTER_NOTICE_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String LADDER_HEIGHT_ENTER_NOTICE_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String CHOICE_USER_NOTICE_MESSAGE = "결과를 보고 싶은 사람은?";
    private static final String LADDER_RESULT = "사다리 결과";
    private static final String FINAL_RESULT = "실행 결과";
    private static final String BLANK = " ";
    private static final String RESULT_DELIMITER = " : ";
    private static final char NEXT_LINE = '\n';
    private static final char LADDER_COLUMN = '|';

    public void printEnterUserNotice() {
        System.out.println(USER_ENTER_NOTICE_MESSAGE);
    }

    public void printEnterChoiceUserNotice() {
        System.out.println(CHOICE_USER_NOTICE_MESSAGE);
    }

    public void printEnterRewardNotice() {
        System.out.println(REWARD_ENTER_NOTICE_MESSAGE);
    }

    public void printEnterHeightNotice() {
        System.out.println(LADDER_HEIGHT_ENTER_NOTICE_MESSAGE);
    }

    public void printFinalResultNotice() {
        System.out.println(FINAL_RESULT);
    }

    public void printGameResult(Ladder ladder, Users users) {
        System.out.println(LADDER_RESULT + NEXT_LINE);

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

}
