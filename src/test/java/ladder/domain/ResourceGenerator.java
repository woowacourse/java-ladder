package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderGenerator;
import ladder.domain.line.RandomLineGenerator;
import ladder.domain.prize.Prize;
import ladder.domain.prize.Prizes;
import ladder.domain.user.User;
import ladder.domain.user.Users;

public class ResourceGenerator {

    public static Users generateUsersWithCount(int count) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            users.add(new User("u" + i));
        }

        return new Users(users);
    }

    public static Ladder generateLadderWithWidth(int width) {
        LadderGenerator ladderGenerator = new LadderGenerator(new RandomLineGenerator());
        return ladderGenerator.generate(2, width);
    }

    public static Prizes generatePrizesWithCount(int count) {
        List<Prize> prizes = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            prizes.add(new Prize("p" + i));
        }

        return new Prizes(prizes);
    }
}
