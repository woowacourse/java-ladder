package ladder.model;

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
                        Row.of(Arrays.asList(Direction.first(true), Direction.of(true, false), Direction.of(false, false))),
                        Row.of(Arrays.asList(Direction.first(false), Direction.of(false, false), Direction.of(false, false))),
                        Row.of(Arrays.asList(Direction.first(false), Direction.of(false, true), Direction.of(true, false))),
                        Row.of(Arrays.asList(Direction.first(true), Direction.of(true, false), Direction.of(false, false)))
                )
        );
    }

    @Test
    void 생성() {
        assertThat(ladder).isEqualTo(Ladder.of(
                Arrays.asList(
                        Row.of(Arrays.asList(Direction.first(true), Direction.of(true, false), Direction.of(false, false))),
                        Row.of(Arrays.asList(Direction.first(false), Direction.of(false, false), Direction.of(false, false))),
                        Row.of(Arrays.asList(Direction.first(false), Direction.of(false, true), Direction.of(true, false))),
                        Row.of(Arrays.asList(Direction.first(true), Direction.of(true, false), Direction.of(false, false)))
                )
        ));
    }

    @Test
    void Ladder_높이에_맞게_생성되는지_테스트() {
        assertThat(Ladder.nHeightLadder(2, 5).ladderStructure().size()).isEqualTo(5);
    }

    @Test
    void pkch의_결과가_꽝인지_테스트() {
        Member member = new Member("pkch", 0);
        DefaultResults results = new DefaultResults(Arrays.asList(new Result("5000"), new Result("3000"), new Result("꽝")));
        assertThat(ladder.play(member, results)).isEqualTo(new Result("꽝"));
    }
}
