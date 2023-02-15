package ladder.view;

import java.util.List;
import ladder.dto.LinesDto;
import ladder.dto.NamesDto;

public class ResultView {

    public static void printResult(NamesDto namesDto, LinesDto linesDto) {
        System.out.println("실행 결과");
        System.out.println();
        printNames(namesDto);
        printLines(linesDto);
    }

    private static void printNames(NamesDto namesDto) {
        namesDto.getNames().forEach(ResultView::printName);
    }

    private static void printName(String name) {
        System.out.printf("%-6s", name);
    }

    private static void printLines(LinesDto linesDto) {
        List<List<Boolean>> lines = linesDto.getLines();
        System.out.println();
        for (int i = 0; i < linesDto.getHeight(); i++) {
            System.out.print("    |");
            for (int j = 0; j < lines.size(); j++) {

                if (lines.get(j).get(i)) {
                    System.out.print("-----");
                } else {
                    System.out.print("     ");
                }
                System.out.print("|");
            }
            System.out.println();
        }
    }

    private static void printLine(List<Boolean> connected) {

    }

    public static void printErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }
}
