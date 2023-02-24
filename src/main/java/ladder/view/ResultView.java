package ladder.view;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import ladder.domain.Row;
import ladder.domain.Step;

public class ResultView {
    private static final String LADDER_RESULT_HEADER = "사다리 결과\n";
    private static final String ERROR_MESSAGE_HEADER = "[ERROR] ";
    private static final String RESULT_MESSAGE_HEADER = "실행 결과\n";
    private static final String PRIZE_OF_PLAYERS_DELIMITER = " : ";

    public void printLadderResultHeader() {
        System.out.println(LADDER_RESULT_HEADER);
    }

    public void printNames(List<String> names) {
        for (String name : names) {
            System.out.printf("%6s", name);
        }
        System.out.println();
    }

    public void printLadder(List<Row> ladder) {
        ladder.stream()
                .map(Row::getRow)
                .map(this::generateRow)
                .forEach(System.out::println);
    }

    protected String generateRow(List<Step> row) {
        return row.stream()
                .map(Step::getMark)
                .collect(Collectors.joining("|", "     |", "|"));
    }

    public void printErrorMessage(String message) {
        System.out.println(ERROR_MESSAGE_HEADER + message);
    }

    public void printPrizeOfPlayer(String prize) {
        System.out.println(RESULT_MESSAGE_HEADER + prize);
    }

    public void printPrizeOfPlayers(Map<String, String> prizes) {
        for (String key : prizes.keySet()) {
            System.out.println(key + PRIZE_OF_PLAYERS_DELIMITER + prizes.get(key));
        }
    }

    public void printEndMessage() {
        System.out.println("프로그램을 종료합니다.");
    }
}
