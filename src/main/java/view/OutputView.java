package view;

import dto.LineDto;
import dto.Result;
import formatter.LineFormatter;
import formatter.NamesFormatter;
import java.util.List;

public class OutputView {

    public void printResult(Result result) {
        System.out.println();
        System.out.println("실행결과");
        System.out.println();
        List<String> names = result.names();
        printNames(names);
        printLines(result.lines());
    }

    public void printNames(List<String> names) {
        System.out.println(NamesFormatter.format(names));
    }

    public void printLines(List<LineDto> lines) {
        lines.forEach(this::printLine);
    }

    private void printLine(LineDto line) {
        List<Boolean> paths = line.paths();
        System.out.println(LineFormatter.format(paths));
    }
}
