package domain;

import exception.InvalidLadderHeightException;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import util.RandomBooleanGenerator;

class MapTest {

    @DisplayName("사다리 높이가 요구사항에 충족한 경우")
    @TestFactory
    Stream<DynamicTest> createMapSuccess() {
        return Stream.of(
            DynamicTest.dynamicTest("높이 1만큼의 사다리를 생성한다.(최소)", () -> {
                Map map = new Map("1", 2, new RandomBooleanGenerator());
                Assertions.assertThat(map.getLines().size()).isEqualTo(1);
            }),
            DynamicTest.dynamicTest("높이 10만큼의 사다리를 생성한다.(최대)", () -> {
                Map map = new Map("10", 2, new RandomBooleanGenerator());
                Assertions.assertThat(map.getLines().size()).isEqualTo(10);
            })
        );
    }

    @DisplayName("사다리 높이가 요구사항에 맞지 않는 경우")
    @TestFactory
    Stream<DynamicTest> createMapFail() {
        return Stream.of(
            DynamicTest.dynamicTest("높이가 null 인 경우.",
                () -> Assertions.assertThatThrownBy(() -> new Map(null, 2, new RandomBooleanGenerator()))
                    .isExactlyInstanceOf(InvalidLadderHeightException.class)),
            DynamicTest.dynamicTest("높이가 공백으로 이루어진 경우.",
                () -> Assertions.assertThatThrownBy(() -> new Map("     ", 2, new RandomBooleanGenerator()))
                    .isExactlyInstanceOf(InvalidLadderHeightException.class)),
            DynamicTest.dynamicTest("높이가 0인 경우.",
                () -> Assertions.assertThatThrownBy(() -> new Map(null, 2, new RandomBooleanGenerator()))
                    .isExactlyInstanceOf(InvalidLadderHeightException.class)),
            DynamicTest.dynamicTest("높이가 11인 경우.",
                () -> Assertions.assertThatThrownBy(() -> new Map("11", 2, new RandomBooleanGenerator()))
                    .isExactlyInstanceOf(InvalidLadderHeightException.class))
        );
    }
}
