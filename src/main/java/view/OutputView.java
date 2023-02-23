package view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    private static final Map<String, String> PASS_PRINT_STORAGE = new HashMap<>();

    static {
        PASS_PRINT_STORAGE.put("RIGHT", "  |--");
        PASS_PRINT_STORAGE.put("LEFT", "--|  ");
        PASS_PRINT_STORAGE.put("NOTHING", "  |  ");
    }

    public void noticeInputParticipants() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    }

    public void noticeInputHeightOfLadder() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
    }

    public void noticeLadderResult() {
        System.out.println("사다리 결과");
    }

    public void printLadder(List<String> names, List<List<String>> ladder, List<String> results) {
        printNamesOrResults(names);
        for (List<String> line : ladder) {
            System.out.print(joinLine(line));
            System.out.println();
        }
        printNamesOrResults(results);
    }

    private void printNamesOrResults(List<String> namesOrResults) {
        String nameOrresult = namesOrResults.stream()
            .map(nameOrResult -> String.format("%-5s ", nameOrResult))
            .collect(Collectors.joining());
        System.out.println(nameOrresult);
    }

    public void noticeInputResults() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
    }

    public void noticeResultTarget() {
        System.out.println("결과를 보고 싶은 사람은?");
    }

    private void noticeTargetResult() {
        System.out.println("실행 결과");
    }

    public void printWinningInfo(Map<String, Integer> resultBoard, List<String> results) {
        noticeTargetResult();
        for (String player : resultBoard.keySet()) {
            System.out.println(player+ " : " + results.get(resultBoard.get(player)));
        }
    }

    private String joinLine(List<String> line) {
        return line.stream()
            .map(PASS_PRINT_STORAGE::get)
            .collect(Collectors.joining());
    }

}
