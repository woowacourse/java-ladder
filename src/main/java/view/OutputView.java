package view;

import domain.Ladder;
import domain.Line;
import domain.Name;
import domain.Scaffold;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    private static final String BAR = "|";
    private static final String EXIST_SCAFFOLD = "-----";
    private static final String NONE_SCAFFOLD = "     ";
    private static final String BLANK = " ";
    private static final String EMPTY = "";
    private static final String FIRST_NAME_FORMAT = "%-6s";
    private static final String DEFAULT_NAME_FORMAT = "%5s";
    private static final Map<Scaffold, String> SCAFFOLD_STRING_MAP;

    static {
        SCAFFOLD_STRING_MAP = new HashMap<>();
        SCAFFOLD_STRING_MAP.put(Scaffold.EXIST, EXIST_SCAFFOLD);
        SCAFFOLD_STRING_MAP.put(Scaffold.NONE, NONE_SCAFFOLD);
    }

    public static void printResult(final Ladder ladder, final List<Name> names) {
        printName(names);
        printLadder(ladder, names);
    }

    public static void printName(final List<Name> names) {
        List<String> nameValues = names.stream().map(Name::getValue).collect(Collectors.toList());
        String firstName = String.format(FIRST_NAME_FORMAT, nameValues.remove(0));
        System.out.println(makeNameFormat(nameValues, firstName));
    }

    private static String makeNameFormat(final List<String> nameValues, final String firstName) {
        return nameValues.stream().map(it -> String.format(DEFAULT_NAME_FORMAT, it))
                .collect(Collectors.joining(BLANK, firstName, EMPTY));
    }

    private static void printLadder(final Ladder ladder, final List<Name> names) {
        int length = names.get(0).getValue().length();
        String prefixBlank = BLANK.repeat(length);
        String ladderFormat = getLadderFormat(ladder, prefixBlank);
        System.out.println(ladderFormat);
    }

    private static String getLadderFormat(final Ladder ladder, final String prefixBlank) {
        return ladder.getLines().stream()
                .map(line -> getLineFormat(prefixBlank, line)
                ).collect(Collectors.joining("\n"));
    }

    private static String getLineFormat(final String prefixBlank, final Line line) {
        return line.getScaffolds()
                .stream()
                .map(SCAFFOLD_STRING_MAP::get)
                .collect(Collectors.joining(BAR, prefixBlank + BAR, BAR));
    }
}
