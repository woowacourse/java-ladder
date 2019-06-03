package ladder.model;

import ladder.model.generator.DirectionsGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    Ladder ladder;

    @BeforeEach
    void setUp() {
        ladder = Ladder.of(
                Arrays.asList(
                        Row.of(DirectionsGenerator.makeDirections(Arrays.asList(true, false))),
                        Row.of(DirectionsGenerator.makeDirections(Arrays.asList(false, false))),
                        Row.of(DirectionsGenerator.makeDirections(Arrays.asList(false, true))),
                        Row.of(DirectionsGenerator.makeDirections(Arrays.asList(true, false)))
                )
        );
    }

    @Test
    void 생성() {
        assertThat(ladder).isEqualTo(Ladder.of(
                Arrays.asList(
                        Row.of(DirectionsGenerator.makeDirections(Arrays.asList(true, false))),
                        Row.of(DirectionsGenerator.makeDirections(Arrays.asList(false, false))),
                        Row.of(DirectionsGenerator.makeDirections(Arrays.asList(false, true))),
                        Row.of(DirectionsGenerator.makeDirections(Arrays.asList(true, false)))
                )
        ));
    }

    @Test
    void pkch의_결과가_꽝인지_테스트() {
        Member member = new Member("pkch", 0);
        DefaultResults results = new DefaultResults(Arrays.asList(new Result("5000"), new Result("3000"), new Result("꽝")));
        assertThat(ladder.play(member, results)).isEqualTo(new Result("꽝"));
    }
}
