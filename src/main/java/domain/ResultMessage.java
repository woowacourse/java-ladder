package domain;

import exception.domain.ResultMessageExceptionMessage;
import java.util.List;

public class ResultMessage {

    public static final int MAX_OF_RESULT_MESSAGE_LENGTH = 5;
    List<String> resultMessage;

    public ResultMessage(List<String> resultMessage) {
        validateResultMessageLength(resultMessage);
        this.resultMessage = resultMessage;
    }

    private void validateResultMessageLength(List<String> resultMessage) {
        resultMessage.stream()
                .filter(name -> name.length() > MAX_OF_RESULT_MESSAGE_LENGTH)
                .findFirst()
                .ifPresent(name -> {
                    throw new IllegalArgumentException(ResultMessageExceptionMessage.OUT_OF_RANGE_RESULT_MESSAGE_LENGTH.getExceptionMessage());
                });
    }
}
