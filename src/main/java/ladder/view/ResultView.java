package ladder.view;

import java.util.List;
import ladder.domain.Step;
import ladder.dto.RowsDto;
import ladder.dto.NamesDto;

public class ResultView {

    private ResultView() {
    }

    public static void printResult(NamesDto playerNamesDto, RowsDto rowsDto,NamesDto rewardNamesDto) {
        printResultTitle();
        printPlayerNames(playerNamesDto);
        printRows(rowsDto);
        printPlayerNames(rewardNamesDto);
    }

    private static void printResultTitle() {
        System.out.println("실행 결과");
        System.out.println();
    }

    private static void printPlayerNames(NamesDto namesDto) {
        namesDto.getNames().forEach(ResultView::printName);
    }

    private static void printName(String name) {
        System.out.printf("%6s", name);
    }

    private static void printRows(RowsDto rowsDto) {
        System.out.println();
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
    public static void printErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }
}
