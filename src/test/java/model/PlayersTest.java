package model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PlayersTest {

    private static Stream<Arguments> AllLadderGamePlayerInfo() {
        return Stream.of(
                Arguments.of(new Names("pobi, neo, hiiro"),
                        new ArrayList<>(List.of(new Player(new Name("pobi")),
                                new Player(new Name("neo")), new Player(new Name("hiiro")))))
        );
    }

    @Test
    @DisplayName("Players 객체 생성 성공 테스트")
    void createPlayersTest() {
        Names names = new Names("pobi, neo, hiiro");
        assertThatNoException().isThrownBy(()->{Players players = new Players(names);});
    }

    @ParameterizedTest
    @MethodSource("AllLadderGamePlayerInfo")
    @DisplayName("사다리 게임 전체 참여자 정보 생성 기능 테스트")
    void makeAllPlayerTest(Names names, List<Player> expectedResult){
        //Given
        Players players = new Players(names);

        //Then
        IntStream.range(0, players.size()).forEach((index)->{
            assertThat(players.getPlayer(index).getName()).isEqualTo(expectedResult.get(index).getName());});
    }
}
