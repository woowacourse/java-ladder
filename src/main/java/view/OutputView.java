package view;

import domain.Ladder;
import domain.Line;
import domain.Scaffold;
import domain.value.Name;
import domain.value.Names;
import domain.value.WinningEntries;
import domain.value.WinningEntry;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static java.lang.String.format;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class OutputView {

    private static final String BAR = "|";
    private static final String EXIST_SCAFFOLD = "-----";
    private static final String NONE_SCAFFOLD = "     ";
    private static final String BLANK = " ";
    private static final String EMPTY = "";
    private static final String LINE_BLANK = "\n";
    private static final String FIRST_NAME_FORMAT = "%s  ";
    private static final String DEFAULT_NAME_FORMAT = "%5s";
    private static final String DEFAULT_WINNING_ENTRY_FORMAT = "%5s";
    private static final Map<Scaffold, String> SCAFFOLD_STRING_MAP;

    static {
        SCAFFOLD_STRING_MAP = new EnumMap<>(Scaffold.class);
        SCAFFOLD_STRING_MAP.put(Scaffold.EXIST, EXIST_SCAFFOLD);
        SCAFFOLD_STRING_MAP.put(Scaffold.NONE, NONE_SCAFFOLD);
    }

    public static void printResult(final Ladder ladder, final Names names, final WinningEntries winningEntries) {
        printNames(names);
        printLadder(ladder, names.firstNameLength());
        printWinningEntries(winningEntries);
    }

    private static void printNames(final Names names) {
        List<String> nameValues = names.getNames()
                .stream()
                .map(Name::getValue)
                .collect(toList());
        System.out.println(makeNameFormat(nameValues));
    }

    private static String makeNameFormat(final List<String> nameValues) {
        String firstName = format(FIRST_NAME_FORMAT, nameValues.remove(0));
        return nameValues.stream()
                .map(it -> format(DEFAULT_NAME_FORMAT, it))
                .collect(joining(BLANK, firstName, EMPTY));
    }

    private static void printLadder(final Ladder ladder, final int prefixBlackLength) {
        String prefixBlank = BLANK.repeat(prefixBlackLength);
        String ladderFormat = makeLadderFormat(ladder, prefixBlank);
        System.out.println(ladderFormat);
    }

    private static String makeLadderFormat(final Ladder ladder, final String prefixBlank) {
        return ladder.getLines()
                .stream()
                .map(line -> makeLineFormat(prefixBlank, line))
                .collect(joining(LINE_BLANK));
    }

    private static String makeLineFormat(final String prefixBlank, final Line line) {
        return line.getScaffolds()
                .stream()
                .map(SCAFFOLD_STRING_MAP::get)
                .collect(joining(BAR, prefixBlank + BAR, BAR));
    }

    private static void printWinningEntries(final WinningEntries winningEntries) {
        String winningEntriesMessage = winningEntries.winningEntries().stream()
                .map(WinningEntry::value)
                .map(it -> format(DEFAULT_WINNING_ENTRY_FORMAT, it))
                .collect(joining(BLANK));
        System.out.println(winningEntriesMessage);
    }
}
