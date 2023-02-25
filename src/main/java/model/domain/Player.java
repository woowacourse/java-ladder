package model.domain;

import model.vo.Name;
import model.vo.Position;
import model.vo.Result;

public class Player {
    private final Name name;
    private Result result;
    private Position position;

    public Player(final Name name, final Position position) {
        this.name = name;
        this.position = position;
    }

    public Name getName() {
        return name;
    }

    public Result getResult() {
        return result;
    }

    public void saveResult(final Result result) {
        this.result = result;
    }

    public boolean isSameName(Name other) {
        return this.name.isSame(other);
    }

    public boolean isSamePosition(Position other) {
        return this.position.isSame(other);
    }

    public void changePositionWith(Player otherPlayer) {
        Position temporaryPosition = otherPlayer.position;
        otherPlayer.position = this.position;
        this.position = temporaryPosition;
    }
}
