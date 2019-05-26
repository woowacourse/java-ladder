package ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Members {
    private final List<Member> members;

    public Members(final List<Member> members) {
        this.members = members;
    }

    List<Member> allMembers() {
        return new ArrayList<>(members);
    }

    public int numberOfMembers() {
        return members.size();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Members members1 = (Members) o;
        return Objects.equals(members, members1.members);
    }

    @Override
    public int hashCode() {
        return Objects.hash(members);
    }
}
