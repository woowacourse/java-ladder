package view;

import domain.Line;
import domain.Link;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineRenderTest {

    @Test
    @DisplayName("사다리가 예상한 형태로 반환되는지 테스트")
    void renderLineTest() {
        final List<Link> links = List.of(Link.LINKED, Link.UNLINKED, Link.LINKED);
        final String expectedResult = "     |-----|     |-----|";
        Assertions.assertThat(LineRender.render(new Line(links)))
                .isEqualTo(expectedResult);
    }
}
