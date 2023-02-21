package view;

import domain.ladder.Line;
import domain.user.User;
import dto.ladder.LadderDto;
import dto.ladder.LineDto;
import dto.user.UsersDto;
import java.util.ArrayList;
import java.util.List;

public class OutputView {
    private static final String OUTPUT_EXECUTE_MESSAGE = "\n실행결과\n";
    private static final String LINE_DELIMITER = "|";
    private static final String NAME_DELIMITER = " ";

    public void printLadderGameResult(UsersDto usersDto, LadderDto ladderDto) {
        System.out.println(OUTPUT_EXECUTE_MESSAGE);
        System.out.println(" " + printUserNames(usersDto.getUserNames()));
        printLadder(ladderDto);
    }

    private String printUserNames(List<String> userNames) {
        List<String> convertedUserNames = new ArrayList<>();
        for (String userName : userNames) {
            convertedUserNames.add(convertName(userName));
        }
        return String.join(NAME_DELIMITER, convertedUserNames);
    }

    private String convertName(String name) {
        if (name.length() == User.MAX_NAME_LENGTH) {
            return name;
        }
        return insertBlank(name);
    }

    private String insertBlank(String name) {
        StringBuilder nameBuilder = new StringBuilder(name + " ");
        while (nameBuilder.length() < User.MAX_NAME_LENGTH) {
            nameBuilder.insert(0, " ");
        }
        return nameBuilder.toString();
    }

    private void printLadder(LadderDto ladderDto) {
        for (Line line : ladderDto.getLines()) {
            printLine(LineDto.from(line));
            System.out.println();
        }
    }

    private void printLine(LineDto lineDto) {
        for (boolean status : lineDto.getLine()) {
            printLineByStatus(status);
        }
    }

    private void printLineByStatus(boolean status) {
        System.out.print(LineStatus.printStatus(status, User.MAX_NAME_LENGTH));
        System.out.print(LINE_DELIMITER);
    }
}
