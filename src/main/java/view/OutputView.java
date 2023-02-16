package view;

import domain.Ladder;
import domain.Line;
import domain.User;
import domain.Users;

public class OutputView {

    public void printEnterUserNotice() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    }

    public void printEnterHeightNotice() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
    }

    public void printGameResult(Ladder ladder, Users users) {
        System.out.println("실행결과");
        System.out.println();

        printUsers(users);

        printLadder(ladder, users.getFirstUserName().length());
    }

    private void printUsers(Users users) {
        StringBuilder result = new StringBuilder();
        result.append(" ").append(users.getFirstUserName());
        for (int index = 1; index < users.getUsers().size(); index++) {
            User user = users.getUsers().get(index);
            String name = user.getName();
            result.append(" ".repeat(6 - name.length())).append(name);
        }
        System.out.println(result);
    }

    private void printLadder(Ladder ladder, int width) {
        StringBuilder result = new StringBuilder();
        for (Line line : ladder.getLines()) {
            result.append(" ".repeat(width)).append("|");
            appendLine(result, line);
            result.append("\n");
        }
        System.out.println(result);
    }

    private void appendLine(StringBuilder result, Line line) {
        for (Boolean point : line.getPoints()) {
            result.append(getConnectionStatus(point));
            result.append("|");
        }
    }

    private String getConnectionStatus(Boolean point) {
        if (point) {
            return "-----";
        }
        return "     ";
    }
}
