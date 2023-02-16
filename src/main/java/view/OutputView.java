package view;

import domain.Line;
import domain.Person;
import java.util.List;

public class OutputView {
    private static final String BRIDGE = "-----";
    private static final String VERTICAL_LINE = "|";
    private static final String BLANK_LINE = "     ";
    private static final String BLANK = " ";

    public void printLadder(List<Line> lines){
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < lines.size(); i++) {
            Line line = lines.get(i);
            builder.append(VERTICAL_LINE);
            for (int j = 0; j < line.getPointsSize(); j++) {
                Boolean state = line.getPoints().get(j);
                if (state){
                    builder.append(BRIDGE);
                }
                if (!state) {
                    builder.append(BLANK_LINE);
                }
                builder.append(VERTICAL_LINE);
            }
            builder.append("\n");
        }
        System.out.println(builder);
    }

    public void printPersonNames(List<String> names){
        StringBuilder stringBuilder = new StringBuilder();

        for(String name : names){
            stringBuilder.append(name)
                    .append(getNameBlank(name))
                    .append(BLANK);
        }
        System.out.println(stringBuilder);
    }

    private String getNameBlank(String name) {
        return BLANK.repeat(Person.NAME_MAX_LENGTH - name.length());
    }
}
