package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LineGeneratorTest {
    private final LineGenerator lineGenerator = new LineGenerator();

    @RepeatedTest(100)
    @DisplayName("랜덤으로 생성된 Line이 유효한지 테스트")
    void randomLineValidateTest() {
        int personCount = 4;
        final Line generatedLine = lineGenerator.generate(personCount);
        Assertions.assertDoesNotThrow(() -> validateLine(generatedLine));
    }

    @Test
    @DisplayName("Ladder의 라인이 겸치지 않으면 정상 작동")
    void unContinuousLineTest() {
        final Line line = new Line(List.of(Link.LINKED, Link.UNLINKED, Link.LINKED));
        Assertions.assertDoesNotThrow(() -> validateLine(line));
    }

    @Test
    @DisplayName("Ladder의 라인이 겸치면 예외 처리")
    void continuousLineTest() {
        final Line line = new Line(List.of(Link.LINKED, Link.LINKED, Link.LINKED));
        Assertions.assertThrows(IllegalArgumentException.class, () -> validateLine(line));
    }

    private void validateLine(final Line line) {
        Link state = Link.UNLINKED;
        for (final Link link : line.getLinks()) {
            state = comparePastPointAndPresentPoint(state, link);
        }
    }

    private Link comparePastPointAndPresentPoint(Link pastLink, final Link link) {
        if (link.isLink() && pastLink.isLink()) {
            throw new IllegalArgumentException();
        }
        pastLink = link;
        return pastLink;
    }
}
