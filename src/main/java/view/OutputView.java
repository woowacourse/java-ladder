package view;

import domain.Bridge;
import domain.Ladder;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String LADDER_FORMAT = "    |%s|";
    private static final String RESULT_MESSAGE = "\n실행결과";

    public void printUsers(List<String> users) {
        System.out.println(RESULT_MESSAGE);
        for (String user : users) { //스트림
            System.out.printf("%5s ", user); //상수
        }
        System.out.println();
    }

    public void printLadder(Ladder ladder) {
        String collect = ladder.getLadder().stream()
                .map(Bridge::getFormat) // 메소드 참조
                .collect(Collectors.joining("|")); // 상수
        System.out.println(String.format(LADDER_FORMAT, collect));
    }
}
