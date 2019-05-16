package ladder.view;

import ladder.domain.Player;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputViewTest {
    @Test
    void 쉼표가두개이상있는경우테스트() {
        assertThrows(IllegalArgumentException.class, () -> InputView.validateNoConsecutiveCommas("pobi,,"));
    }

    @Test
    void 중복된이름이있는경우테스트() {
        assertThrows(IllegalArgumentException.class, () -> InputView.validateNoDuplication(Arrays.asList("pobi","pobi","crong")));
    }

    @Test
    void 이름갯수와보상갯수가다른경우테스트() {
        List<Player> players = Arrays.asList(
                new Player("pobi", 0, 3),
                new Player("crong", 1, 3),
                new Player("honux", 2, 3));
        List<String> rewards = Arrays.asList("1000", "0");
        assertThrows(IllegalArgumentException.class, () -> InputView.validateRewardsCount(rewards, players));
    }

    @Test
    void 사다리_높이가_자연수가_아닌_경우_테스트() {
        assertThrows(IllegalArgumentException.class, () -> InputView.validateNaturalNumber(0));
    }
}
