package view;

import domain.Bridge;
import domain.WinningResult;
import dto.LineDTO;
import dto.UsersDTO;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    private static final String LADDER_FORMAT = "    |%s|%n";
    private static final String RESULT_MESSAGE = "\n실행결과";
    private static final String USER_NAME_FORMAT = "%5s ";
    private static final String BRIDGE_DELIMITER = "|";
    private static final String PRINT_RESULT_FORMAT = "%s : %s";
    private static final String GAME_EXIT_MESSAGE = "모든 결과를 출력하고 종료합니다.";

    public void printLadder(final LineDTO lineDTO) {
        String collect = lineDTO.getLineDTO().stream()
                .map(Bridge::getFormat)
                .collect(Collectors.joining(BRIDGE_DELIMITER));
        System.out.printf(LADDER_FORMAT, collect);
    }

    public void printUsers(final UsersDTO usersDTO) {
        System.out.println(RESULT_MESSAGE);
        usersDTO.getUsersDTO()
                .forEach(user -> System.out.printf(USER_NAME_FORMAT, user));
        System.out.println();
    }

    public void printWinningResult(final List<WinningResult> winningResults) {
        winningResults
                .forEach(result -> System.out.printf(USER_NAME_FORMAT, (result.getWinningResult())));
        System.out.println();
    }

    public void printGameResult(final Map<String, WinningResult> result) {
        System.out.println(RESULT_MESSAGE);
        for (Map.Entry<String, WinningResult> gameResult : result.entrySet()) {
            System.out.printf(PRINT_RESULT_FORMAT, gameResult.getKey(), gameResult.getValue().getWinningResult());
            System.out.println();
        }
        if (result.size() > 1) {
            System.out.println(GAME_EXIT_MESSAGE);
        }
    }

    public void printExceptionMessage(final String errorMessage) {
        System.out.println(errorMessage);
        System.out.println();
    }
}
