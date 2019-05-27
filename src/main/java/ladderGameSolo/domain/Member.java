package ladderGameSolo.domain;

import java.util.Objects;

public class Member {
    private Position position;
    private int lineIndex;
    private final String name;

    public Member(String name, Position position, int lineIndex) {
        this.name = name;
        this.position = position;
        this.lineIndex = lineIndex;
    }

    public int getResultIndex(Ladder ladder) {
        while (position.isLessThanMax()) {
            this.lineIndex = ladder.getNextLine(position.getPosition(), lineIndex);
            this.position = position.nextPosition();
        }

        return lineIndex;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return position == member.position &&
                lineIndex == member.lineIndex &&
                Objects.equals(name, member.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, lineIndex, name);
    }
}
