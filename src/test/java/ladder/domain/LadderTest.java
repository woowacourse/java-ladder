package ladder.domain;

import ladder.util.TrueGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    private Names names;
    private Bets bets;

    @BeforeEach
    void setup() {
        names = new Names(
                Arrays.asList("AAAA", "BBBB", "CCCC", "DDDD", "EEEE")
        );

        bets = new Bets(
                Arrays.asList("A", "B", "C", "D", "E"), names.size()
        );
    }

    @ParameterizedTest(name = "주어진 사다리(ladder)를 기반으로 결과의 순서를 바꾼다.")
    @ValueSource(ints = {1, 3, 5, 7, 9, 11, 13})
    void createResultSuccessTest1(int height) {
        //given
        Ladder ladder = new Ladder(names.size(), new Height(height), new TrueGenerator());

        //when
        Result result = ladder.perform(names, bets);

        //then
        List<Bet> actualBets = List.copyOf(result.getResult().values());
        assertThat(actualBets)
                .containsExactly(
                        new Bet("B"), new Bet("A"), new Bet("D"), new Bet("C"), new Bet("E")
                );
    }

    @ParameterizedTest(name = "주어진 사다리(ladder)를 기반으로 결과의 순서를 바꾼다.")
    @ValueSource(ints = {2, 4, 6, 8, 10, 12, 14})
    void createResultSuccessTest2(int height) {
        //given
        Ladder ladder = new Ladder(names.size(), new Height(height), new TrueGenerator());

        //when
        Result result = ladder.perform(names, bets);

        //then
        List<Bet> actualBets = List.copyOf(result.getResult().values());
        assertThat(actualBets)
                .containsExactly(
                        new Bet("A"), new Bet("B"), new Bet("C"), new Bet("D"), new Bet("E")
                );
    }

}
