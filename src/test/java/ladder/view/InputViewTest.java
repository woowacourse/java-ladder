package ladder.view;

import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.util.Arrays;

public class InputViewTest {
    @Test
    public void 이름_입력_테스트() {
        InputView inputView = new InputView();
        ByteArrayInputStream input = new ByteArrayInputStream("pobi,honux,crong,jk".getBytes());
        System.setIn(input);
        assertEquals(Arrays.asList("pobi", "honux", "crong", "jk"), inputView.readName());
    }

    @Test
    public void 높이_입력_테스트() {
        InputView inputView = new InputView();
        ByteArrayInputStream input = new ByteArrayInputStream("5".getBytes());
        System.setIn(input);
        assertEquals(5, inputView.readHeight());
    }

    @After
    public void flushSTDIN() {
        System.setIn(System.in);
    }
}
