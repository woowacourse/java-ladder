package ladder.model;

import java.util.Objects;

public class Member {
    private final String name;
    private int position;

    public Member(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(name, member.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public void move(boolean isLinked, int lineIndex) {
        if (isLinked && (lineIndex == position)){
            this.position++;
            return;
        }
        if (isLinked && (lineIndex + 1 == position)){
            this.position--;
        }
    }
}
