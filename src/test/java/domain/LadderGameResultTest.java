package domain;

import static org.assertj.core.api.Assertions.*;

import exception.PlayerNotInResultException;
import java.util.Map;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class LadderGameResultTest {

    @Test
    void 입력된_플레이어가_결과맵에_포함되어_있지_않으면_에러를_발생시킨다() {
        //given
        Map<Player, Prize> result = Map.of(
            new Player("ako"), new Prize("꽝"),
            new Player("maco"), new Prize("커피"));
        Player player = new Player("ash");
        LadderGameResult ladderGameResult = new LadderGameResult(result);

        //when + then
        assertThatThrownBy(() -> ladderGameResult.getPrizeOfPlayer(player))
            .isInstanceOf(PlayerNotInResultException.class);
    }

    @Test
    void 입력된_플레이어가_결과맵에_포함되어_있으면_상품을_제공한다() {
        //given
        Map<Player, Prize> result = Map.of(
            new Player("ako"), new Prize("꽝"),
            new Player("maco"), new Prize("커피"));
        Player player = new Player("ako");
        LadderGameResult ladderGameResult = new LadderGameResult(result);

        //when
        Prize prizeOfPlayer = ladderGameResult.getPrizeOfPlayer(player);

        //then
        assertThat(prizeOfPlayer).isEqualTo(result.get(player));
    }
}