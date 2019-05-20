package ladder.view;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {
    @Test
    void tags_입력형식_검사_콤마끝() {
        String input = "a,b,";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThrows(NoSuchElementException.class, () -> {
            InputView.inputPlayers();
        });
    }

    @Test
    void tags_입력형식_검사_콤마시작() {
        String input = ",a,b";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThrows(NoSuchElementException.class, () -> {
            InputView.inputPlayers();
        });
    }

    @Test
    void tags_입력형식_검사_콤마중복() {
        String input = "a,,b";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThrows(NoSuchElementException.class, () -> {
            InputView.inputPlayers();
        });
    }

    @Test
    void tags_입력_검사_1명() {
        String input = "abc";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThrows(NoSuchElementException.class, () -> {
            InputView.inputPlayers();
        });
    }

    @Test
    void 플레이어_입력_검사_예약어_all() {
        String input = "all,a";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThrows(NoSuchElementException.class, () -> {
            InputView.inputPlayers();
        });
    }

    @Test
    void 플레이어_입력_검사_예약어_exit() {
        String input = "exit,b";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThrows(NoSuchElementException.class, () -> {
            InputView.inputPlayers();
        });
    }
}