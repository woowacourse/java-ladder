package laddergame.domain;

public class Player {
    private final Name name;
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

    public void move(boolean isLeftStep, boolean isRightStep) {
        if (isLeftStep) {
            position--;
            return;
        }
        if (isRightStep) {
            position++;
        }
    }

    public boolean isTarget(String name) {
        return this.name.equals(name);
    }
}
