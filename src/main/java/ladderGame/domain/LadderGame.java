package ladderGame.domain;

import java.util.List;

public class LadderGame {
    private final Ladder ladder;

    public LadderGame(Ladder ladder) {
        this.ladder = ladder;
    }

    public void startLadderGame(List<User> users) {
        for (Floor floor : ladder.getFloors()) {
            floorMove(floor, users);
        }
    }

    private void floorMove(Floor floor, List<User> users) {
        for (User user : users) {
            user.move(floor);
        }
    }
}
