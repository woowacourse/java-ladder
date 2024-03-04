package view;

import dto.LineDto;
import dto.LadderDto;
import dto.ResultDto;
import dto.ResultsDto;
import view.formatter.ItemsFormatter;
import view.formatter.LineFormatter;
import view.formatter.NamesFormatter;
import java.util.List;
import view.formatter.ResultFormatter;

public class OutputView {

    public void printLadderInfo(final LadderDto ladderDto) {
        System.out.println();
        System.out.println("사다리 결과");
        System.out.println();
        final List<String> peopleNames = ladderDto.peopleNames();
        final List<String> itemNames = ladderDto.itemNames();
        printPeopleNames(peopleNames);
        printLines(ladderDto.lines());
        printItemNames(itemNames);
    }

    private void printPeopleNames(final List<String> peopleNames) {
        System.out.println(NamesFormatter.format(peopleNames));
    }

    private void printLines(final List<LineDto> lines) {
        lines.forEach(this::printLine);
    }

    private void printItemNames(final List<String> itemNames) {
        System.out.println(ItemsFormatter.format(itemNames));
    }

    private void printLine(final LineDto line) {
        final List<Boolean> paths = line.lineInfo();
        System.out.println(LineFormatter.format(paths));
    }

    public void printResultByPerson(String item) {
        System.out.println();
        System.out.println("실행 결과");
        System.out.println(item);
    }

    public void printAllResult(final ResultsDto resultsDto) {
        System.out.println();
        System.out.println("실행 결과");
        List<ResultDto> resultDtos = resultsDto.personAndItemName();
        System.out.println(ResultFormatter.format(resultDtos));
    }
}
