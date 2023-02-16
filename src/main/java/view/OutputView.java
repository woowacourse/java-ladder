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
        int firstUserNameLength = 0;

        for (int i = 0; i < users.getUsers().size(); i++) {
            User user = users.getUsers().get(i);
            String name = user.getName();
            if (i == 0) {
                firstUserNameLength = user.getName().length();
                System.out.print(name + " ");
                continue;
            }
            System.out.print(" ".repeat(6 - name.length()) + name);
        }
        System.out.println();
        for (Line line : ladder.getLines()) {
            System.out.print(" ".repeat(firstUserNameLength) + "|");
            for (Boolean point : line.getPoints()) {
                System.out.print(point ? "-----" : "     ");
                System.out.print("|");
            }
            System.out.println();
        }
    }
}
