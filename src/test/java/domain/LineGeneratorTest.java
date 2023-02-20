package domain;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineGeneratorTest {

    @Test
    @DisplayName("generate 메서드가 조건에 맞는 라인을 반환하는지 테스트")
    void generateTest() {
        //given
        final List<Link> input = List.of(Link.LINKED, Link.LINKED);
        final LineGenerator lineGenerator = new LineGenerator(new TestLinkGenerator(input));
        //when
        final Line line = lineGenerator.generate(4);
        //then
        Assertions.assertThat(line.getLinks())
                .containsExactly(Link.LINKED, Link.UNLINKED, Link.LINKED);
    }

    class TestLinkGenerator implements LinkGenerator {
        private final Queue<Link> links;

        public TestLinkGenerator(final List<Link> links) {
            this.links = new LinkedList<>(links);
        }

        @Override
        public Link generate() {
            return links.poll();
        }
    }
}
