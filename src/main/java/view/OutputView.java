package view;

import domain.HorizontalLineStatus;
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

    public void printResultMessage() {
        System.out.println("실행결과" + System.lineSeparator());
    }

    public void printNames(List<String> names) {
        StringJoiner joiner = new StringJoiner(" ");
        names.stream()
                .map(this::formatName)
                .forEach(joiner::add);

        System.out.println(joiner.toString());
    }

    public void printLadder(List<HorizontalLineStatus> statuses) {
        statuses.stream()
                .map(HorizontalLineStatus::placedStatuses)
                .forEach(this::printHorizontalLine);
    }

    public void printErrorMessage(String message) {
        System.out.println(message + System.lineSeparator());
    }

    private void printHorizontalLine(List<Boolean> indices) {
        StringBuilder builder = new StringBuilder();

        builder.append(LADDER_PREFIX_SPACES);
        builder.append(VERTICAL_LADDER_CHARACTER);
        indices.forEach(isPlaced ->
                builder.append(getHorizontalLadderCharacterIfPlaced(isPlaced))
                        .append(VERTICAL_LADDER_CHARACTER)
        );

        System.out.println(builder.toString());
    }

    private String getHorizontalLadderCharacterIfPlaced(boolean isPlaced) {
        if (isPlaced) {
            return HORIZONTAL_LADDER_CHARACTER.repeat(LADDER_WIDTH_UNIT);
        }
        return EMPTY_LADDER_CHARACTER.repeat(LADDER_WIDTH_UNIT);
    }

    private String formatName(String name) {
        return String.format(NAME_PRINT_FORMAT, name);
    }
}
