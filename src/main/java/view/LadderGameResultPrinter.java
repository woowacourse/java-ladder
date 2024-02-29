package view;

import domain.LadderGameResult;
import domain.Name;
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
        System.out.println(
                String.join("\n", LADDER_RESULT_PREFIX,
                        ladderGameResult.getLadderResultFromName(name).getLadderResult() + "\n"));
    }

    public void printAll() {
        String allNameLadderResult = ladderGameResult.getLadderGameResult()
                .keySet()
                .stream()
                .map(name -> NAME_LADDER_RESULT_FORMAT
                        .formatted(name.getName(), ladderGameResult.getLadderResultFromName(name).getLadderResult()))
                .collect(Collectors.joining("\n"));
        System.out.println(String.join("\n", LADDER_RESULT_PREFIX, allNameLadderResult));
    }
}
