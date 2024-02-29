package view;

import dto.LineInfo;
import dto.LadderInfo;
import java.util.Map;
import view.formatter.ItemsFormatter;
import view.formatter.LineFormatter;
import view.formatter.NamesFormatter;
import java.util.List;
import view.formatter.ResultFormatter;

public class OutputView {

    public void printLadderInfo(final LadderInfo ladderInfo) {
        System.out.println();
        System.out.println("사다리 결과");
        System.out.println();
        final List<String> peopleNames = ladderInfo.peopleNames();
        final List<String> itemNames = ladderInfo.itemNames();
        printPeopleNames(peopleNames);
        printLines(ladderInfo.lines());
        printItemNames(itemNames);
    }

    private void printPeopleNames(final List<String> peopleNames) {
        System.out.println(NamesFormatter.format(peopleNames));
    }

    private void printLines(final List<LineInfo> lines) {
        lines.forEach(this::printLine);
    }

    private void printItemNames(final List<String> itemNames) {
        System.out.println(ItemsFormatter.format(itemNames));
    }

    private void printLine(final LineInfo line) {
        final List<Boolean> paths = line.lineInfo();
        System.out.println(LineFormatter.format(paths));
    }

    public void printResultByPerson(String item) {
        System.out.println();
        System.out.println("실행 결과");
        System.out.println(item);
    }

    public void printAllResult(final Map<String, String> personAndItemName) {
        System.out.println();
        System.out.println("실행 결과");
        System.out.println(ResultFormatter.format(personAndItemName));
    }
}
