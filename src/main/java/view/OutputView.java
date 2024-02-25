package view;

import dto.LineInfo;
import dto.Result;
import view.formatter.LineFormatter;
import view.formatter.NamesFormatter;
import java.util.List;

public class OutputView {

    public void printResult(final Result result) {
        System.out.println();
        System.out.println("실행결과");
        System.out.println();
        final List<String> names = result.names();
        printNames(names);
        printLines(result.lines());
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
}
