package laddergame.domain.exception.ladder.result;

public class LadderResultCountException extends IllegalArgumentException {

    private static final String LADDER_RESULT_COUNT = "[ERROR] 사다리 결과의 개수는 %d개여야 합니다.";

    public LadderResultCountException(final int count) {
        super(String.format(LADDER_RESULT_COUNT, count));
    }
}
