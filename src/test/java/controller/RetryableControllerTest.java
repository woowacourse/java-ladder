package controller;

import common.exception.model.IOException;
import common.exception.model.ValidationException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputView;
import view.OutputView;

import java.util.Scanner;

class RetryableControllerTest {

    @Test
    @DisplayName("입력 횟수가 제한 횟수를 초과하면 예외가 발생하고 프로그램이 종료된다")
    void exitApplicationByOverReadLimitCount() {
        RetryableController retryableController = new RetryableController(new InputView(new Scanner(System.in)), new OutputView());

        Assertions.assertThatThrownBy(() -> repeatMethodOverLimitCount(retryableController))
                .isInstanceOf(IOException.class)
                .hasMessage(RetryableController.READ_LIMIT_OVER);
    }

    private void repeatMethodOverLimitCount(RetryableController retryableController) {
        retryableController.retry(() -> {
            throw new ValidationException("");
        });
    }
}