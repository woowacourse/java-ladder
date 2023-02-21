package view;

import domain.*;

import java.util.HashMap;
import java.util.stream.Collectors;

public class OutputView {
    private static final String RESULT_MESSAGE = "\n사다리 결과\n";
    private static final String USER_RESULT_MESSAGE = "\n실행 결과";
    private static final String USERS_RESULT_FORMAT = "%s : %s\n";
    private static final String USER_NAME_FORMAT = "%5s ";
    private static final String BRIDGE_DELIMITER = "|";

    public void printLadderResultBoard(Users users, Items items, Ladders ladders) {
        printUsers(users);
        printLadders(ladders);
        printItems(items);
    }

    public void printUserResult(HashMap<User, Item> result) {
        System.out.println(USER_RESULT_MESSAGE);

        result.forEach((key, value)
                -> System.out.print(UserResultFormat(result.size(), key.getName(), value.getItem())));
    }

    public String UserResultFormat(int size, String key, String value) {
        if (size > 1) {
            return String.format(USERS_RESULT_FORMAT, key, value);
        }
        return value + "\n";
    }

    private void printUsers(Users users) {
        System.out.println(RESULT_MESSAGE);
        users.getUsers()
                .forEach(user -> System.out.printf(USER_NAME_FORMAT, user.getName()));
        System.out.println();
    }

    private void printLadders(Ladders ladders) {
        String result = ladders.getLadders()
                .stream()
                .map(this::printLadder)
                .collect(Collectors.joining("\n"));
        System.out.println(result);
    }

    private void printItems(Items items) {
        items.getItems()
                .forEach(item -> System.out.printf(USER_NAME_FORMAT, item.getItem()));
    }

    private String printLadder(Ladder ladder) {
        return ladder.getLadder()
                .stream()
                .map(Position::getFormat)
                .collect(Collectors.joining(BRIDGE_DELIMITER)) + BRIDGE_DELIMITER;
    }

    public void printExceptionMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
