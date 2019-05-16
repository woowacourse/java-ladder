package domain;

import util.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {

    private List<User> users;
    private List<Floor> ladder = new ArrayList<>();
    private int height;

    public LadderGame(String inputNames, int height) {
        validatePositiveNumber(height);
        this.users = createUser(inputNames);
        this.height = height;
    }

    private void validatePositiveNumber(int height) {
        if (height <= 0) {
            throw new IllegalArgumentException("숫자를 양수로 입력해주세요.");
        }
    }

    private List<User> createUser(String inputNames) {
        List<User> users = new ArrayList<>();
        List<String> names = StringUtil.splitComma(inputNames);
        for (int i = 0; i < names.size(); i++) {
            users.add(new User(names.get(i), i));
        }
        return users;
    }

    public void createLadder() {
        for (int i = 0; i < height; i++) {
            ladder.add(new Floor(users.size()));
        }
    }

    public void startLadderGame() {
        for (Floor floor : ladder) {
            canUserMove(floor);
        }
    }

    private void canUserMove(Floor floor) {
        for (User user : users) {
            user.canMove(floor);
        }
    }

    public List<User> getUsers() {
        return users;
    }

    public int getHeight() {
        return height;
    }

    public List<Floor> getLadder() {
        return ladder;
    }
}
