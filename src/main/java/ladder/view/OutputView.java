package ladder.view;

import ladder.domain.LadderGame;
import ladder.domain.Line;
import ladder.domain.Person;
import ladder.domain.Result;

import java.util.List;

public class OutputView {
    private static final String LADDER_RESULT_MESSAGE = "사다리 결과";
    private static final String EXECUTION_RESULT_MESSAGE = "실행 결과";
    private static final int OUTPUT_MAX_LENGTH = 6;

    public static void printLadder(LadderGame ladderGame, Person person, Result result) {
        System.out.println(LADDER_RESULT_MESSAGE);
        System.out.println(makeOutput(person.getNames()));
        System.out.println(makeLadder(ladderGame.getLadder()));
        System.out.println(makeOutput(result.getResults()));
    }

    static String makeOutput(List<String> outputs) {
        StringBuilder sb = new StringBuilder();
        for (String output : outputs) {
            sb.append(makeBlank(output));
            sb.append(output);
        }
        return sb.toString();
    }

    private static String makeBlank(String output) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < OUTPUT_MAX_LENGTH - output.length(); i++) {
            sb.append(" ");
        }
        return sb.toString();
    }

    private static String makeLadder(List<Line> ladder) {
        StringBuilder sb = new StringBuilder();
        for (Line line : ladder) {
            sb.append(makeLine(line.getPoints()));
        }
        return sb.toString();
    }

    static String makeLine(List<Boolean> points) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < points.size() - 1; i++) {
            sb.append(makeRow(points, i));
        }
        return sb.toString() + "\n";
    }

    private static String makeRow(List<Boolean> points, int index) {
        if (points.get(index)) {
            return "-----|";
        }
        return "     |";
    }

    public static void printLadderResult(String ladderResult) {
        System.out.println("\n" + EXECUTION_RESULT_MESSAGE);
        System.out.println(ladderResult + "\n");
    }


}
