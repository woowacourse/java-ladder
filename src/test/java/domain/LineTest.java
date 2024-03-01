package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import util.TestLineItemGenerator;
import view.LineItem;

class LineTest {

    @DisplayName("사다리의 LineItem이 playerCount에 맞게 생성되는지 확인한다.")
    @Test
    void checkCreatedLineItemCount() {
        // given
        TestLineItemGenerator lineItemGenerator = new TestLineItemGenerator(LineItem.CONNECTED);
        int playerCount = 4;

        // when
        Line line = new Line(playerCount, lineItemGenerator);

        // then
        assertThat(line.getLineItems().size()).isEqualTo(playerCount-1);
    }

    @DisplayName("현재 위치에서 사다리가 옆으로 연결되어 있으면 옆으로 이동한다.")
    @ParameterizedTest
    @CsvSource({"1, 0", "3, 2"})
    void moveLineIfConnected(int position, int expected) {
        // given
        TestLineItemGenerator lineItemGenerator = new TestLineItemGenerator(LineItem.CONNECTED);
        int playerCount = 4;
        Line line = new Line(playerCount, lineItemGenerator);

        // when
        position = line.move(position);

        // then
        assertThat(position).isEqualTo(expected);
    }
}
