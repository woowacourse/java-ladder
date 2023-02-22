package laddergame.domain;

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

    public void move(boolean isLeftStep, boolean isRightStep){
        if (isLeftStep) {
            position--;
            return ;
        }
        if (isRightStep){
            position++;
            return ;
        }
    }
}
