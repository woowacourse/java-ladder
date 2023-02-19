package view;

import domain.*;

import java.util.stream.Collectors;

public class OutputView {
    private static final String RESULT_MESSAGE = "\n실행결과\n";
    private static final String USER_NAME_FORMAT = "%5s ";
    private static final String BRIDGE_DELIMITER = "|";

    public void printLadderResult(Users users, Items items, Ladders ladders) {
        printUsers(users);
        printLadders(ladders);
        printItems(items);
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
                .forEach(item -> System.out.printf("USER_NAME_FORMAT", item.getItem()));
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
