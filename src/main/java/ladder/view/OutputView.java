package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.NameFormat;
import ladder.domain.People;
import ladder.domain.RowLine;

import java.util.List;
import java.util.StringJoiner;

public class OutputView {
    private static final String BLANK = " ";

    public static void printNames(People people) {
        StringJoiner nameJoiner = new StringJoiner(BLANK);
        List<String> names = people.getNames();

        for (String name : names) {
            String format = NameFormat.findFormat(name.length());
            nameJoiner.add(String.format(format, name));
        }
        System.out.println(nameJoiner);
    }

    public static void printLadder(Ladder ladder){
        for (RowLine rowLine : ladder.getRowLines()) {
            printRowLine(rowLine);
        }
    }

    private static void printRowLine(RowLine rowLine){
        StringBuilder stringBuilder = new StringBuilder("    |");

        //TODO depth 줄이기
        for (Boolean isConnected : rowLine.getConnection()) {
            if(isConnected){
                stringBuilder.append("-".repeat(5));
            }
            if(!isConnected){
                stringBuilder.append(BLANK.repeat(5));
            }
            stringBuilder.append("|");
        }
        System.out.println(stringBuilder);
    }

}
