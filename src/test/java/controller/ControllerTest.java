package controller;

import common.exception.message.ExceptionMessage;
import common.exception.model.IOException;
import common.exception.model.ValidationException;
import java.util.Scanner;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputView;
import view.OutputView;

class ControllerTest {

    @Test
    @DisplayName("입력 횟수가 제한 횟수를 초과하면 예외가 발생하고 프로그램이 종료된다")
    void exitApplicationByOverReadLimitCount() {
        Controller controller = new Controller(new InputView(new Scanner(System.in)), new OutputView());

        Assertions.assertThatThrownBy(() -> repeatMethodOverLimitCount(controller))
                .isInstanceOf(IOException.class)
                .hasMessage(ExceptionMessage.READ_LIMIT_OVER);
    }

    private void repeatMethodOverLimitCount(Controller controller) {
        controller.retry(() -> {
            throw new ValidationException("");
        });
    }
}
