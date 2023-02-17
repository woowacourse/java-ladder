package view;

import domain.Ladder;
import domain.Name;
import domain.Names;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final int MAX_NAME_SIZE = 5;
    private static final int FIRST_NAME_INDEX = 0;
    private static final String BAR = "|";
    private static final String BLANK = " ";

    private static final StringBuilder stringBuilder = new StringBuilder();

    private OutputView() {
    }

    public static void printResult(final Ladder ladder, final Names playerNames) {
        String prefixBlank = BLANK.repeat(playerNames.getNames().get(FIRST_NAME_INDEX).getValue().length());
        printNames(playerNames);
        printLadder(ladder, prefixBlank);
    }

    public static void printNames(final Names playerNames) {
        List<String> names = new ArrayList<>();
        List<String> nameValues = playerNames.getNames().stream().map(Name::getValue).collect(Collectors.toList());
        String firstName = nameValues.remove(FIRST_NAME_INDEX);
        names.add(firstName + BLANK);
        addBlanks(names, nameValues);
        for (int i = 0; i < names.size(); i++) {
            System.out.print(names.get(i) + BLANK);
        }
        System.out.println();
    }

    private static void addBlanks(List<String> makeNames, List<String> nameValues) {
        for (String name : nameValues) {
            int addBlankSize = MAX_NAME_SIZE - name.length();
            String result = BLANK.repeat(addBlankSize);
            makeNames.add(result + name);
        }
    }

    private static void printLadder(Ladder ladder, String prefixBlank) {
        for (int i = 0; i < ladder.getHeight(); i++) {
            stringBuilder.append(prefixBlank);
            stringBuilder.append(BAR);
            printLinesByStringBuilder(ladder, i);
            System.out.println();
        }
    }

    private static void printLinesByStringBuilder(Ladder ladder, int i) {
        for (int j = 0; j < ladder.getWidth(); j++) {
            stringBuilder.append(ladder.getLines().get(i).getScaffolds().get(j).getStatus() + BAR);
            String lineResult = stringBuilder.toString();
            System.out.print(lineResult);
            stringBuilder.delete(0, lineResult.length());
        }
    }
}