package view;

import dto.LineInfo;
import dto.LadderInfo;
import formatter.LineFormatter;
import formatter.NamesFormatter;
import formatter.PresentNamesFormatter;
import java.util.List;

public class OutputView {

    public void printError(final String message) {
        System.out.println("[error] " + message);
    }

    public void printLadderInfo(final LadderInfo ladderInfo) {
        printInitialMessages();
        printNames(ladderInfo.names());
        printLines(ladderInfo.lines());
        printPresentNames(ladderInfo.presentNames());
    }

    private void printInitialMessages() {
        System.out.println();
        System.out.println("실행결과");
        System.out.println();
    }

    public void printNames(final List<String> names) {
        System.out.println(NamesFormatter.format(names));
    }

    public void printLines(final List<LineInfo> lines) {
        lines.forEach(this::printLine);
    }

    private void printLine(final LineInfo line) {
        final List<Boolean> paths = line.lineInfo();
        System.out.println(LineFormatter.format(paths));
    }

    public void printPresentNames(final List<String> presentNames) {
        System.out.println(PresentNamesFormatter.format(presentNames));
    }

    public void printMatched(String name) {
        System.out.println(name);
    }

    public void printMatched(String personName, String presentName) {
        System.out.println(personName + " : " + presentName);
    }
}
