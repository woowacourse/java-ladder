package view;

import domain.Ladder;
import domain.Name;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String BAR = "|";

    private static final StringBuilder stringBuilder = new StringBuilder();

    /**
     * pobi  honux crong   jk
     * |-----|     |-----|
     * |     |-----|     |
     * |-----|     |     |
     * |     |-----|     |
     * |-----|     |-----|
     */
    public static void printResult(final Ladder ladder, final List<Name> names) {
        printName(names);
        int length = names.get(0).getValue().length();
        String blank = " ".repeat(length);
        for (int i = 0; i < ladder.getHeight(); i++) {
            stringBuilder.append(blank);
            stringBuilder.append(BAR);
            for (int j = 0; j < ladder.getWidth(); j++) {
                stringBuilder.append(ladder.getLines().get(i).getScaffolds().get(j).getStatus() + BAR);
                String s = stringBuilder.toString();
                System.out.print(s);
                stringBuilder.delete(0, s.length());
            }
            System.out.println();
        }
    }

    public static void printName(final List<Name> names) {
        List<String> makeNames = new ArrayList<>();
        List<String> nameValues = names.stream().map(Name::getValue).collect(Collectors.toList());
        String remove = nameValues.remove(0);
        int addBlankSize = 5 - remove.length();
        String blank = " ";
        String result = "";
        for (int i = 0; i < addBlankSize; i++) {
            result += blank;
        }
        String firstName = remove + blank;
        makeNames.add(firstName);

        for (String name : nameValues) {
            addBlankSize = 5 - name.length();
            result = "";
            for (int i = 0; i < addBlankSize; i++) {
                result += blank;
            }
            makeNames.add(result + name);
        }
        for (int i = 0; i < makeNames.size(); i++) {
            System.out.print(makeNames.get(i) + " ");
        }
        System.out.println();
    }
}
