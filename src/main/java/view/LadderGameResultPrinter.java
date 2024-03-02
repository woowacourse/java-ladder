package view;

import domain.LadderGameResult;
import domain.name.Name;
import domain.name.Names;
import domain.result.LadderResult;
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
                .map(name -> {
                    LadderResult ladderResult = ladderGameResult.getLadderResultFromName(name);
                    return NAME_LADDER_RESULT_FORMAT.formatted(name.getName(), ladderResult.getLadderResult());
                }).collect(Collectors.joining("\n"));
    }
}
