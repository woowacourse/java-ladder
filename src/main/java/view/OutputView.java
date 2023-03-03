package view;

import dto.ladder.LadderDto;
import dto.ladder.LineDto;
import dto.prize.PrizesDto;
import dto.user.UsersDto;
import java.util.ArrayList;
import java.util.List;

public class OutputView {
    private static final String OUTPUT_EXECUTE_MESSAGE = "\n실행결과\n";
    private static final String LINE_DELIMITER = "|";
    private static final String NAME_DELIMITER = " ";
    private static final int MAX_NAME_LENGTH = 5;

    public void printLadderGameResult(UsersDto usersDto, LadderDto ladderDto, PrizesDto prizesDto) {
        System.out.println(OUTPUT_EXECUTE_MESSAGE);
        System.out.println(" " + printUserNames(usersDto.getUserNames()));
        printLadder(ladderDto);
        printPrizes(prizesDto);
    }

    private String printUserNames(List<String> userNames) {
        List<String> convertedUserNames = new ArrayList<>();
        for (String userName : userNames) {
            convertedUserNames.add(convertName(userName));
        }
        return String.join(NAME_DELIMITER, convertedUserNames);
    }

    private String convertName(String name) {
        if (name.length() == MAX_NAME_LENGTH) {
            return name;
        }
        return insertBlank(name);
    }

    private String insertBlank(String name) {
        StringBuilder nameBuilder = new StringBuilder(name + " ");
        while (nameBuilder.length() < MAX_NAME_LENGTH) {
            nameBuilder.insert(0, " ");
        }
        return nameBuilder.toString();
    }

    private void printLadder(LadderDto ladderDto) {
        for (LineDto lineDto : ladderDto.getLines()) {
            printLine(lineDto);
            System.out.println();
        }
    }

    private void printLine(LineDto lineDto) {
        for (boolean status : lineDto.getLine()) {
            printLineByStatus(status);
        }
    }

    private void printLineByStatus(boolean status) {
        System.out.print(LineStatus.printStatus(status, MAX_NAME_LENGTH));
        System.out.print(LINE_DELIMITER);
    }

    private void printPrizes(PrizesDto prizesDto) {
        System.out.println(" " + convertPrizeNames(prizesDto.getPrizeNames()));
    }

    private String convertPrizeNames(List<String> prizeNames) {
        List<String> convertedPrizeNames = new ArrayList<>();
        for (String prizeName : prizeNames) {
            convertedPrizeNames.add(insertBlank(prizeName));
        }
        return String.join(NAME_DELIMITER, convertedPrizeNames);
    }

    public void printAllResult(List<String> userNames, List<String> prizeNames) {
        for (int i = 0; i < userNames.size(); i++) {
            System.out.println(userNames.get(i) + " : " + prizeNames.get(i));
        }
    }

    public void printOneResult(String result) {
        System.out.println(result);
    }
}
