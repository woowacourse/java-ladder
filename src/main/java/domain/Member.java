package domain;

import java.util.Objects;

public class Member {

    private final MemberName name;

    public Member(String rawName) {
        this.name = new MemberName(rawName);
    }

    public boolean hasSameNameWith(String value) {
        return getName().equals(value);
    }

    public String getName() {
        return name.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Member member = (Member) o;
        return Objects.equals(name, member.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
