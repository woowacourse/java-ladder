package view;

import domain.Bridge;
import domain.WinningResult;
import dto.LineDTO;
import dto.UsersDTO;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String LADDER_FORMAT = "    |%s|%n";
    private static final String RESULT_MESSAGE = "\n실행결과\n";
    private static final String USER_NAME_FORMAT = "%5s ";
    private static final String BRIDGE_DELIMITER = "|";

    public void printUsers(final UsersDTO usersDTO) {
        System.out.println(RESULT_MESSAGE);
        usersDTO.getUsersDTO()
                .forEach(user -> System.out.printf(USER_NAME_FORMAT, user));
        System.out.println();
    }

    public void printLadder(final LineDTO lineDTO) {
        String collect = lineDTO.getLineDTO().stream()
                .map(Bridge::getFormat)
                .collect(Collectors.joining(BRIDGE_DELIMITER));
        System.out.printf(LADDER_FORMAT, collect);
    }

    public void printResult(final List<WinningResult> winningResults) {
        winningResults
                .forEach(result -> System.out.printf(USER_NAME_FORMAT, (result.getWinningResult())));
        System.out.println();
    }

    public void printExceptionMessage(final String errorMessage) {
        System.out.println(errorMessage);
    }
}
