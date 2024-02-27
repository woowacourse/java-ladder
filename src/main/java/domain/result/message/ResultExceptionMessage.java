package domain.result.message;

import domain.result.LadderResult;

public class ResultExceptionMessage {

    public static final String LADDER_RESULT_LENGTH = String.format("실행 결과는 %d ~ %d글자 사이로 입력해야 합니다",
            LadderResult.MIN_RESULT_LENGTH, LadderResult.MAX_RESULT_LENGTH);
    public static final String LADDER_RESULT_BLANK = "실행 결과에 공백을 사용할 수 없습니다";
    public static final String TOTAL_RESULTS_SIZE = "참가자 수와 동일하게 실행 결과를 입력해야 합니다.";
}
