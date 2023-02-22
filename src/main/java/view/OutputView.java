package view;

import model.Ladder;
import model.Line;
import model.Name;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputView {
    private static final int STARTING_INDEX_OF_RIGHT_FORMATTING = 1;
    private static final String LEFT_FORMATTING_TEMPLATE = "%-5s";
    private static final String RIGHT_FORMATTING_TEMPLATE = "%6s";
    private static final String FIRST_STEP = String.format("%5s", "    |");
    private static final String EMPTY_STEP = String.format("%6s", "     |");
    private static final String EXIST_STEP = String.format("%6s", "-----|");
    private static final String PLAYER_NAME_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String LADDER_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";

    public void printPlayerNamesMessage() {
        System.out.println(PLAYER_NAME_MESSAGE);
    }

    public void printLadderHeightMessage() {
        System.out.println(LADDER_HEIGHT_MESSAGE);
    }

    public void printAllPlayerNames(List<Name> allPlayerNames) {
        List<String> names = unwrapNames(allPlayerNames);
        System.out.println(makeLeftFormattingFirstName(names) +
                makeRightFormattingNamesFromSecond(names));
    }

    public void printLadder(Ladder ladder) {
        IntStream.range(0, ladder.getHeight())
                .forEach(index -> printLadderLine(ladder.getLine(index)));
    }

    private List<String> unwrapNames(List<Name> names) {
        return names.stream()
                .map(Name::getValue)
                .collect(Collectors.toList());
    }

    private void printLadderLine(Line line) {
        StringBuilder stringBuilder = new StringBuilder(FIRST_STEP);
        line.getPoints().forEach(point -> stringBuilder.append(makeNextStep(point)));
        System.out.println(stringBuilder);
    }

    private String makeNextStep(Boolean point) {
        if (point) {
            return EXIST_STEP;
        }

        return EMPTY_STEP;
    }

    private String makeLeftFormattingFirstName(List<String> allPlayerNames) {
        return String.format(LEFT_FORMATTING_TEMPLATE, allPlayerNames.get(0));
    }

    private String makeRightFormattingNamesFromSecond(List<String> allPlayerNames) {
        return allPlayerNames.subList(STARTING_INDEX_OF_RIGHT_FORMATTING, allPlayerNames.size()).stream()
                .map(name -> String.format(RIGHT_FORMATTING_TEMPLATE, name))
                .collect(Collectors.joining(""));
    }
}
