package ladder.view;

import java.util.List;
import ladder.dto.LinesDto;
import ladder.dto.NamesDto;

public class ResultView {

    private ResultView() {
    }

    public static void printResult(NamesDto namesDto, LinesDto linesDto) {
        printResultTitle();
        printNames(namesDto);
        printLines(linesDto);
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

    private static void printLines(LinesDto linesDto) {
        List<List<Boolean>> lines = linesDto.getLines();
        for (int i = 0; i < linesDto.getHeight(); i++) {
            printRow(lines, i);
        }
    }

    private static void printRow(List<List<Boolean>> lines, int rowIndex) {
        System.out.println();
        System.out.print("    |");
        for (int j = 0; j < lines.size(); j++) {
            printLeg(lines, rowIndex, j);
        }
    }

    private static void printLeg(List<List<Boolean>> lines, int rowIndex, int columnIndex) {
        if (lines.get(columnIndex).get(rowIndex)) {
            System.out.print("-----|");
            return;
        }
        System.out.print("     |");
    }

    public static void printErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }
}
