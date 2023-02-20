package ladder.view;

import java.util.List;
import ladder.domain.Step;
import ladder.dto.RowsDto;
import ladder.dto.NamesDto;

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
    List<List<Step>> lines = rowsDto.getLines();
    lines.forEach(ResultView::printLine);
  }

  private static void printLine(List<Step> line) {
    System.out.print("|");
    for (int i = 0; i < line.size(); i++) {
      printLeg(line, i);
    }
    System.out.println();
  }

  private static void printLeg(List<Step> line, int index) {
    if (line.get(index) == Step.CONNECTED) {
      System.out.print("-----|");
      return;
    }
    System.out.print("     |");
  }

  public static void printErrorMessage(Exception e) {
    System.out.println(e.getMessage());
  }
}
