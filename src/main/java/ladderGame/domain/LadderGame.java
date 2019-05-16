package ladderGame.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {

    private List<Floor> ladder = new ArrayList<>();
    private int height;

    public LadderGame(int height) {
        validatePositiveNumber(height);
        this.height = height;
    }

    private void validatePositiveNumber(int height) {
        if (height <= 0) {
            throw new IllegalArgumentException("숫자를 양수로 입력해주세요.");
        }
    }

    public void createLadder(List<User> users) {
        for (int i = 0; i < height; i++) {
            ladder.add(new Floor(users.size()));
        }
    }

    public void startLadderGame(List<User> users) {
        for (Floor floor : ladder) {
            canUserMove(floor, users);
        }
    }

    private void canUserMove(Floor floor, List<User> users) {
        for (User user : users) {
            user.canMove(floor);
        }
    }

    public int getHeight() {
        return height;
    }

    public List<Floor> getLadder() {
        return ladder;
    }
}
