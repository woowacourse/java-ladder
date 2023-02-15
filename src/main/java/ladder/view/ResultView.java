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
        System.out.println();
        List<List<Boolean>> lines = linesDto.getLines();
        lines.forEach(ResultView::printLine);
    }

    private static void printLine(List<Boolean> line) {
        System.out.print("|");
        for (int i = 0; i < line.size(); i++) {
            printLeg(line, i);
        }
        System.out.println();
    }

    private static void printLeg(List<Boolean> line, int index) {
        if (line.get(index)) {
            System.out.print("-----|");
            return;
        }
        System.out.print("     |");
    }

    public static void printErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }
}
