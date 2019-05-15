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
        for (String name : StringUtil.splitComma(inputNames)) {
            users.add(new User(name));
        }
        return users;
    }

    public void createLadder() {
        for (int i = 0; i < height; i++) {
            ladder.add(new Floor(users.size()));
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
