package ladder.view;

import java.util.ArrayList;
import java.util.List;
import ladder.view.model.ConsoleReaaderTest;
import ladder.view.model.Reader;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputViewTest {

    @DisplayName("이름을 ,를 기준으로 Split하여 입력 받는다.")
    @ParameterizedTest
    @ValueSource(strings = {"aru,pola,hogi,jazz", "pobi,bri, neo,jun", "pola,sangd,zzang"})
    void inputNameTest(String input) {
        Reader reader = new ConsoleReaaderTest(input);
        InputView inputView = new InputView(reader);

        Assertions.assertThat(inputView.getNames()).isEqualTo(new ArrayList<>(List.of(input.split(","))));
    }
}
