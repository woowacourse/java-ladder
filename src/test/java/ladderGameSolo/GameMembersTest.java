package ladderGameSolo;

import ladderGameSolo.domain.GameMembers;
import ladderGameSolo.domain.Member;
import ladderGameSolo.domain.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameMembersTest {
    private GameMembers gameMembers;

    @BeforeEach
    void setUp() {
        List<Member> members = new ArrayList<>();

        members.add(new Member("a", new Position(2, 4), 0));
        members.add(new Member("b", new Position(1, 3), 1));

        gameMembers = new GameMembers(members);
    }

    @Test
    void 참가자_사이즈_주기() {
        assertThat(gameMembers.getSize()).isEqualTo(2);
    }
}
