package ladder.view;

import java.util.List;
import ladder.dto.NamesDto;
import ladder.dto.RowsDto;

public class ResultView {

    private ResultView() {
    }

    public static void printResult(NamesDto namesDto, RowsDto rowsDto) {
        printResultTitle();
        printNames(namesDto);
        printLines(rowsDto);
    }

    private static void printResultTitle() {
        System.out.println("실행 결과");
        System.out.println();
    }

    private static void printNames(NamesDto namesDto) {
        namesDto.getNames().forEach(ResultView::printName);
    }

    private static void printName(String name) {
        System.out.printf("%-6s", name);
    }

    private static void printLines(RowsDto rowsDto) {
        System.out.println();
        List<List<Boolean>> rows = rowsDto.getRows();
        rows.forEach(ResultView::printLine);
    }

    private static void printLine(List<Boolean> row) {
        System.out.print("|");
        for (int i = 0; i < row.size(); i++) {
            printLeg(row, i);
        }
        System.out.println();
    }

    private static void printLeg(List<Boolean> row, int index) {
        if (row.get(index)) {
            System.out.print("-----|");
            return;
        }
        System.out.print("     |");
    }

    public static void printErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }
}
