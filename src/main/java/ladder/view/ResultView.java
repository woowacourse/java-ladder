package ladder.view;

import ladder.domain.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final int WIDTH = 5;
    private static final String LEG = "|";
    private static final String BLANK = " ";
    private static final String NAME_FORMAT = "%-5s";
    private static final String BET_FORMAT = "%-5s";
    private static final String RESULT_FORMAT = "%s : %s";


    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    public void printForm(Names names, Ladder ladder, Result result) {
        int lengthOfFirstName = names.lengthOfFirstName();

        System.out.println("실행결과\n");
        printNames(names);
        printLadder(ladder, lengthOfFirstName);
        printBets(result, lengthOfFirstName);
    }

    private void printNames(Names names) {
        String resultMessage = names.getNames()
                .stream()
                .map(name -> String.format(NAME_FORMAT, name) + BLANK)
                .collect(Collectors.joining());
        System.out.println(resultMessage.trim());
    }

    private void printLadder(Ladder ladder, int lengthOfFirstName) {
        for (Line line : ladder.getLadder()) {
            String resultMessage = BLANK.repeat(lengthOfFirstName - 1);
            resultMessage += getShapeOf(line);
            resultMessage += LEG;
            System.out.println(resultMessage);
        }
    }

    private String getShapeOf(Line line) {
        return line.getLine()
                .stream()
                .map(LadderFormat::getComponent)
                .map(component -> LEG + component.repeat(WIDTH))
                .collect(Collectors.joining());
    }

    private void printBets(Result result, int lengthOfFirstName) {
        String resultMessage = BLANK.repeat(lengthOfFirstName - 1);
        resultMessage += result.getResult().values()
                .stream()
                .map(bet -> String.format(BET_FORMAT, bet.getBet()) + BLANK)
                .collect(Collectors.joining());
        System.out.println(resultMessage);
    }

    public void printGameResult(Result result, Name name) {
        System.out.println("실행결과");
        System.out.println(result.getBetByName(name).getBet());
    }

    public void printGameAllResult(Result result) {
        System.out.println("실행결과");
        List<Name> names = List.copyOf(result.getResult().keySet());
        List<Bet> bets = List.copyOf(result.getResult().values());

        String resultMessage = "";
        for (int i = 0; i < names.size(); i++) {
            resultMessage += String.format(RESULT_FORMAT, names.get(i), bets.get(i).getBet());
            resultMessage += "\n";
        }

        System.out.print(resultMessage);
    }

    private enum LadderFormat {
        LINE(Boolean.TRUE, "-"),
        BLANK(Boolean.FALSE, " ");

        private final Boolean condition;
        private final String component;

        LadderFormat(Boolean condition, String component) {
            this.condition = condition;
            this.component = component;
        }

        public static String getComponent(Boolean condition) {
            return Arrays.stream(values())
                    .filter(format -> format.condition == condition)
                    .findAny()
                    .get()
                    .component;
        }
    }
}