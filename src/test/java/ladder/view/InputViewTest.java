package ladder.view;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class InputViewTest {
    @Test
    void tags_입력형식_검사_콤마끝() {
        assertThrows(IllegalArgumentException.class, () -> {
            ByteArrayInputStream input = new ByteArrayInputStream("a,b,".getBytes());
            System.setIn(input);
            InputView.inputPlayers();
        });
    }

    @Test
    void tags_입력형식_검사_콤마시작() {
        assertThrows(IllegalArgumentException.class, () -> {
            ByteArrayInputStream input = new ByteArrayInputStream(",a,b".getBytes());
            System.setIn(input);
            InputView.inputPlayers();
        });
    }

    @Test
    void tags_입력형식_검사_콤마중복() {
        assertThrows(IllegalArgumentException.class, () -> {
            ByteArrayInputStream input = new ByteArrayInputStream("a,,b".getBytes());
            System.setIn(input);
            InputView.inputPlayers();
        });
    }

    @Test
    void tags_입력_검사_1명() {
        assertThrows(IllegalArgumentException.class, () -> {
            ByteArrayInputStream input = new ByteArrayInputStream("abc".getBytes());
            System.setIn(input);
            InputView.inputPlayers();
        });
    }

    @Test
    void 플레이어_입력_검사_예약어_all() {
        assertThrows(IllegalArgumentException.class, () -> {
            ByteArrayInputStream input = new ByteArrayInputStream("all,a".getBytes());
            System.setIn(input);
            InputView.inputPlayers();
        });
    }

    @Test
    void 플레이어_입력_검사_예약어_exit() {
        assertThrows(IllegalArgumentException.class, () -> {
            ByteArrayInputStream input = new ByteArrayInputStream("exit,b".getBytes());
            System.setIn(input);
            InputView.inputPlayers();
        });
    }

    @AfterEach
    void flushSTDIn() {
        System.setIn(System.in);
    }
}