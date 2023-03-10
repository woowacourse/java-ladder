package view;

import model.domain.Ladder;
import model.domain.Line;
import model.vo.Name;
import model.vo.Result;

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
    private static final String RESULTS_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String DESIROUS_RESULT_NAME_MESSAGE = "\n결과를 보고 싶은 사람은?";
    private static final String RESULT_HEADER = "\n실행 결과";
    private static final String LADDER_RESULT_MESSAGE = "\n사다리 결과\n";
    private static final String NAME_RESULT_DELIMITER = " : ";

    public void printPlayerNamesMessage() {
        System.out.println(PLAYER_NAME_MESSAGE);
    }

    public void printLadderHeightMessage() {
        System.out.println(LADDER_HEIGHT_MESSAGE);
    }

    public void printResultsMessage() {
        System.out.println(RESULTS_MESSAGE);
    }

    public void printResultHeaderMessage() {
        System.out.println(RESULT_HEADER);
    }

    public void printDesirousResultNameMessage() {
        System.out.println(DESIROUS_RESULT_NAME_MESSAGE);
    }

    public void printMakeLadderResultMessage() {
        System.out.println(LADDER_RESULT_MESSAGE);
    }

    public void printAllPlayerNames(List<Name> allPlayerNames) {
        List<String> names = unwrapNames(allPlayerNames);
        System.out.println(makeLeftFormattingFirstWord(names) +
                makeRightFormattingWordsFromSecond(names));
    }

    public void printLadder(Ladder ladder) {
        IntStream.range(0, ladder.getHeight())
                .forEach(index -> printLadderLine(ladder.getLine(index)));
    }

    public void printAllResults(List<Result> allResults) {
        List<String> results = unwrapResults(allResults);
        System.out.println(makeLeftFormattingFirstWord(results) + makeRightFormattingWordsFromSecond(results));
    }

    public void printResult(Result result) {
        System.out.println(result.getResult());
    }

    private List<String> unwrapResults(List<Result> results) {
        return results.stream().map(Result::getResult).collect(Collectors.toList());
    }

    private List<String> unwrapNames(List<Name> names) {
        return names.stream()
                .map(Name::getName)
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

    private String makeLeftFormattingFirstWord(List<String> words) {
        return String.format(LEFT_FORMATTING_TEMPLATE, words.get(0));
    }

    private String makeRightFormattingWordsFromSecond(List<String> words) {
        return words.subList(STARTING_INDEX_OF_RIGHT_FORMATTING, words.size()).stream()
                .map(name -> String.format(RIGHT_FORMATTING_TEMPLATE, name))
                .collect(Collectors.joining(""));
    }

    public void printNameAndResult(Name name, Result result) {
        System.out.println(name.getName() + NAME_RESULT_DELIMITER + result.getResult());
    }
}
