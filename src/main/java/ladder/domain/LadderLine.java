package ladder.domain;

public class LadderLine {
    private final LadderRules direction;

    public LadderLine(LadderRules ladderRules) {
        this.direction = ladderRules;
    }

    public LadderRules direction() {
        return direction;
    }

    public int position() {
        return direction.number();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        LadderLine another = (LadderLine) obj;
        return this.direction.equals(another.direction);
    }
}
