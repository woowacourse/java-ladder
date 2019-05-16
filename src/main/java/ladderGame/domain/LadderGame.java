package ladderGame.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {

    private final int height;
    private List<Floor> ladder;

    public LadderGame(int height, int userSize) {
        validatePositiveNumber(height);
        this.height = height;
        ladder = createLadder(userSize - 1);
    }

    private void validatePositiveNumber(int height) {
        if (height <= 0) {
            throw new IllegalArgumentException("숫자를 양수로 입력해주세요.");
        }
    }

    private List<Floor> createLadder(int floorSize) {
        List<Floor> ladder = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            ladder.add(new Floor(floorSize));
        }
        return ladder;
    }

    public void startLadderGame(List<User> users) {
        for (Floor floor : ladder) {
            floorMove(floor, users);
        }
    }

    private void floorMove(Floor floor, List<User> users) {
        for (User user : users) {
            user.move(floor);
        }
    }

    public int getHeight() {
        return height;
    }

    public List<Floor> getLadder() {
        return ladder;
    }
}
