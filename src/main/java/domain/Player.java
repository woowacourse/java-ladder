package domain;

public class Player {

    private final Name name;
    private Position position;
    private Mission mission;

    public Player(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public int getExitIndex(Lines lines) {
        return lines.getExitIndex(this.position.getPosition());
    }

    public void setMission(Mission mission) {
        this.mission = mission;
    }

    public Name getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public Mission getMission() {
        return mission;
    }


}
