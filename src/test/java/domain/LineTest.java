package domain;

import domain.ladder.Block;
import domain.ladder.Line;
import domain.ladder.LineWeight;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

class LineTest {

    @DisplayName("라인 생성")
    @TestFactory
    Stream<DynamicTest> createSuccess() {
        return Stream.of(
            DynamicTest.dynamicTest("라인의 너비가 1인 경우(최소)", () -> {
                Line line = Line.valueOf(new LineWeight(1), () -> false);
                List<Block> blocks = line.getBlocks();
                List<Boolean> connectStatuses = blocks.stream()
                    .map(Block::isConnected)
                    .collect(Collectors.toList());
                Assertions.assertThat(connectStatuses.size()).isEqualTo(1);
                Assertions.assertThat(connectStatuses).containsExactly(false);
            }),
            DynamicTest.dynamicTest("라인의 너비가 9인 경우(최대)", () -> {
                Line line = Line.valueOf(new LineWeight(9), () -> true);
                List<Block> blocks = line.getBlocks();
                List<Boolean> connectStatuses = blocks.stream()
                    .map(Block::isConnected)
                    .collect(Collectors.toList());
                Assertions.assertThat(connectStatuses.size()).isEqualTo(9);
                Assertions.assertThat(connectStatuses)
                    .containsExactly(true, false, true, false, true, false, true, false, true);
            })
        );
    }
}
