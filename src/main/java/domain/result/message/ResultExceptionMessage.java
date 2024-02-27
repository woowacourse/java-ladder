package domain.result.message;

import domain.result.LadderResult;
import view.InputView;

public class ResultExceptionMessage {

    public static final String LADDER_RESULT_LENGTH = String.format("실행 결과는 %d ~ %d글자 사이로 입력해야 합니다",
            LadderResult.MIN_RESULT_LENGTH, LadderResult.MAX_RESULT_LENGTH);
    public static final String LADDER_RESULT_INPUT_FORMAT = String.format("실행 결과는 %s로 구분하여 입력해야합니다",
            InputView.INPUT_DELIMITER);
}
