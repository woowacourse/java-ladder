package laddergame.domain;

import java.util.List;

public class Player {
    private String name;
    private String reward;
    private int position;

    public Player(String name, int position){
        this.name = name;
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public String getReward() {
        return reward;
    }

    public void move(boolean isLeftStep, boolean isRightStep){
        if (isLeftStep) {
            position--;
            return ;
        }
        if (isRightStep){
            position++;
        }
    }

    public void matchReward(List<String> rewards){
        this.reward = rewards.get(position);
    }

    public boolean isTarget(String name){
        return this.name == name;
    }
}
