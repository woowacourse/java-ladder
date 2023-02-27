package laddergame.domain;

import javax.swing.text.Position;
import java.util.List;

public class Player {
    private Name name;
    private String reward;
    private int position;

    public Player(String name, int position) {
        this.name = new Name(name);
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name.getName();
    }

    public String getReward() {
        return reward;
    }

    public void move(boolean isLeftStep, boolean isRightStep) {
        if (isLeftStep) {
            position--;
            return;
        }
        if (isRightStep) {
            position++;
        }
    }

    public void matchReward(List<String> rewards) {
        this.reward = rewards.get(position);
    }

    public boolean isTarget(String name) {
        return this.name.equals(name);
    }
}
