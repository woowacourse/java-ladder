package ladderGameSolo.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GameMembers {
    private List<Member> members;

    public GameMembers(List<Member> members) {
        this.members = new ArrayList<>(members);
    }

    public int getSize() {
        return members.size();
    }

    public Member getMemberByIndex(int index) {
        return members.get(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameMembers that = (GameMembers) o;
        return Objects.equals(members, that.members);
    }

    @Override
    public int hashCode() {
        return Objects.hash(members);
    }
}
