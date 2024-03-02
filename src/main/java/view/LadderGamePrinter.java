package view;

import domain.Bridge;
import domain.Ladder;
import domain.LadderGameResult;
import domain.LadderResult;
import domain.LadderResults;
import domain.Name;
import domain.Names;
import domain.Row;
import java.util.List;
import java.util.stream.Collectors;

public class LadderGamePrinter {
    private static final String LADDER_PREFIX = "\n사다리 결과\n";
    private static final String VERTICAL_BRIDGE = "|";
    private static final String PADDING_STYLE = "%5s";
    private static final String EXIST_BRIDGE = "-----";
    private static final String NONE_BRIDGE = "     ";
    private final LadderGameResult ladderGameResult;

    LadderGamePrinter(LadderGameResult ladderGameResult) {
        this.ladderGameResult = ladderGameResult;
    }

    public void print() {
        Names names = ladderGameResult.getNames();
        Ladder ladder = ladderGameResult.getLadder();
        LadderResults ladderResults = ladderGameResult.getLadderResults();

        String namesString = makeNamesString(names);
        String ladderString = makeLadderString(ladder);
        String ladderResultString = makeLadderResultsString(ladderResults);

        System.out.println(String.join("\n", LADDER_PREFIX, namesString, ladderString, ladderResultString, "\n"));
    }

    private String makeNamesString(Names names) {
        return names.getNames().stream()
                .map(Name::getName)
                .map(PADDING_STYLE::formatted)
                .collect(Collectors.joining(" "));
    }

    private String makeLadderString(Ladder ladder) {
        return ladder.getRows().stream()
                .map(Row::getBridges)
                .map(this::makeBridgesString)
                .collect(Collectors.joining("\n"));
    }

    private String makeBridgesString(List<Bridge> bridges) {
        String rawBridgesString = bridges.stream()
                .map(this::makeBridge)
                .collect(Collectors.joining(VERTICAL_BRIDGE));
        return "    |%s|".formatted(rawBridgesString);
    }

    private String makeBridge(Bridge bridge) {
        if (bridge == Bridge.EXIST) {
            return EXIST_BRIDGE;
        }
        return NONE_BRIDGE;
    }

    private String makeLadderResultsString(LadderResults ladderResults) {
        return ladderResults.getLadderResults().stream()
                .map(LadderResult::getLadderResult)
                .map(PADDING_STYLE::formatted)
                .collect(Collectors.joining(" "));
    }
}
