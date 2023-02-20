package ladder.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

class PlayersTest {

    @Test
    @DisplayName("플레이어가 2명 미만이면 예외처리 테스트")
    void invalidSmallPlayerCountTest() {
        List<Player> input = new ArrayList<>(List.of(new Player("이오")));
        Assertions.assertThatThrownBy(() -> new Players(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("플레이어가 26명 초과면 통과하는 테스트")
    void invalidLargePlayerCountTest() {
        List<String> players = new ArrayList<>(List.of("a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,zzz".split(",")));
        List<Player> input = players.stream().map(Player::new).collect(Collectors.toList());
        Assertions.assertThatThrownBy(() -> new Players(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("플레이어가 2명 이상이면 통과하는 테스트")
    void validMinPlayerCountTest() {
        List<Player> input = new ArrayList<>(List.of(new Player("이오"), new Player("이리내")));
        assertThatCode(() -> new Players(input)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("플레이어가 26명 이하면 통과하는 테스트")
    void validMaxPlayerCountTest() {
        List<String> players = new ArrayList<>(List.of("a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z".split(",")));
        List<Player> input = players.stream().map(Player::new).collect(Collectors.toList());
        assertThatCode(() -> new Players(input)).doesNotThrowAnyException();
    }

}
