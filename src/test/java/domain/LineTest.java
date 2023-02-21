package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LineTest {

    @Test
    @DisplayName("Line 생성 시 Point가 연속해서 존재하지 않으면 정상적으로 생성되고 해당 Point 목록이 Line에 저장")
    void unContinuousLineTest() {
        final List<Link> validLinks = List.of(Link.LINKED, Link.UNLINKED, Link.LINKED);
        Line line = new Line(validLinks);
        List<Link> links = line.getLinks();
        Assertions.assertEquals(validLinks, links);
    }

    @Test
    @DisplayName("Line 생성 시 Point가 연속해서 존재하면 예외 처리")
    void continuousLineTest() {
        final List<Link> links = List.of(Link.LINKED, Link.LINKED, Link.LINKED);
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Line(links));
    }
}
