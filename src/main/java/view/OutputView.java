package view;

import dto.LineDto;
import dto.ResultsDto;
import view.formatter.ItemsFormatter;
import view.formatter.LineDtoFormatter;
import view.formatter.NamesFormatter;
import java.util.List;
import view.formatter.ResultsDtoFormatter;

public class OutputView {
    public void printLadderResultDescription() {
        System.out.println();
        System.out.println("사다리 결과");
        System.out.println();
    }

    public void printPeopleNames(final List<String> peopleNames) {
        System.out.println(NamesFormatter.format(peopleNames));
    }

    public void printLineDtos(final List<LineDto> lineDtos) {
        lineDtos.forEach(lineInfo ->
                System.out.println(LineDtoFormatter.format(lineInfo)));
    }

    public void printItemNames(final List<String> itemNames) {
        System.out.println(ItemsFormatter.format(itemNames));
    }

    public void printResultByPerson(String item) {
        System.out.println();
        System.out.println("실행 결과");
        System.out.println(item);
    }

    public void printAllResult(final ResultsDto resultsDto) {
        System.out.println();
        System.out.println("실행 결과");
        System.out.println(ResultsDtoFormatter.format(resultsDto));
    }
}
