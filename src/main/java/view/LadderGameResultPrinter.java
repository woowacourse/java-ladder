package view;

import domain.LadderGameResult;
import domain.LadderResult;
import domain.Name;
import domain.Names;
import java.util.stream.Collectors;

public class LadderGameResultPrinter {
    private static final String LADDER_RESULT_PREFIX = "\n실행 결과";
    private static final String NAME_LADDER_RESULT_FORMAT = "%s : %s";
    private final LadderGameResult ladderGameResult;

    public LadderGameResultPrinter(LadderGameResult ladderGameResult) {
        this.ladderGameResult = ladderGameResult;
    }

    public void printFromName(String searchName) {
        Name name = new Name(searchName);
        LadderResult ladderResult = ladderGameResult.getLadderResultFromName(name);
        String ladderResultString = ladderResult.getLadderResult();
        System.out.println(String.join("\n", LADDER_RESULT_PREFIX, ladderResultString + "\n"));
    }

    public void printAll() {
        Names names = ladderGameResult.getNames();
        String allNameLadderResult = makeAllNameLadderResultString(names);
        System.out.println(String.join("\n", LADDER_RESULT_PREFIX, allNameLadderResult));
    }

    private String makeAllNameLadderResultString(Names names) {
        return names.getNames().stream()
                .map(name -> NAME_LADDER_RESULT_FORMAT.formatted(
                        name.getName(), ladderGameResult.getLadderResultFromName(name)))
                .collect(Collectors.joining("\n"));
    }
}
