package view;

import static domain.Name.MAX_NAME_LENGTH;

import domain.Bridges;
import domain.Ladder;
import domain.Name;
import domain.Names;
import domain.Row;
import java.util.stream.Collectors;

public class OutPutView {
    private static final String NAMES_INPUT = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String HEIGHT_INPUT = "최대 사다리 높이는 몇 개인가요?";
    private static final String PREFIX_RESULT = "\n실행 결과\n";

    public void printNamesInput() {
        System.out.println(NAMES_INPUT);
    }

    public void printHeightInput() {
        System.out.println(HEIGHT_INPUT);
    }

    public void printLadderResult(Names names, Ladder ladder) {
        String namesString = makeNamesString(names);
        String ladderString = makeLadderString(ladder);
        System.out.println(String.join("\n", PREFIX_RESULT, namesString, ladderString));
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
                .collect(Collectors.joining("|"));
        return "    |%s|".formatted(rawRowString);
    }

    private String makeBridge(Boolean aBoolean) {
        if (aBoolean) {
            return "-----";
        }
        return "     ";
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
}
