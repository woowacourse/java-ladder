package view;

import dto.RowPatternDto;
import java.util.List;
import java.util.StringJoiner;

public class OutputView {

    private static final int LADDER_WIDTH_UNIT = 5;
    private static final String VERTICAL_LADDER_CHARACTER = "|";
    private static final String HORIZONTAL_LADDER_CHARACTER = "-";
    private static final String EMPTY_LADDER_CHARACTER = " ";
    private static final String LADDER_PREFIX_SPACES = "    ";
    private static final String NAME_PRINT_FORMAT = "%" + LADDER_WIDTH_UNIT + "s";

    public void printReadNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    }

    public void printReadLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
    }

    public void printReadResults() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
    }

    public void printLadderCreationMessage() {
        System.out.println("사다리 결과" + System.lineSeparator());
    }

    public void printReadNameForResult() {
        System.out.println(System.lineSeparator() + "결과를 보고 싶은 사람은?");
    }

    public void printResultMessage() {
        System.out.println(System.lineSeparator() + "실행 결과");
    }

    public void printTokens(List<String> tokens) {
        StringJoiner joiner = new StringJoiner(" ");
        tokens.stream()
                .map(this::formatToken)
                .forEach(joiner::add);

        System.out.println(joiner.toString());
    }

    public void printLadder(List<RowPatternDto> patterns) {
        patterns.stream()
                .map(RowPatternDto::rowPattern)
                .forEach(this::printLadderRowPattern);
    }

    private void printLadderRowPattern(List<Boolean> indices) {
        StringBuilder builder = new StringBuilder();

        builder.append(LADDER_PREFIX_SPACES);
        builder.append(VERTICAL_LADDER_CHARACTER);
        indices.forEach(isPlaced ->
                builder.append(getHorizontalLadderCharacterIfPlaced(isPlaced))
                        .append(VERTICAL_LADDER_CHARACTER)
        );

        System.out.println(builder.toString());
    }

    public void printPlayerResult(String name, String result) {
        System.out.println(name + " : " + result);
    }

    public void printToken(String token) {
        System.out.println(token);
    }

    private String getHorizontalLadderCharacterIfPlaced(boolean isPlaced) {
        if (isPlaced) {
            return HORIZONTAL_LADDER_CHARACTER.repeat(LADDER_WIDTH_UNIT);
        }
        return EMPTY_LADDER_CHARACTER.repeat(LADDER_WIDTH_UNIT);
    }

    private String formatToken(String token) {
        return String.format(NAME_PRINT_FORMAT, token);
    }
}
