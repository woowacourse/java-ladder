package ladder.domain.result;

import ladder.domain.direction.Direction;
import ladder.domain.line.CustomLine;
import ladder.domain.position.Positions;
import ladder.domain.prize.Prize;
import ladder.domain.prize.Prizes;
import ladder.domain.user.User;
import ladder.domain.user.Users;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class ResultTest {

    @DisplayName("단일 라인을 가진 사다리에서 계산된 Positions로 Users와 Prizes를 매칭한 Result 객체를 생성한다.")
    @Test
    void newResultTestByPositions() {
        Users users = new Users(
                List.of(new User("ted"),
                new User("mason"),
                new User("pobi"))
        );

        int width = users.getNumberOfUsers();
        Prizes prizes = new Prizes(
                List.of(new Prize("에어팟"),
                        new Prize("꽝"),
                        new Prize("맥북")),
                width
        );

        CustomLine customLine = new CustomLine();
        customLine.addCustomDirection(Direction.RIGHT);
        customLine.addCustomDirection(Direction.LEFT);
        customLine.addCustomDirection(Direction.NEUTRAL);

        Positions nowPositions = new Positions(width);
        Positions nextPositions = nowPositions.calcPosition(customLine.getLine());

        Result result = new Result(users, prizes, nextPositions);
        List<String> prizeResult = new ArrayList<>();
        for(String userName : users.getUsersNames()) {
            prizeResult.add(result.getPrizeByUser(userName));
        }

        assertThat(prizeResult).containsExactly("꽝", "에어팟", "맥북");
    }
}