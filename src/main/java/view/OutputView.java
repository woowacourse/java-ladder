package view;

import domain.game.Results;
import domain.ladder.Ladder;
import domain.ladder.Line;
import domain.ladder.PointStatus;
import domain.user.User;
import domain.user.Users;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {
    private static final String OUTPUT_EXECUTE_MESSAGE = "\n사다리 결과\n";
    private static final String OUTPUT_RESULT_MESSAGE = "\n실행 결과";
    private static final String LINE_DELIMITER = "|";
    private static final String SPACE_SEPARATOR = " ";
    public static final String RESULT_SEPARATOR = " : ";
    public static final String GAME_QUIT_MESSAGE = "실행을 종료합니다.";

    public boolean printResultByUser(Map<String, String> resultMap, String findUser, List<String> userNames) {
        if (findUser.equals(Users.END)) {
            System.out.println(GAME_QUIT_MESSAGE);
            return false;
        }
        System.out.println(OUTPUT_RESULT_MESSAGE);
        if (findUser.equals(Users.ALL)) {
            printAllUserResult(resultMap, userNames);
            return true;
        }
        System.out.println(resultMap.get(findUser));
        return true;
    }

    private void printAllUserResult(Map<String, String> resultMap, List<String> userNames) {
        for (String name : userNames) {
            System.out.println(new StringBuilder()
                    .append(name).append(RESULT_SEPARATOR)
                    .append(resultMap.get(name)));
        }
    }

    public void printUserNames(Users users) {
        System.out.println(OUTPUT_EXECUTE_MESSAGE);
        System.out.println(SPACE_SEPARATOR + users.getUserNames()
                .stream()
                .map(this::convertBlankString)
                .collect(Collectors.joining(SPACE_SEPARATOR)));
    }

    public void printResults(Results results) {
        System.out.println(SPACE_SEPARATOR + results.getResults()
                .stream()
                .map(this::convertBlankString)
                .collect(Collectors.joining(SPACE_SEPARATOR)));
    }

    public String convertBlankString(String word) {
        if (word.length() == User.MAX_NAME_LENGTH) {
            return word;
        }
        return insertBlank(word);
    }

    private String insertBlank(String name) {
        StringBuilder nameBuilder = new StringBuilder(name + SPACE_SEPARATOR);
        while (nameBuilder.length() < User.MAX_NAME_LENGTH) {
            nameBuilder.insert(0, SPACE_SEPARATOR);
        }
        return nameBuilder.toString();
    }


    public void printLadder(Ladder ladder) {
        for (Line line : ladder.getLines()) {
            printLine(line);
            System.out.println();
        }
    }

    private void printLine(Line line) {
        for (boolean point : line.getPoints()) {
            printLineByPoint(point);
        }
    }

    private void printLineByPoint(boolean point) {
        System.out.print(PointStatus.printStatus(point, User.MAX_NAME_LENGTH));
        System.out.print(LINE_DELIMITER);
    }
}
