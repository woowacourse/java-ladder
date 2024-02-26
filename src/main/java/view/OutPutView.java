package view;

import static domain.Name.MAX_NAME_LENGTH;

import domain.Bridges;
import domain.Ladder;
import domain.LadderResult;
import domain.LadderResults;
import domain.Name;
import domain.Names;
import domain.Row;
import java.util.stream.Collectors;

public class OutPutView {
    private static final String NAMES_INPUT = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String LADDER_RESULT_INPUT = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String HEIGHT_INPUT = "최대 사다리 높이는 몇 개인가요?";
    private static final String PREFIX_RESULT = "\n실행 결과\n";

    private static final String VERTICAL_BRIDGE = "|";
    private static final String EXIST_BRIDGE = "----";
    private static final String NONE_BRIDGE = "    ";

    public void printNamesInput() {
        System.out.println(NAMES_INPUT);
    }

    public void printHeightInput() {
        System.out.println(HEIGHT_INPUT);
    }

    public void printLadderResultInput() {
        System.out.println(LADDER_RESULT_INPUT);
    }

    public void printLadderResult(Names names, Ladder ladder, LadderResults ladderResults) {
        String namesString = makeNamesString(names);
        String ladderString = makeLadderString(ladder);
        String ladderResultString = makeLadderResultsString(ladderResults);
        System.out.println(String.join("\n", PREFIX_RESULT, namesString, ladderString, ladderResultString));
    }


    private String makeLadderString(Ladder ladder) {
        return ladder.getRows().stream()
                .map(this::makeRowString)
                .collect(Collectors.joining("\n"));
    }

    private String makeRowString(Row row) {
        Bridges bridges = row.getBridges();
        String rawRowString = bridges.getBridges().stream()
                .map(this::makeBridge)
                .collect(Collectors.joining(VERTICAL_BRIDGE));
        return "    |%s|".formatted(rawRowString);
    }

    private String makeBridge(Boolean aBoolean) {
        if (aBoolean) {
            return EXIST_BRIDGE;
        }
        return NONE_BRIDGE;
    }

    private String makeNamesString(Names names) {
        return names.getNames().stream()
                .map(this::makeNameString)
                .collect(Collectors.joining(" "));
    }

    private String makeNameString(Name name) {
        String nameString = name.getName();
        if (nameString.length() < Name.MAX_NAME_LENGTH) {
            nameString = nameString + " ";
        }
        int nameStringLength = nameString.length();
        return " ".repeat(MAX_NAME_LENGTH - nameStringLength) + nameString;
    }

    private String makeLadderResultsString(LadderResults ladderResults) {
        return ladderResults.getLadderResults().stream()
                .map(this::makeLadderResultString)
                .collect(Collectors.joining(" "));
    }

    private String makeLadderResultString(LadderResult ladderResult) {
        String ladderResultString = ladderResult.getValue();
        if (ladderResultString.length() < LadderResult.MAX_LADDER_RESULT_LENGTH) {
            ladderResultString = ladderResultString + " ";
        }
        int nameStringLength = ladderResultString.length();
        return " ".repeat(MAX_NAME_LENGTH - nameStringLength) + ladderResultString;
    }

}
