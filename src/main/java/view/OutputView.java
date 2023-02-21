package view;

import domain.Bridge;
import domain.Line;
import domain.Users;

import java.util.stream.Collectors;

public class OutputView {

    private static final String LADDER_FORMAT = "    |%s|%n";
    private static final String RESULT_MESSAGE = "\n실행결과\n";
    private static final String USER_NAME_FORMAT = "%5s ";
    private static final String BRIDGE_DELIMITER = "|";

    public void printUsers(Users users) {
        System.out.println(RESULT_MESSAGE);
        users.getUsers()
                .forEach(user -> System.out.printf(USER_NAME_FORMAT, user.getName()));
        System.out.println();
    }

    public void printLadder(Line line) {
        String collect = line.getLadder().stream()
                .map(Bridge::getFormat)
                .collect(Collectors.joining(BRIDGE_DELIMITER));
        System.out.printf(LADDER_FORMAT, collect);
    }

    public void printExceptionMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
