package ladder.view;

import java.util.List;
import ladder.domain.Step;
import ladder.dto.ResultDto;
import ladder.dto.RowsDto;
import ladder.dto.NamesDto;

public class ResultView {

    private ResultView() {
    }

    public static void printResult(NamesDto playerNamesDto, RowsDto rowsDto,
        NamesDto rewardNamesDto) {
        printResultTitle();
        printNames(playerNamesDto);
        printRows(rowsDto);
        printNames(rewardNamesDto);
        System.out.println();
    }

    private static void printResultTitle() {
        System.out.println("사다리 결과");
        System.out.println();
    }

    private static void printNames(NamesDto namesDto) {
        namesDto.getNames().forEach(ResultView::printName);
        System.out.println();
    }

    private static void printName(String name) {
        System.out.printf("%6s", name);
    }

    private static void printRows(RowsDto rowsDto) {
        List<List<Step>> lines = rowsDto.getLines();
        lines.forEach(ResultView::printRow);
    }

    private static void printRow(List<Step> steps) {
        System.out.print("     |");
        for (int i = 0; i < steps.size(); i++) {
            printLeg(steps, i);
        }
        System.out.println();
    }

    private static void printLeg(List<Step> steps, int index) {
        if (steps.get(index) == Step.CONNECTED) {
            System.out.print("-----|");
            return;
        }
        System.out.print("     |");
    }

    public static void printResult(String result) {
        System.out.println();
        System.out.println("실행 결과");
        System.out.println(result);
        System.out.println();
    }

    public static void printAllResult(ResultDto resultDto) {
        System.out.println();
        System.out.println("실행 결과");
        resultDto.getResults().entrySet().stream()
            .forEach(result -> System.out.println(result.getKey() + " : " + result.getValue()));
        System.out.println();
    }

    public static void printQuitMessage() {
        System.out.println("사다리 게임을 종료합니다.");
    }

    public static void printErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }
}
