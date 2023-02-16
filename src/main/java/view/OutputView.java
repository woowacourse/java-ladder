package view;

import domain.Ladder;
import domain.Name;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String BAR = "|";
    private static final String BLANK = " ";

    private static final StringBuilder stringBuilder = new StringBuilder();

    public static void printResult(final Ladder ladder, final List<Name> playerNames) {
        String initBlank = BLANK.repeat(playerNames.get(0).getValue().length());
        printNames(playerNames);
        printLadder(ladder, initBlank);
    }

    public static void printNames(final List<Name> playerNames) {
        List<String> names = new ArrayList<>();
        List<String> nameValues = playerNames.stream().map(Name::getValue).collect(Collectors.toList());
        String remove = nameValues.remove(0);
        String firstName = remove + BLANK;
        names.add(firstName);
        addBlanks(names, nameValues);
        for (int i = 0; i < names.size(); i++) {
            System.out.print(names.get(i) + BLANK);
        }
        System.out.println();
    }
    private static void printLadder(Ladder ladder, String initBlank) {
        for (int i = 0; i < ladder.getHeight(); i++) {
            stringBuilder.append(initBlank);
            stringBuilder.append(BAR);
            addLinesToStringBuilder(ladder, i);
            System.out.println();
        }
    }

    private static void addBlanks(List<String> makeNames, List<String> nameValues) {
        for (String name : nameValues) {
            int addBlankSize = 5 - name.length();
            String result = BLANK.repeat(addBlankSize);
            makeNames.add(result + name);
        }
    }

    private static void addLinesToStringBuilder(Ladder ladder, int i) {
        for (int j = 0; j < ladder.getWidth(); j++) {
            stringBuilder.append(ladder.getLines().get(i).getScaffolds().get(j).getStatus() + BAR);
            String lineResult = stringBuilder.toString();
            System.out.print(lineResult);
            stringBuilder.delete(0, lineResult.length());
        }
    }
}