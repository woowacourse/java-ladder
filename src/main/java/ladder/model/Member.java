package ladder.model;

import java.util.Objects;

public class Member {
    private final String name;
    private int position;

    public Member(String name, int position) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }

        this.name = name;
        this.position = position;
    }

    String getName() {
        return name;
    }

    int getPosition() {
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
}
