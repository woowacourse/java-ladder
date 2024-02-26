package controller;

import common.exception.message.ExceptionMessage;
import java.util.Scanner;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputView;
import view.OutputView;

class RetryHandlerTest {

    @Test
    @DisplayName("입력 횟수가 제한 횟수를 초과하면 예외가 발생하고 프로그램이 종료된다")
    void exitApplicationByOverReadLimitCount() {
        RetryHandler retryHandler = new RetryHandler(new InputView(new Scanner(System.in)), new OutputView());

        Assertions.assertThatThrownBy(() -> repeatMethodOverLimitCount(retryHandler))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.READ_LIMIT_OVER);
    }

    private void repeatMethodOverLimitCount(RetryHandler retryHandler) {
        retryHandler.retry(() -> {
            throw new IllegalArgumentException("");
        });
    }
}
